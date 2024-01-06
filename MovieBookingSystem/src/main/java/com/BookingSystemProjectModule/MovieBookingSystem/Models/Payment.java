package com.BookingSystemProjectModule.MovieBookingSystem.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity(name = "payment")
public class Payment extends BaseModel {
    private int amount;
    private Date time;
    private String refId;
    @Enumerated(EnumType.ORDINAL)
    private PaymentStatus paymentStatus;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Ticket ticket;
}