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
import javax.persistence.Lob;
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
@Table(name = "registro_clinico", catalog = "zoo", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RegistroClinico.findAll", query = "SELECT r FROM RegistroClinico r")
    , @NamedQuery(name = "RegistroClinico.findById", query = "SELECT r FROM RegistroClinico r WHERE r.id = :id")
    , @NamedQuery(name = "RegistroClinico.findByTipoAtendimento", query = "SELECT r FROM RegistroClinico r WHERE r.tipoAtendimento = :tipoAtendimento")})
public class RegistroClinico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Lob
    @Column(nullable = false, length = 2147483647)
    private String diagnostico;
    @Basic(optional = false)
    @Column(name = "tipo_atendimento", nullable = false, length = 45)
    private String tipoAtendimento;
    @Basic(optional = false)
    @Lob
    @Column(name = "observacao_geral", nullable = false, length = 2147483647)
    private String observacaoGeral;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "registroClinicoId")
    private List<Vacina> vacinaList;
    @JoinColumn(name = "boletim_saude_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private BoletimSaude boletimSaudeId;
    @JoinColumn(name = "veterinario_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Veterinario veterinarioId;

    public RegistroClinico() {
    }

    public RegistroClinico(Integer id) {
        this.id = id;
    }

    public RegistroClinico(Integer id, String diagnostico, String tipoAtendimento, String observacaoGeral) {
        this.id = id;
        this.diagnostico = diagnostico;
        this.tipoAtendimento = tipoAtendimento;
        this.observacaoGeral = observacaoGeral;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getTipoAtendimento() {
        return tipoAtendimento;
    }

    public void setTipoAtendimento(String tipoAtendimento) {
        this.tipoAtendimento = tipoAtendimento;
    }

    public String getObservacaoGeral() {
        return observacaoGeral;
    }

    public void setObservacaoGeral(String observacaoGeral) {
        this.observacaoGeral = observacaoGeral;
    }

    @XmlTransient
    public List<Vacina> getVacinaList() {
        return vacinaList;
    }

    public void setVacinaList(List<Vacina> vacinaList) {
        this.vacinaList = vacinaList;
    }

    public BoletimSaude getBoletimSaudeId() {
        return boletimSaudeId;
    }

    public void setBoletimSaudeId(BoletimSaude boletimSaudeId) {
        this.boletimSaudeId = boletimSaudeId;
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
        if (!(object instanceof RegistroClinico)) {
            return false;
        }
        RegistroClinico other = (RegistroClinico) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.RegistroClinico[ id=" + id + " ]";
    }
    
}
