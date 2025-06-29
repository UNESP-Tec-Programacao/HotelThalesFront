/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.unesp.frontend.thales.hotel.domain;

import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Eduks
 */

@Getter @Setter
public class User {

    private UUID id;

    private String name;
 
    private Integer age;
    private String mail;
    
    private String phoneNumber;
    
    private String houseNumber;
    
    private String ibge;
    
    private String cep;
   
    private UserAddress userAddress;

    private String cpf;

}

