/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gsoft.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author vgladky
 */
@Entity
@Table(name = "doctypes")
public class Doctypes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "doctype")
    private List<Guests> guestsList;

    public Doctypes() {
    }

    public Doctypes(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public List<Guests> getGuestsList() {
        return guestsList;
    }

    public void setGuestsList(List<Guests> guestsList) {
        this.guestsList = guestsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Doctypes)) {
            return false;
        }
        Doctypes other = (Doctypes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gsoft.model.Doctypes[ id=" + id + " ]";
    }
    
}
