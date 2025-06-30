/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.unesp.frontend.thales.hotel.response;

import lombok.Getter;
import lombok.Setter;
import br.com.unesp.frontend.thales.hotel.domain.Room;

/**
 *
 * @author Eduks
 */

@Getter @Setter
public class RoomResponse {
    
    private int status;
    private String message;
    private Room data;
    
}
