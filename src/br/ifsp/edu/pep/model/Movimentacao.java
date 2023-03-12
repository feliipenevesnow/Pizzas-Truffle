package br.ifsp.edu.pep.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "movimentacao")
@NamedQueries({
    @NamedQuery(name = "Movimentacao.findAll", query = "SELECT m FROM Movimentacao m"),
    @NamedQuery(name = "Movimentacao.findByCodigo", query = "SELECT m FROM Movimentacao m WHERE m.codigo = :codigo"),
    @NamedQuery(name = "Movimentacao.findByCaixa", query = "SELECT m FROM Movimentacao m WHERE m.caixa = :caixa"),
    @NamedQuery(name = "Movimentacao.findByValor", query = "SELECT m FROM Movimentacao m WHERE m.valor = :valor"),
    @NamedQuery(name = "Movimentacao.findByMotivo", query = "SELECT m FROM Movimentacao m WHERE m.motivo = :motivo"),
    @NamedQuery(name = "Movimentacao.findByTipo", query = "SELECT m FROM Movimentacao m WHERE m.tipo = :tipo")})
public class Movimentacao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo")
    private int codigo;
    @JoinColumn(name = "caixa", nullable = false)
    private Caixa caixa;
    @Column(name = "valor")
    private double valor;
    @Column(name = "motivo")
    private String motivo;
    @Column(name = "tipo")
    private int tipo;

    public Movimentacao() {
    }

    public Movimentacao(int codigo) {
        this.codigo = codigo;
    }

    public Movimentacao(Caixa caixa, double valor, String motivo, int tipo) {
        this.caixa = caixa;
        this.valor = valor;
        this.motivo = motivo;
        this.tipo = tipo;
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

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + this.codigo;
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
        final Movimentacao other = (Movimentacao) obj;
        return this.codigo == other.codigo;
    }

    @Override
    public String toString() {
        return "br.ifsp.edu.pep.model.Movimentacao[ codigo=" + codigo + " ]";
    }

}
