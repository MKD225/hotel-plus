/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gsoft.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author vgladky
 */
@Entity
@Table(name = "price")
@NamedQueries({
    @NamedQuery(name = "Price.findAll", query = "SELECT p FROM Price p")})
public class Price implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "class1")
    private List<Rooms> roomsList;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "name")
    private String name;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "cost")
    private Float cost;
    @JoinColumn(name = "section", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private PriceSections section;

    public Price() {
    }

    public Price(Integer id) {
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

    public Float getCost() {
        return cost;
    }

    public void setCost(Float cost) {
        this.cost = cost;
    }

    public PriceSections getSection() {
        return section;
    }

    public void setSection(PriceSections section) {
        this.section = section;
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
        if (!(object instanceof Price)) {
            return false;
        }
        Price other = (Price) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gsoft.model.Price[ id=" + id + " ]";
    }

    public List<Rooms> getRoomsList() {
        return roomsList;
    }

    public void setRoomsList(List<Rooms> roomsList) {
        this.roomsList = roomsList;
    }
    
}
