package com.BookingSystemProjectModule.MovieBookingSystem.Repositories;


import com.BookingSystemProjectModule.MovieBookingSystem.Models.ShowSeat;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ShowSeatRepository extends JpaRepository<ShowSeat,Long> {

    @Override
    Optional<ShowSeat> findById(Long aLong);

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    Optional<List<ShowSeat>> findAllByIdIsIn(List<Long> showIds);
}
