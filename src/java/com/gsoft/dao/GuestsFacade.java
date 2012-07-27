/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gsoft.dao;

import com.gsoft.model.Guests;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author vgladky
 */
@Stateless
public class GuestsFacade extends AbstractFacade<Guests> {

    @PersistenceContext(unitName = "HotelPlusPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GuestsFacade() {
        super(Guests.class);
    }
}
