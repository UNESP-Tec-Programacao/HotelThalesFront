/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.unesp.frontend.thales.hotel.response;

import br.com.unesp.frontend.thales.hotel.domain.Room;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Eduks
 */

@Getter @Setter
public class RoomListResponse {
    private int status;
    private String message;
    private List<Room> data;
}
