/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gsoft.dao;

import com.gsoft.model.Rooms;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author vgladky
 */
@Stateless
public class RoomsFacade extends AbstractFacade<Rooms> {
    @PersistenceContext(unitName = "HotelPlusPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RoomsFacade() {
        super(Rooms.class);
    }
    
}
