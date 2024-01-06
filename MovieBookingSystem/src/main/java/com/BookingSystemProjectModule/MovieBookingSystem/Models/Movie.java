package com.BookingSystemProjectModule.MovieBookingSystem.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@Entity(name = "movie")
public class Movie extends BaseModel {
    private String name;
    private String description;
    private String genre;
    @Enumerated(EnumType.ORDINAL)
    @ElementCollection
    private List<Language> languages;
    private int rating;
    @OneToMany(mappedBy = "movie", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Show> shows;


}