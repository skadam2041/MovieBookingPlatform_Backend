package com.BookingSystemProjectModule.MovieBookingSystem.Models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name = "shows")
public class Show extends BaseModel{
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Movie movie;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Auditorium auditorium;
    private String startTime;
    @Enumerated(EnumType.ORDINAL)
    private ShowStatus showStatus;
    @Enumerated(EnumType.ORDINAL)
    private Language language;
    @OneToMany(mappedBy = "currentShow",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<ShowSeat> showSeats;
    @OneToMany(mappedBy = "currentShow",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<ShowSeatType> showSeatTypes; //<-- List of ShowSeatType objects, each representing a type of seat in the auditorium. Each ShowSeatType object has a name, price, and number of seats available. This list is used to populate the ShowSeatType dropdown in the Show form.




}
