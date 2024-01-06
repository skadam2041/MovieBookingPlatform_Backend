package com.BookingSystemProjectModule.MovieBookingSystem.Models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;


import java.util.List;


@Getter
@Setter
@Entity(name = "seatType")
public class SeatType extends BaseModel{

    @OneToMany(mappedBy = "seatType", cascade = CascadeType.ALL)
    private List<Seat> seat;
    private String seatName;
    @OneToMany(mappedBy = "seatType", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ShowSeatType> showSeatType;

}
