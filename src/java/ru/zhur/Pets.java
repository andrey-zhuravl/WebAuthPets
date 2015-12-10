/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.zhur;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Andrey77
 */
@Entity
@Table(name = "pets")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pets.findAll", query = "SELECT p FROM Pets p"),
    @NamedQuery(name = "Pets.findByPetsName", query = "SELECT p FROM Pets p WHERE p.petsName = :petsName"),
    @NamedQuery(name = "Pets.findById", query = "SELECT p FROM Pets p WHERE p.id = :id"),
    @NamedQuery(name = "Pets.findByGender", query = "SELECT p FROM Pets p WHERE p.gender = :gender"),
    @NamedQuery(name = "Pets.findByBirthday", query = "SELECT p FROM Pets p WHERE p.birthday = :birthday"),
    @NamedQuery(name = "Pets.findByAnamalId", query = "SELECT p FROM Pets p WHERE p.anamalId = :anamalId"),
    @NamedQuery(name = "Pets.findByOwner", query = "SELECT p FROM Pets p WHERE p.owner = :owner")})
public class Pets implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "pets_name")
    private String petsName;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Short id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "gender")
    private Character gender;
    @Column(name = "birthday")
    @Temporal(TemporalType.DATE)
    private Date birthday;
    @Basic(optional = false)
    @NotNull
    @Column(name = "anamal_id")
    private short anamalId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "owner")
    private String owner;

    public Pets() {
    }

    public Pets(Short id) {
        this.id = id;
    }

    public Pets(Short id, String petsName, Character gender, short anamalId, String owner) {
        this.id = id;
        this.petsName = petsName;
        this.gender = gender;
        this.anamalId = anamalId;
        this.owner = owner;
    }

    public String getPetsName() {
        return petsName;
    }

    public void setPetsName(String petsName) {
        this.petsName = petsName;
    }

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public Character getGender() {
        return gender;
    }

    public void setGender(Character gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public short getAnamalId() {
        return anamalId;
    }

    public void setAnamalId(short anamalId) {
        this.anamalId = anamalId;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
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
        if (!(object instanceof Pets)) {
            return false;
        }
        Pets other = (Pets) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ru.zhur.Pets[ id=" + id + " ]";
    }
    
}
