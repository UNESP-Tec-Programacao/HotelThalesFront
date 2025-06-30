/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.unesp.frontend.thales.hotel.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Eduks
 */
@Getter @Setter
public class Room {

    private Long id;

    private String name;

    private String category;

    private Double price;

    private Integer floor;

    private Integer number;

    public Room(String name, String category, Double price, Integer floor, Integer number) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.floor = floor;
        this.number = number;
    }
    
    public Room(){}
    
    
    
}
