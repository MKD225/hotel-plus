/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gsoft.controller;

import com.gsoft.dao.CountriesFacade;
import com.gsoft.dao.RegionsFacade;
import com.gsoft.model.Regions;
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
public class RegionsBean implements Serializable {

    private Regions regions;
    @EJB
    private RegionsFacade regionsDao;
    @EJB
    private CountriesFacade countriesDao;
    private int countryId;

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public Regions getRegions() {
        return regions;
    }

    public void setRegions(Regions regions) {
        this.regions = regions;
    }

    public RegionsBean() {
        regions = new Regions();
    }

    public List<Regions> findRegions() {
        return regionsDao.findAll();
    }

    public List<Regions> findByCountry(int countryId) {
        if (countryId == 0) {
            return findRegions();
        }
        return regionsDao.findByCountry(countriesDao.find(countryId));
    }

    public String addRegion() {
        regions.setCountry(countriesDao.find(countryId));
        regionsDao.create(regions);
        return null;
    }

    public String delRegion(Regions region) {
        regionsDao.remove(region);
        return null;
    }
}
