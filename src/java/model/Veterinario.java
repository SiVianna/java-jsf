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
    @UniqueConstraint(columnNames = {"CRMV"})
    , @UniqueConstraint(columnNames = {"id"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Veterinario.findAll", query = "SELECT v FROM Veterinario v")
    , @NamedQuery(name = "Veterinario.findById", query = "SELECT v FROM Veterinario v WHERE v.id = :id")
    , @NamedQuery(name = "Veterinario.findByNome", query = "SELECT v FROM Veterinario v WHERE v.nome = :nome")
    , @NamedQuery(name = "Veterinario.findByCrmv", query = "SELECT v FROM Veterinario v WHERE v.crmv = :crmv")
    , @NamedQuery(name = "Veterinario.findByDataRegistro", query = "SELECT v FROM Veterinario v WHERE v.dataRegistro = :dataRegistro")
    , @NamedQuery(name = "Veterinario.findByTelefone", query = "SELECT v FROM Veterinario v WHERE v.telefone = :telefone")
    , @NamedQuery(name = "Veterinario.findByMatricula", query = "SELECT v FROM Veterinario v WHERE v.matricula = :matricula")
    , @NamedQuery(name = "Veterinario.findBySenha", query = "SELECT v FROM Veterinario v WHERE v.senha = :senha")})
public class Veterinario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(nullable = false, length = 45)
    private String nome;
    @Basic(optional = false)
    @Column(nullable = false, length = 45)
    private String crmv;
    @Basic(optional = false)
    @Column(name = "data_registro", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataRegistro;
    @Column(length = 45)
    private String telefone;
    @JoinColumn(name = "endereco_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Endereco enderecoId;
    @Basic(optional = false)
    @Column(nullable = false, length = 45)
    private String matricula;
    @Basic(optional = false)
    @Column(nullable = false, length = 45)
    private String senha;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "veterinarioId")
    private List<Receita> receitaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "veterinarioId")
    private List<AgendaConsulta> agendaConsultaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "veterinarioId")
    private List<RegistroClinico> registroClinicoList;

    public Veterinario() {
    }

    public Veterinario(Integer id) {
        this.id = id;
    }

    public Veterinario(Integer id, String nome, String crmv, Date dataRegistro,  String matricula, String senha) {
        this.id = id;
        this.nome = nome;
        this.crmv = crmv;
        this.dataRegistro = dataRegistro;
        this.matricula = matricula;
        this.senha = senha;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCrmv() {
        return crmv;
    }

    public void setCrmv(String crmv) {
        this.crmv = crmv;
    }

    public Date getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(Date dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Endereco getEnderecoId() {
        return enderecoId;
    }

    public void setEnderecoId(Endereco enderecoId) {
        this.enderecoId = enderecoId;
    }
    
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    
    public String getSenha() {
        return senha;
    }
    
    public void setSenha(String senha) {
        this.senha = senha;
    }

    @XmlTransient
    public List<Receita> getReceitaList() {
        return receitaList;
    }

    public void setReceitaList(List<Receita> receitaList) {
        this.receitaList = receitaList;
    }

    @XmlTransient
    public List<AgendaConsulta> getAgendaConsultaList() {
        return agendaConsultaList;
    }

    public void setAgendaConsultaList(List<AgendaConsulta> agendaConsultaList) {
        this.agendaConsultaList = agendaConsultaList;
    }

    @XmlTransient
    public List<RegistroClinico> getRegistroClinicoList() {
        return registroClinicoList;
    }

    public void setRegistroClinicoList(List<RegistroClinico> registroClinicoList) {
        this.registroClinicoList = registroClinicoList;
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
        if (!(object instanceof Veterinario)) {
            return false;
        }
        Veterinario other = (Veterinario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Veterinario[ id=" + id + " ]";
    }
    
}
