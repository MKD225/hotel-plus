/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gsoft.dao;

import com.gsoft.model.Cities;
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
public class CitiesFacade extends AbstractFacade<Cities> {

    @PersistenceContext(unitName = "HotelPlusPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CitiesFacade() {
        super(Cities.class);
    }

    public List<Cities> findByRegion(Regions region) {
        Query query = (Query) em.createQuery(
                "SELECT ct FROM Cities ct WHERE ct.region = :region").setParameter("region", region);
        @SuppressWarnings("unchecked")
        List<Cities> result = query.getResultList();
        return result;
    }
}
