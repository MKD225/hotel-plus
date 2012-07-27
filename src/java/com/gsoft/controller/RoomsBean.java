/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gsoft.controller;

import com.gsoft.dao.RoomsFacade;
import com.gsoft.model.Rooms;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author vgladky
 */
@Named
@SessionScoped
public class RoomsBean implements Serializable {

    private Rooms rooms;
    @EJB
    private RoomsFacade roomsDao;
    
    public RoomsBean() {
        rooms = new Rooms();
    }

    public Rooms getRooms() {
        return rooms;
    }

    public void setRooms(Rooms rooms) {
        this.rooms = rooms;
    }
    
    public List<Rooms> findRooms() {
        return roomsDao.findAll();
    }
    
    public String addRoom() {
        roomsDao.create(rooms);
        return null;
    }
    
    public String delRoom(Rooms room) {
        roomsDao.remove(room);
        return null;
    }
}
