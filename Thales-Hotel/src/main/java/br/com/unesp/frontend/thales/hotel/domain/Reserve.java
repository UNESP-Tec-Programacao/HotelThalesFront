/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.unesp.frontend.thales.hotel.domain;

import java.time.Instant;
import lombok.ToString;
import java.util.HashMap;

/**
 *
 * @author eteixeira
 */
@ToString
public class Reserve {

    private Long id;

    private Customer customer;

    private Room room;

    private Double price;

    private PaymentWay paymentWay;

    private Integer number;

    private Instant startsAt;

    private Instant endsAt;


    public enum PaymentWay {
        CREDIT_CARD,
        DEBIT_CARD,
        PIX,
        CASH
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public PaymentWay getPaymentWay() {
        return paymentWay;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPaymentWay(int pay) {
        
        if(pay == 0) this.paymentWay = PaymentWay.CREDIT_CARD;
        if(pay == 1) this.paymentWay = PaymentWay.DEBIT_CARD;
        if(pay == 2) this.paymentWay = PaymentWay.PIX;
        if(pay == 3) this.paymentWay = PaymentWay.CASH;
        
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Instant getStartsAt() {
        return startsAt;
    }

    public void setStartsAt(Instant startsAt) {
        this.startsAt = startsAt;
    }

    public Instant getEndsAt() {
        return endsAt;
    }

    public void setEndsAt(Instant endsAt) {
        this.endsAt = endsAt;
    }

}
