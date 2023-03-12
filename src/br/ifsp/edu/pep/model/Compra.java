package br.ifsp.edu.pep.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "compra")
@NamedQueries({
    @NamedQuery(name = "Compra.findAll", query = "SELECT c FROM Compra c"),
    @NamedQuery(name = "Compra.findByCodigo", query = "SELECT c FROM Compra c WHERE c.codigo = :codigo"),
    @NamedQuery(name = "Compra.findByCaixa", query = "SELECT c FROM Compra c WHERE c.caixa = :caixa"),
    @NamedQuery(name = "Compra.findByData", query = "SELECT c FROM Compra c WHERE c.data = :data"),
    @NamedQuery(name = "Compra.findByTotal", query = "SELECT c FROM Compra c WHERE c.total = :total")})
public class Compra implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo")
    private int codigo;
    @JoinColumn(name = "caixa", nullable = false)
    private Caixa caixa;
    @JoinColumn(name = "fornecedor", nullable = false)
    private Fornecedor fornecedor;
    @Column(name = "data")
    @Temporal(TemporalType.DATE)
    private Date data;
    @Column(name = "data_pagamento")
    @Temporal(TemporalType.DATE)
    private Date dataPagamento;
    @Column(name = "data_vencimento")
    @Temporal(TemporalType.DATE)
    private Date dataVencimento;
    @Column(name = "total")
    private double total;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "compra")
    private List<BebidaCompra> bebidas;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "compra")
    private List<IngredienteCompra> ingredientes;

    public Compra() {
    }

    public Compra(int codigo) {
        this.codigo = codigo;
    }

    public Compra(Caixa caixa, Fornecedor fornecedor, Date data, Date dataPagamento, Date dataVencimento, double total, List<BebidaCompra> bebidas, List<IngredienteCompra> ingredientes) {
        this.caixa = caixa;
        this.fornecedor = fornecedor;
        this.data = data;
        this.dataPagamento = dataPagamento;
        this.dataVencimento = dataVencimento;
        this.total = total;
        this.bebidas = bebidas;
        this.ingredientes = ingredientes;
        for (BebidaCompra b : bebidas) {
            b.setCompra(this);
        }
        for (IngredienteCompra i : ingredientes) {
            i.setCompra(this);
        }
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Caixa getCaixa() {
        return caixa;
    }

    public void setCaixa(Caixa caixa) {
        this.caixa = caixa;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public List<BebidaCompra> getBebidas() {
        return bebidas;
    }

    public void setBebidas(List<BebidaCompra> bebidas) {
        this.bebidas = bebidas;
    }

    public List<IngredienteCompra> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<IngredienteCompra> ingredientes) {
        this.ingredientes = ingredientes;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + this.codigo;
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
        final Compra other = (Compra) obj;
        return this.codigo == other.codigo;
    }

    @Override
    public String toString() {
        return "br.ifsp.edu.pep.model.Compra[ codigo=" + codigo + " ]";
    }

}
