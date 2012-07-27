/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gsoft.dao;

import com.gsoft.model.Price;
import com.gsoft.model.PriceSections;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author vgladky
 */
@Stateless
public class PriceFacade extends AbstractFacade<Price> {
    @PersistenceContext(unitName = "HotelPlusPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PriceFacade() {
        super(Price.class);
    }
    
    public List<Price> findBySection(PriceSections sect) {
        Query query = getEntityManager().createQuery(
                "SELECT p FROM Price p WHERE p.section = :section")
                .setParameter("section", sect);
        @SuppressWarnings("unchecked") 
        List<Price> result = query.getResultList();
        return result;
    }
    
}
