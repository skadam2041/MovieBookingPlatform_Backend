package com.BookingSystemProjectModule.MovieBookingSystem.Services;

import com.BookingSystemProjectModule.MovieBookingSystem.Models.*;
import com.BookingSystemProjectModule.MovieBookingSystem.Repositories.ShowRepository;
import com.BookingSystemProjectModule.MovieBookingSystem.Repositories.ShowSeatRepository;
import com.BookingSystemProjectModule.MovieBookingSystem.Repositories.TicketRepository;
import com.BookingSystemProjectModule.MovieBookingSystem.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Optional;
@Service
public class TicketService {

    @Autowired
    private ShowSeatRepository showSeatRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private ShowRepository showRepository;

    public Ticket bookTicket(List<Long> seatIds, long userId, long userId1) {
        //for seatIds get corrosponding show seats
        //check status of all seats
        //if all seats are available then lock all seats and save ticket
        //else throw exception
        //return ticket

        Optional<User> user  =   userRepository.findById(userId);
        if(user.isEmpty()){
            throw new RuntimeException("User not found");
        }

        Optional<Show> show = showRepository.findById(userId1);
        if(show.isEmpty()){
            throw new RuntimeException("Show not found");
        }

        List<ShowSeat> showSeats = getAndLokcShowSeats(seatIds);

        int price = 0;
        for(ShowSeatType showSeatType : show.get().getShowSeatTypes()){
            price += showSeatType.getPrice();
        }

        Ticket ticket = new Ticket();
        ticket.setShowSeats(showSeats);
        ticket.setBookedBy(user.get());
        ticket.setShow(show.get());
        ticket.setTimeOfBookng(new Date());
        ticket.setStatus(TicketStatus.PENDING);
        ticket.setAmount(price);
        ticketRepository.save(ticket);
        return ticket;
    }

    @Transactional(isolation = Isolation.SERIALIZABLE, timeout = 2)
    public List<ShowSeat> getAndLokcShowSeats(List<Long> seatIds)  {
        Optional<List<ShowSeat> > showSeats = showSeatRepository.findAllByIdIsIn(seatIds);
        if(showSeats.isEmpty()){
            throw new RuntimeException("No seats found");
        }

        for(ShowSeat showSeat : showSeats.get()){
            if(showSeat.getShowSeatStatus().equals(ShowSeatStatus.BOOKED)){
                throw new RuntimeException("Seat is already booked try booking other seats");
            }
        }
        for(ShowSeat showSeat : showSeats.get()){
            showSeat.setShowSeatStatus(ShowSeatStatus.LOCKED);
            showSeat.setBookedAt(new Date());
            showSeatRepository.save(showSeat);
        }
        return showSeats.get();
    }
}
