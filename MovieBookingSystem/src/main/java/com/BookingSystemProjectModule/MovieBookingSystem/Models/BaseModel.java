package com.BookingSystemProjectModule.MovieBookingSystem.Models;


import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass

public class BaseModel {
    @Id
    private long id;
}
