/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gsoft.controller;

import com.gsoft.dao.DoctypesFacade;
import com.gsoft.model.Doctypes;
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
public class DoctypesBean implements Serializable {

    private Doctypes doctypes;
    @EJB
    DoctypesFacade doctypesDao;

    public Doctypes getDoctypes() {
        return doctypes;
    }

    public void setDoctypes(Doctypes doctypes) {
        this.doctypes = doctypes;
    }

    public DoctypesBean() {
        doctypes = new Doctypes();
    }

    public List<Doctypes> findDoctypes() {
        return doctypesDao.findAll();
    }
    
    public String addDoctype() {
        doctypesDao.create(doctypes);
        return null;
    }
    
    public String delDoctype(Doctypes doctype) {
        doctypesDao.remove(doctype);
        return null;
    }
}
