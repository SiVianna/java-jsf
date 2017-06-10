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
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
    @NamedQuery(name = "Animal.findAll", query = "SELECT a FROM Animal a")
    , @NamedQuery(name = "Animal.findByCodigo", query = "SELECT a FROM Animal a WHERE a.codigo = :codigo")
    , @NamedQuery(name = "Animal.findByNome", query = "SELECT a FROM Animal a WHERE a.nome = :nome")
    , @NamedQuery(name = "Animal.findByRegiaoOrigem", query = "SELECT a FROM Animal a WHERE a.regiaoOrigem = :regiaoOrigem")
    , @NamedQuery(name = "Animal.findByDataNascimento", query = "SELECT a FROM Animal a WHERE a.dataNascimento = :dataNascimento")
    , @NamedQuery(name = "Animal.findByPeso", query = "SELECT a FROM Animal a WHERE a.peso = :peso")
    , @NamedQuery(name = "Animal.findByEspecie", query = "SELECT a FROM Animal a WHERE a.especie = :especie")})
public class Animal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer codigo;
    @Basic(optional = false)
    @Column(nullable = false, length = 255)
    private String nome;
    @Basic(optional = false)
    @Column(name = "regiao_origem", nullable = false, length = 255)
    private String regiaoOrigem;
    @Basic(optional = false)
    @Column(name = "data_nascimento", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataNascimento;
    @Basic(optional = false)
    @Column(nullable = false)
    private double peso;
    @Basic(optional = false)
    @Column(nullable = false, length = 255)
    private String especie;
    @JoinTable(name = "animal_tratador", joinColumns = {
        @JoinColumn(name = "animal_codigo", referencedColumnName = "codigo", nullable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "tratador_id", referencedColumnName = "id", nullable = false)})
    @ManyToMany
    private List<Tratador> tratadorList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "animalCodigo")
    private List<AgendaConsulta> agendaConsultaList;
    @JoinColumn(name = "boletim_saude_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = true)
    private BoletimSaude boletimSaudeId;
    @JoinColumn(name = "rotina_codigo", referencedColumnName = "codigo", nullable = false)
    @ManyToOne(optional = true)
    private Rotina rotinaCodigo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "animalCodigo")
    private List<Boletim> boletimList;

    public Animal() {
        
    }

    public Animal(Integer codigo) {
        this.codigo = codigo;
    }

    public Animal(Integer codigo, String nome, String regiaoOrigem, Date dataNascimento, double peso, String especie) {
        this.codigo = codigo;
        this.nome = nome;
        this.regiaoOrigem = regiaoOrigem;
        this.dataNascimento = dataNascimento;
        this.peso = peso;
        this.especie = especie;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRegiaoOrigem() {
        return regiaoOrigem;
    }

    public void setRegiaoOrigem(String regiaoOrigem) {
        this.regiaoOrigem = regiaoOrigem;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    @XmlTransient
    public List<Tratador> getTratadorList() {
        return tratadorList;
    }

    public void setTratadorList(List<Tratador> tratadorList) {
        this.tratadorList = tratadorList;
    }

    @XmlTransient
    public List<AgendaConsulta> getAgendaConsultaList() {
        return agendaConsultaList;
    }

    public void setAgendaConsultaList(List<AgendaConsulta> agendaConsultaList) {
        this.agendaConsultaList = agendaConsultaList;
    }

    public BoletimSaude getBoletimSaudeId() {
        return boletimSaudeId;
    }

    public void setBoletimSaudeId(BoletimSaude boletimSaudeId) {
        this.boletimSaudeId = boletimSaudeId;
    }

    public Rotina getRotinaCodigo() {
        return rotinaCodigo;
    }

    public void setRotinaCodigo(Rotina rotinaCodigo) {
        this.rotinaCodigo = rotinaCodigo;
    }

    @XmlTransient
    public List<Boletim> getBoletimList() {
        return boletimList;
    }

    public void setBoletimList(List<Boletim> boletimList) {
        this.boletimList = boletimList;
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
        if (!(object instanceof Animal)) {
            return false;
        }
        Animal other = (Animal) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Animal[ codigo=" + codigo + " ]";
    }
    
}
