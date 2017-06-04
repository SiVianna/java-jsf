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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author tiago
 */
@Entity
@Table(catalog = "zoo", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id"})
    , @UniqueConstraint(columnNames = {"matricula"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tratador.findAll", query = "SELECT t FROM Tratador t")
    , @NamedQuery(name = "Tratador.findById", query = "SELECT t FROM Tratador t WHERE t.id = :id")
    , @NamedQuery(name = "Tratador.findByMatricula", query = "SELECT t FROM Tratador t WHERE t.matricula = :matricula")
    , @NamedQuery(name = "Tratador.findByNome", query = "SELECT t FROM Tratador t WHERE t.nome = :nome")
    , @NamedQuery(name = "Tratador.findByTelefone", query = "SELECT t FROM Tratador t WHERE t.telefone = :telefone")
    , @NamedQuery(name = "Tratador.findBySenha", query = "SELECT t FROM Tratador t WHERE t.senha = :senha")})
public class Tratador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(nullable = false, length = 45)
    private String matricula;
    @Basic(optional = false)
    @Column(nullable = false, length = 255)
    private String nome;
    @Basic(optional = false)
    @Column(nullable = false, length = 45)
    private String telefone;
    @Basic(optional = false)
    @Column(nullable = false, length = 45)
    private String senha;
    @ManyToMany(mappedBy = "tratadorList")
    private List<Animal> animalList;
    @ManyToMany(mappedBy = "tratadorList")
    private List<Rotina> rotinaList;
    @JoinColumn(name = "endereco_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false,cascade = CascadeType.PERSIST)
    private Endereco enderecoId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tratadorId")
    private List<Boletim> boletimList;

    public Tratador() {
        this.enderecoId = new Endereco();
    }

    public Tratador(Integer id) {
        this.id = id;
    }

    public Tratador(Integer id, String matricula, String nome, String telefone, String senha) {
        this.id = id;
        this.matricula = matricula;
        this.nome = nome;
        this.telefone = telefone;
        this.senha = senha;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @XmlTransient
    public List<Animal> getAnimalList() {
        return animalList;
    }

    public void setAnimalList(List<Animal> animalList) {
        this.animalList = animalList;
    }

    @XmlTransient
    public List<Rotina> getRotinaList() {
        return rotinaList;
    }

    public void setRotinaList(List<Rotina> rotinaList) {
        this.rotinaList = rotinaList;
    }

    public Endereco getEnderecoId() {
        return enderecoId;
    }

    public void setEnderecoId(Endereco enderecoId) {
        this.enderecoId = enderecoId;
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
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tratador)) {
            return false;
        }
        Tratador other = (Tratador) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Tratador[ id=" + id + " ]";
    }
    
}
