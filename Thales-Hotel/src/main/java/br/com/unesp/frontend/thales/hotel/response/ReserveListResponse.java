/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.unesp.frontend.thales.hotel.response;

import lombok.Getter;
import lombok.Setter;
import java.util.List;
import br.com.unesp.frontend.thales.hotel.domain.Reserve;

/**
 *
 * @author eteixeira
 */

@Getter @Setter
public class ReserveListResponse {
    
    
    private int status;
    private String message;
    private List<Reserve> data;
    
}
