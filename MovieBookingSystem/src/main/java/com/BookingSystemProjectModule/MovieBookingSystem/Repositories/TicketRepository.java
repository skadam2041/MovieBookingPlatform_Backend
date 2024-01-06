package com.BookingSystemProjectModule.MovieBookingSystem.Repositories;

import com.BookingSystemProjectModule.MovieBookingSystem.Models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket,Long> {

}
