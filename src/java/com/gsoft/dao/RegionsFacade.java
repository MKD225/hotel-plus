/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gsoft.dao;

import com.gsoft.model.Countries;
import com.gsoft.model.Regions;
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
public class RegionsFacade extends AbstractFacade<Regions> {
    @PersistenceContext(unitName = "HotelPlusPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RegionsFacade() {
        super(Regions.class);
    }
    
    public List<Regions> findByCountry(Countries country) {
        Query query = em.createQuery(
                "SELECT r FROM Regions r WHERE r.country = :country")
                .setParameter("country", country);
        @SuppressWarnings("unchecked") 
        List<Regions> result = query.getResultList();
        return result;
    }
}
