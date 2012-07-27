/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gsoft.controller;

import com.gsoft.dao.PriceFacade;
import com.gsoft.dao.PriceSectionsFacade;
import com.gsoft.model.Price;
import com.gsoft.model.PriceSections;
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
public class PriceBean implements Serializable {

    private int secId;

    public int getSecId() {
        return secId;
    }

    public void setSecId(int secId) {
        this.secId = secId;
    }
    private PriceSections sections;

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public PriceSections getSections() {
        return sections;
    }

    public void setSections(PriceSections sections) {
        this.sections = sections;
        this.secId = sections.getId();
    }
    private Price price;
    @EJB
    private PriceSectionsFacade priceSecDao;
    @EJB
    private PriceFacade priceDao;

    public PriceBean() {
        sections = new PriceSections();
        price = new Price();
        secId = 1;
    }

    public String addSection() {
        priceSecDao.create(sections);
        FacesMessage message = com.gsoft.util.Messages.getMessage("com.gsoft.messages", "sectionAdded", null);
        message.setSeverity(FacesMessage.SEVERITY_INFO);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, message);
        return null;
    }

    public String delSection(PriceSections section) {
        priceSecDao.remove(section);
        FacesMessage message = com.gsoft.util.Messages.getMessage("com.gsoft.messages", "sectionDeleted", null);
        message.setSeverity(FacesMessage.SEVERITY_INFO);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, message);
        return null;
    }

    public List<PriceSections> findSections() {
        return priceSecDao.findAll();
    }

    public String addPrice() {
        price.setSection(priceSecDao.find(secId));
        priceDao.create(price);
        FacesMessage message = com.gsoft.util.Messages.getMessage("com.gsoft.messages", "sectionAdded", null);
        message.setSeverity(FacesMessage.SEVERITY_INFO);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, message);
        return null;
    }

    public String delPrice(Price price) {
        priceDao.remove(price);
        FacesMessage message = com.gsoft.util.Messages.getMessage("com.gsoft.messages", "sectionAdded", null);
        message.setSeverity(FacesMessage.SEVERITY_INFO);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, message);
        return null;
    }

    public List<Price> findPrice() {
        return priceDao.findBySection(sections);
    }
}
