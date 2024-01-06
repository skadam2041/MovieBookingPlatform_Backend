package com.BookingSystemProjectModule.MovieBookingSystem.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@Entity(name = "auditorium")
public class Auditorium extends BaseModel{

    @OneToMany(mappedBy = "auditorium", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Seat> seats;
    private String name;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Theatre theatre;
    @OneToMany(mappedBy = "auditorium")
    private List<Show> shows;
    @Enumerated(EnumType.STRING)
    @ElementCollection
    private List<Features> features;
}
