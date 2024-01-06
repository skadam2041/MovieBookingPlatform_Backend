package com.BookingSystemProjectModule.MovieBookingSystem.Repositories;


import com.BookingSystemProjectModule.MovieBookingSystem.Models.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowRepository extends JpaRepository<Show,Long> {
}
