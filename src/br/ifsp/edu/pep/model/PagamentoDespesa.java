package br.ifsp.edu.pep.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "pagamento_despesa")
@NamedQueries({
    @NamedQuery(name = "PagamentoDespesa.findAll", query = "SELECT p FROM PagamentoDespesa p")})
@IdClass(PagamentoDespesaPK.class)
public class PagamentoDespesa implements Serializable {

    @Id
    @JoinColumn(name = "despesa", nullable = false)
    @ManyToOne
    private Despesa despesa;
    @Id
    @JoinColumn(name = "caixa", nullable = false)
    @ManyToOne
    private Caixa caixa;

    @Column(name = "data_pagamento")
    @Temporal(TemporalType.DATE)
    private Date dataPagamento;

    public PagamentoDespesa() {
    }

    public PagamentoDespesa(Despesa despesa, Caixa caixa, Date dataPagamento) {
        this.despesa = despesa;
        this.caixa = caixa;
        this.dataPagamento = dataPagamento;
    }

    public Despesa getDespesa() {
        return despesa;
    }

    public void setDespesa(Despesa despesa) {
        this.despesa = despesa;
    }

    public Caixa getCaixa() {
        return caixa;
    }

    public void setCaixa(Caixa caixa) {
        this.caixa = caixa;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + Objects.hashCode(this.despesa);
        hash = 19 * hash + Objects.hashCode(this.caixa);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PagamentoDespesa other = (PagamentoDespesa) obj;
        if (!Objects.equals(this.despesa, other.despesa)) {
            return false;
        }
        return Objects.equals(this.caixa, other.caixa);
    }

}
