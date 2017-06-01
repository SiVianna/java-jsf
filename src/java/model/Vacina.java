/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author tiago
 */
@Entity
@Table(catalog = "zoo", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"codigo"})
    , @UniqueConstraint(columnNames = {"id"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vacina.findAll", query = "SELECT v FROM Vacina v")
    , @NamedQuery(name = "Vacina.findById", query = "SELECT v FROM Vacina v WHERE v.id = :id")
    , @NamedQuery(name = "Vacina.findByCodigo", query = "SELECT v FROM Vacina v WHERE v.codigo = :codigo")
    , @NamedQuery(name = "Vacina.findByNome", query = "SELECT v FROM Vacina v WHERE v.nome = :nome")})
public class Vacina implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(nullable = false, length = 45)
    private String codigo;
    @Basic(optional = false)
    @Column(nullable = false, length = 45)
    private String nome;
    @JoinColumn(name = "registro_clinico_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private RegistroClinico registroClinicoId;

    public Vacina() {
    }

    public Vacina(Integer id) {
        this.id = id;
    }

    public Vacina(Integer id, String codigo, String nome) {
        this.id = id;
        this.codigo = codigo;
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public RegistroClinico getRegistroClinicoId() {
        return registroClinicoId;
    }

    public void setRegistroClinicoId(RegistroClinico registroClinicoId) {
        this.registroClinicoId = registroClinicoId;
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
        if (!(object instanceof Vacina)) {
            return false;
        }
        Vacina other = (Vacina) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Vacina[ id=" + id + " ]";
    }
    
}
