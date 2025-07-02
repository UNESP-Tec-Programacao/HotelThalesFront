/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.unesp.frontend.thales.hotel.domain;

import lombok.Getter;
import lombok.Setter;
import java.time.Instant;

/**
 *
 * @author eteixeira
 */
@Getter @Setter
public class Reserve {
    
    private Long id;

    private Customer customer;

    private Room room;

    private Double price;

    private PaymentWay paymentWay;

    private Integer number;

    private Instant  startsAt;

    private Instant endsAt;
    
    public enum PaymentWay {
        CREDIT_CARD,
        DEBIT_CARD,
        PIX,
        CASH
    }
    
}
