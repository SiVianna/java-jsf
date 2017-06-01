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
@Table(name = "agenda_consulta", catalog = "zoo", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AgendaConsulta.findAll", query = "SELECT a FROM AgendaConsulta a")
    , @NamedQuery(name = "AgendaConsulta.findById", query = "SELECT a FROM AgendaConsulta a WHERE a.id = :id")
    , @NamedQuery(name = "AgendaConsulta.findByDataAgendamento", query = "SELECT a FROM AgendaConsulta a WHERE a.dataAgendamento = :dataAgendamento")
    , @NamedQuery(name = "AgendaConsulta.findByHorarioAgendamento", query = "SELECT a FROM AgendaConsulta a WHERE a.horarioAgendamento = :horarioAgendamento")
    , @NamedQuery(name = "AgendaConsulta.findByStatus", query = "SELECT a FROM AgendaConsulta a WHERE a.status = :status")})
public class AgendaConsulta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "data_agendamento", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataAgendamento;
    @Basic(optional = false)
    @Column(name = "horario_agendamento", nullable = false, length = 45)
    private String horarioAgendamento;
    @Basic(optional = false)
    @Column(nullable = false, length = 45)
    private String status;
    @JoinColumn(name = "animal_codigo", referencedColumnName = "codigo", nullable = false)
    @ManyToOne(optional = false)
    private Animal animalCodigo;
    @JoinColumn(name = "veterinario_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Veterinario veterinarioId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "agendaConsultaId")
    private List<Consulta> consultaList;

    public AgendaConsulta() {
    }

    public AgendaConsulta(Integer id) {
        this.id = id;
    }

    public AgendaConsulta(Integer id, Date dataAgendamento, String horarioAgendamento, String status) {
        this.id = id;
        this.dataAgendamento = dataAgendamento;
        this.horarioAgendamento = horarioAgendamento;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDataAgendamento() {
        return dataAgendamento;
    }

    public void setDataAgendamento(Date dataAgendamento) {
        this.dataAgendamento = dataAgendamento;
    }

    public String getHorarioAgendamento() {
        return horarioAgendamento;
    }

    public void setHorarioAgendamento(String horarioAgendamento) {
        this.horarioAgendamento = horarioAgendamento;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Animal getAnimalCodigo() {
        return animalCodigo;
    }

    public void setAnimalCodigo(Animal animalCodigo) {
        this.animalCodigo = animalCodigo;
    }

    public Veterinario getVeterinarioId() {
        return veterinarioId;
    }

    public void setVeterinarioId(Veterinario veterinarioId) {
        this.veterinarioId = veterinarioId;
    }

    @XmlTransient
    public List<Consulta> getConsultaList() {
        return consultaList;
    }

    public void setConsultaList(List<Consulta> consultaList) {
        this.consultaList = consultaList;
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
        if (!(object instanceof AgendaConsulta)) {
            return false;
        }
        AgendaConsulta other = (AgendaConsulta) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.AgendaConsulta[ id=" + id + " ]";
    }
    
}
