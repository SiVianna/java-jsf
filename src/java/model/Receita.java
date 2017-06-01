/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
    @UniqueConstraint(columnNames = {"id"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Receita.findAll", query = "SELECT r FROM Receita r")
    , @NamedQuery(name = "Receita.findById", query = "SELECT r FROM Receita r WHERE r.id = :id")
    , @NamedQuery(name = "Receita.findByDataEnvio", query = "SELECT r FROM Receita r WHERE r.dataEnvio = :dataEnvio")
    , @NamedQuery(name = "Receita.findByDose", query = "SELECT r FROM Receita r WHERE r.dose = :dose")
    , @NamedQuery(name = "Receita.findByFrequenciaDeAplicacao", query = "SELECT r FROM Receita r WHERE r.frequenciaDeAplicacao = :frequenciaDeAplicacao")})
public class Receita implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "data_envio", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataEnvio;
    @Basic(optional = false)
    @Lob
    @Column(nullable = false, length = 2147483647)
    private String observacoes;
    @Basic(optional = false)
    @Column(nullable = false, length = 45)
    private String dose;
    @Basic(optional = false)
    @Column(name = "frequencia_de_aplicacao", nullable = false, length = 45)
    private String frequenciaDeAplicacao;
    @ManyToMany(mappedBy = "receitaList")
    private List<Medicamento> medicamentoList;
    @JoinColumn(name = "rotina_codigo", referencedColumnName = "codigo")
    @ManyToOne
    private Rotina rotinaCodigo;
    @JoinColumn(name = "veterinario_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Veterinario veterinarioId;

    public Receita() {
    }

    public Receita(Integer id) {
        this.id = id;
    }

    public Receita(Integer id, Date dataEnvio, String observacoes, String dose, String frequenciaDeAplicacao) {
        this.id = id;
        this.dataEnvio = dataEnvio;
        this.observacoes = observacoes;
        this.dose = dose;
        this.frequenciaDeAplicacao = frequenciaDeAplicacao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDataEnvio() {
        return dataEnvio;
    }

    public void setDataEnvio(Date dataEnvio) {
        this.dataEnvio = dataEnvio;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public String getDose() {
        return dose;
    }

    public void setDose(String dose) {
        this.dose = dose;
    }

    public String getFrequenciaDeAplicacao() {
        return frequenciaDeAplicacao;
    }

    public void setFrequenciaDeAplicacao(String frequenciaDeAplicacao) {
        this.frequenciaDeAplicacao = frequenciaDeAplicacao;
    }

    @XmlTransient
    public List<Medicamento> getMedicamentoList() {
        return medicamentoList;
    }

    public void setMedicamentoList(List<Medicamento> medicamentoList) {
        this.medicamentoList = medicamentoList;
    }

    public Rotina getRotinaCodigo() {
        return rotinaCodigo;
    }

    public void setRotinaCodigo(Rotina rotinaCodigo) {
        this.rotinaCodigo = rotinaCodigo;
    }

    public Veterinario getVeterinarioId() {
        return veterinarioId;
    }

    public void setVeterinarioId(Veterinario veterinarioId) {
        this.veterinarioId = veterinarioId;
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
        if (!(object instanceof Receita)) {
            return false;
        }
        Receita other = (Receita) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Receita[ id=" + id + " ]";
    }
    
}
