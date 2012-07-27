/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gsoft.controller;

import com.gsoft.dao.CitiesFacade;
import com.gsoft.dao.RegionsFacade;
import com.gsoft.model.Cities;
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
public class CitiesBean implements Serializable {

    private Cities cities;
    @EJB
    private CitiesFacade citiesDao;
    @EJB
    private RegionsFacade regionsDao;
    
    private int regionId;
    private int countryId;

    public Cities getCities() {
        return cities;
    }

    public void setCities(Cities cities) {
        this.cities = cities;
    }

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public int getRegionId() {
        return regionId;
    }

    public void setRegionId(int regionId) {
        this.regionId = regionId;
    }

    public CitiesBean() {
        cities = new Cities();
    }

    public List<Cities> findCities() {
        return citiesDao.findAll();
    }
    
    public List<Cities> findByRegion(int id) {
        return citiesDao.findByRegion(regionsDao.find(id));
    }

    public String addCity() {
        cities.setRegion(regionsDao.find(regionId));
        citiesDao.create(cities);
        return null;
    }

    public String delCity(Cities city) {
        citiesDao.remove(city);
        return null;
    }
}
