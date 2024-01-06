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
    private Language language;;


}
