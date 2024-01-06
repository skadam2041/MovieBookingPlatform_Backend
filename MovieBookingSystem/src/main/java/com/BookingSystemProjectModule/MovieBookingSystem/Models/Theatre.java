package com.BookingSystemProjectModule.MovieBookingSystem.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@Entity(name = "theatre")
public class Theatre extends BaseModel{
    private String name;
    private String address;
    @ManyToOne
    private City city;
    @OneToMany(mappedBy = "theatre", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Auditorium> auditoriums;

}
