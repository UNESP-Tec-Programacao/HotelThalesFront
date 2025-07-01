/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.unesp.frontend.thales.hotel.domain;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Eduks
 */
@Getter @Setter
public class Customer {
    
    private Long id;

    private String name;

    private String identify;

    private String phoneNumber;

    private String mail;

    private Integer age;

    public Customer(String name, String identify, String phoneNumber, String mail, Integer age) {
        this.name = name;
        this.identify = identify;
        this.phoneNumber = phoneNumber;
        this.mail = mail;
        this.age = age;
    }

    public Customer(){}
}
