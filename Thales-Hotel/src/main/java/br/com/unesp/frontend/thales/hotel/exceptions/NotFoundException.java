/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.unesp.frontend.thales.hotel.exceptions;

/**
 *
 * @author Eduks
 */
public class NotFoundException extends RuntimeException {
    public NotFoundException(String message){
        super(message);
    }
}
