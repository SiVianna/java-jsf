/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author tiago
 */
@Entity
@Table(name = "boletim_saude", catalog = "zoo", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BoletimSaude.findAll", query = "SELECT b FROM BoletimSaude b")
    , @NamedQuery(name = "BoletimSaude.findById", query = "SELECT b FROM BoletimSaude b WHERE b.id = :id")})
public class BoletimSaude implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "boletimSaudeId")
    private List<RegistroClinico> registroClinicoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "boletimSaudeId")
    private List<Animal> animalList;

    public BoletimSaude() {
    }

    public BoletimSaude(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @XmlTransient
    public List<RegistroClinico> getRegistroClinicoList() {
        return registroClinicoList;
    }

    public void setRegistroClinicoList(List<RegistroClinico> registroClinicoList) {
        this.registroClinicoList = registroClinicoList;
    }

    @XmlTransient
    public List<Animal> getAnimalList() {
        return animalList;
    }

    public void setAnimalList(List<Animal> animalList) {
        this.animalList = animalList;
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
        if (!(object instanceof BoletimSaude)) {
            return false;
        }
        BoletimSaude other = (BoletimSaude) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.BoletimSaude[ id=" + id + " ]";
    }
    
}
