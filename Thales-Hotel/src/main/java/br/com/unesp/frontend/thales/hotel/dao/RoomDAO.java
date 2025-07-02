/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.unesp.frontend.thales.hotel.dao;

import br.com.unesp.frontend.thales.hotel.domain.Room;
import br.com.unesp.frontend.thales.hotel.request.HttpClient;
import br.com.unesp.frontend.thales.hotel.response.RoomListResponse;
import br.com.unesp.frontend.thales.hotel.response.IntegerResponse;
import br.com.unesp.frontend.thales.hotel.util.IntegraSpring;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author eteixeira
 */
public class RoomDAO {

    public List<Room> returnAll() throws Exception {
        // RoomListResponse response = new RoomListResponse();
        List<Room> retorno = new ArrayList<>();

        Type responseType = new TypeToken<RoomListResponse>() {
        }.getType();

        RoomListResponse response = HttpClient.getList(
                IntegraSpring.BASE_URL + "room",
                responseType
        );
        if (response != null && response.getData() != null) {
            response.getData().forEach(room -> {
                retorno.add(room);
            });
        }

        return retorno;

    }
    
    public List<Room> returnDisponiveis() throws Exception {
        // RoomListResponse response = new RoomListResponse();
        List<Room> retorno = new ArrayList<>();

        Type responseType = new TypeToken<RoomListResponse>() {
        }.getType();

        RoomListResponse response = HttpClient.getList(
                IntegraSpring.BASE_URL + "room/available-today",
                responseType
        );
        if (response != null && response.getData() != null) {
            response.getData().forEach(room -> {
                retorno.add(room);
            });
        }

        return retorno;

    }
    
    public int returnLiberando() throws Exception {
        // RoomListResponse response = new RoomListResponse();
        Type responseType = new TypeToken<IntegerResponse>() {
        }.getType();

         IntegerResponse response = HttpClient.get(
                IntegraSpring.BASE_URL + "room/freed-today",
                IntegerResponse.class
        );
        
       
        return response.getData();
       

    }
    
}
