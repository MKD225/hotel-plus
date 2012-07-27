/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gsoft.controller;

import com.gsoft.dao.CountriesFacade;
import com.gsoft.model.Countries;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author vgladky
 */
@Named("countries")
@RequestScoped
public class CountriesBean implements Serializable {

    private Countries countries;
    @EJB
    private CountriesFacade countriesDao;

    public CountriesBean() {
        countries = new Countries();
    }

    public Countries getCountries() {
        return countries;
    }

    public void setCountries(Countries countries) {
        this.countries = countries;
    }

    public List<Countries> findCountries() {
        return countriesDao.findAll();
    }

    public Countries findCountry(int id) {
        return countriesDao.find(id);
    }

    public String addCountry() {
        countriesDao.create(countries);
        FacesMessage message = com.gsoft.util.Messages.getMessage("com.gsoft.messages", "recordAdded", null);
        message.setSeverity(FacesMessage.SEVERITY_INFO);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, message);
        return null;
    }

    public String delCountry(Countries country) {
        countriesDao.remove(country);
        FacesMessage message = com.gsoft.util.Messages.getMessage("com.gsoft.messages", "recordDeleted", null);
        message.setSeverity(FacesMessage.SEVERITY_INFO);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, message);
        return null;
    }
}
