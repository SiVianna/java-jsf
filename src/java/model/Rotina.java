/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author tiago
 */
@Entity
@Table(catalog = "zoo", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"codigo"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rotina.findAll", query = "SELECT r FROM Rotina r")
    , @NamedQuery(name = "Rotina.findByCodigo", query = "SELECT r FROM Rotina r WHERE r.codigo = :codigo")
    , @NamedQuery(name = "Rotina.findByDataValidade", query = "SELECT r FROM Rotina r WHERE r.dataValidade = :dataValidade")})
public class Rotina implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer codigo;
    @Basic(optional = false)
    @Column(name = "data_validade", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataValidade;
    @JoinTable(name = "tratador_has_rotina", joinColumns = {
        @JoinColumn(name = "rotina_codigo", referencedColumnName = "codigo", nullable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "tratador_id", referencedColumnName = "id", nullable = false)})
    @ManyToMany
    private List<Tratador> tratadorList;
    @OneToMany(mappedBy = "rotinaCodigo")
    private List<Receita> receitaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rotinaCodigo")
    private List<Tarefas> tarefasList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rotinaCodigo")
    private List<Animal> animalList;

    public Rotina() {
        this.animalList = new ArrayList<>();
        this.tarefasList = new ArrayList<>();
    }

    public Rotina(Integer codigo) {
        this.codigo = codigo;
    }

    public Rotina(Integer codigo, Date dataValidade) {
        this.codigo = codigo;
        this.dataValidade = dataValidade;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Date getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(Date dataValidade) {
        this.dataValidade = dataValidade;
    }

    @XmlTransient
    public List<Tratador> getTratadorList() {
        return tratadorList;
    }

    public void setTratadorList(List<Tratador> tratadorList) {
        this.tratadorList = tratadorList;
    }

    @XmlTransient
    public List<Receita> getReceitaList() {
        return receitaList;
    }

    public void setReceitaList(List<Receita> receitaList) {
        this.receitaList = receitaList;
    }

    @XmlTransient
    public List<Tarefas> getTarefasList() {
        return tarefasList;
    }

    public void setTarefasList(List<Tarefas> tarefasList) {
        this.tarefasList = tarefasList;
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
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rotina)) {
            return false;
        }
        Rotina other = (Rotina) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Rotina[ codigo=" + codigo + " ]";
    }

}
