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
    @NamedQuery(name = "Consulta.findAll", query = "SELECT c FROM Consulta c")
    , @NamedQuery(name = "Consulta.findById", query = "SELECT c FROM Consulta c WHERE c.id = :id")
    , @NamedQuery(name = "Consulta.findByDataAtendimento", query = "SELECT c FROM Consulta c WHERE c.dataAtendimento = :dataAtendimento")
    , @NamedQuery(name = "Consulta.findByHoraAtendimento", query = "SELECT c FROM Consulta c WHERE c.horaAtendimento = :horaAtendimento")})
public class Consulta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Column(name = "data_atendimento")
    @Temporal(TemporalType.DATE)
    private Date dataAtendimento;
    @Column(name = "hora_atendimento", length = 10)
    private String horaAtendimento;
    @JoinColumn(name = "agenda_consulta_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private AgendaConsulta agendaConsultaId;

    public Consulta() {
    }

    public Consulta(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDataAtendimento() {
        return dataAtendimento;
    }

    public void setDataAtendimento(Date dataAtendimento) {
        this.dataAtendimento = dataAtendimento;
    }

    public String getHoraAtendimento() {
        return horaAtendimento;
    }

    public void setHoraAtendimento(String horaAtendimento) {
        this.horaAtendimento = horaAtendimento;
    }

    public AgendaConsulta getAgendaConsultaId() {
        return agendaConsultaId;
    }

    public void setAgendaConsultaId(AgendaConsulta agendaConsultaId) {
        this.agendaConsultaId = agendaConsultaId;
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
        if (!(object instanceof Consulta)) {
            return false;
        }
        Consulta other = (Consulta) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Consulta[ id=" + id + " ]";
    }
    
}
