package com.BookingSystemProjectModule.MovieBookingSystem.Repositories;

import com.BookingSystemProjectModule.MovieBookingSystem.Models.ShowSeatType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowSeatTypeRepository extends JpaRepository<ShowSeatType,Long> {
}
