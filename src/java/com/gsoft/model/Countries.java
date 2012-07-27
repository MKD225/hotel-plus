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
@Table(name = "countries")
public class Countries implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "country")
    private List<Guests> guestsList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "country")
    private List<Regions> regionsList;

    public Countries() {
    }

    public Countries(Integer id) {
        this.id = id;
    }

    public Countries(Integer id, String name) {
        this.id = id;
        this.name = name;
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

    @XmlTransient
    public List<Regions> getRegionsList() {
        return regionsList;
    }

    public void setRegionsList(List<Regions> regionsList) {
        this.regionsList = regionsList;
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
        if (!(object instanceof Countries)) {
            return false;
        }
        Countries other = (Countries) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gsoft.model.Countries[ id=" + id + " ]";
    }
    
}
