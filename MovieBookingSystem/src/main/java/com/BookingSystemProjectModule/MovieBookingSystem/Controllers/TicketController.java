package com.BookingSystemProjectModule.MovieBookingSystem.Controllers;


import com.BookingSystemProjectModule.MovieBookingSystem.DTOs.BookTicketRequestDTO;
import com.BookingSystemProjectModule.MovieBookingSystem.DTOs.BookTicketResponceDTO;
import com.BookingSystemProjectModule.MovieBookingSystem.Models.Ticket;
import com.BookingSystemProjectModule.MovieBookingSystem.Services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ticket")
public class TicketController {

    @Autowired
    private TicketService ticketService;


    @PostMapping("/book")
    public BookTicketResponceDTO bookTicket(BookTicketRequestDTO bookTicketRequestDTO){
        Ticket ticket = ticketService.bookTicket(bookTicketRequestDTO.getSeatIds(),bookTicketRequestDTO.getUserId(),bookTicketRequestDTO.getUserId());
        BookTicketResponceDTO bookTicketResponceDTO = new BookTicketResponceDTO();
        return bookTicketResponceDTO;
    }
}
