/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gsoft.controller;

import com.gsoft.dao.*;
import com.gsoft.model.*;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author vgladky
 */
@Named
@SessionScoped
public class GuestsBean implements Serializable {

    // Entity-модель
    private Guests guests;
    private int countryId;
    private int regionId;
    private int cityId;
    private int doctypeId;
    private Integer guestId;

    public Integer getGuestId() {
        return guestId;
    }

    public void setGuestId(Integer guestId) {
        this.guestId = guestId;
    }
    @EJB // об'єкт доступу до даних. Бін EJB
    private GuestsFacade guestsDao;
    @EJB
    private CountriesFacade countriesDao;
    @EJB
    private RegionsFacade regionsDao;
    @EJB
    private CitiesFacade citiesDao;
    @EJB
    private DoctypesFacade doctypesDao;

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public int getDoctypeId() {
        return doctypeId;
    }

    public void setDoctypeId(int doctypeId) {
        this.doctypeId = doctypeId;
    }

    public int getRegionId() {
        return regionId;
    }

    public void setRegionId(int regionId) {
        this.regionId = regionId;
    }

    // Конструктор
    public GuestsBean() {
        guests = new Guests();
        guestId = null;
    }

    public Guests getGuests() {
        return guests;
    }

    public void setGuests(Guests guests) {
        this.setCountryId(guests.getCountry().getId());
        this.setRegionId(guests.getRegion().getId());
        this.setCityId(guests.getCity().getId());
        this.setDoctypeId(guests.getDoctype().getId());
        this.setGuestId(guests.getId());
        this.guests = guests;
    }

    public List<Guests> getAll() {
        return guestsDao.findAll();
    }

    public String delGuest(Guests guest) {
        guestsDao.remove(guest);
        FacesMessage message = com.gsoft.util.Messages.getMessage("com.gsoft.messages", "clientDeleted", null);
        message.setSeverity(FacesMessage.SEVERITY_INFO);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, message);
        return null;
    }

    public String saveGuest() {
        guests.setCountry(countriesDao.find(countryId));
        guests.setRegion(regionsDao.find(regionId));
        guests.setCity(citiesDao.find(cityId));
        guests.setDoctype(doctypesDao.find(doctypeId));
        if (guestId != null) {
            guests.setId(this.getGuestId());
            guestsDao.edit(guests);
        } else {
            guestsDao.create(guests);
        }
        FacesMessage message = com.gsoft.util.Messages.getMessage("com.gsoft.messages", "clientAdded", null);
        message.setSeverity(FacesMessage.SEVERITY_INFO);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, message);
        return null;
    }

    public String newGuest() {
        guests = new Guests();
        guestId = null;
        return null;
    }

    public List<Doctypes> findDoctypes() {
        return doctypesDao.findAll();
    }
}
