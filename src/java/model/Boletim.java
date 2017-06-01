/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author tiago
 */
@Entity
@Table(catalog = "zoo", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Boletim.findAll", query = "SELECT b FROM Boletim b")
    , @NamedQuery(name = "Boletim.findById", query = "SELECT b FROM Boletim b WHERE b.id = :id")
    , @NamedQuery(name = "Boletim.findByData", query = "SELECT b FROM Boletim b WHERE b.data = :data")
    , @NamedQuery(name = "Boletim.findByEstadoAnimal", query = "SELECT b FROM Boletim b WHERE b.estadoAnimal = :estadoAnimal")})
public class Boletim implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date data;
    @Basic(optional = false)
    @Column(name = "estado_animal", nullable = false, length = 45)
    private String estadoAnimal;
    @Basic(optional = false)
    @Lob
    @Column(nullable = false, length = 2147483647)
    private String observacoes;
    @JoinColumn(name = "animal_codigo", referencedColumnName = "codigo", nullable = false)
    @ManyToOne(optional = false)
    private Animal animalCodigo;
    @JoinColumn(name = "tratador_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Tratador tratadorId;

    public Boletim() {
    }

    public Boletim(Integer id) {
        this.id = id;
    }

    public Boletim(Integer id, Date data, String estadoAnimal, String observacoes) {
        this.id = id;
        this.data = data;
        this.estadoAnimal = estadoAnimal;
        this.observacoes = observacoes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getEstadoAnimal() {
        return estadoAnimal;
    }

    public void setEstadoAnimal(String estadoAnimal) {
        this.estadoAnimal = estadoAnimal;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public Animal getAnimalCodigo() {
        return animalCodigo;
    }

    public void setAnimalCodigo(Animal animalCodigo) {
        this.animalCodigo = animalCodigo;
    }

    public Tratador getTratadorId() {
        return tratadorId;
    }

    public void setTratadorId(Tratador tratadorId) {
        this.tratadorId = tratadorId;
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
        if (!(object instanceof Boletim)) {
            return false;
        }
        Boletim other = (Boletim) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Boletim[ id=" + id + " ]";
    }
    
}
