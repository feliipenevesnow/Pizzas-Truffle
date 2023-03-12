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
@Table(name = "pagamento")
@NamedQueries({
    @NamedQuery(name = "Pagamento.findAll", query = "SELECT p FROM Pagamento p"),
    @NamedQuery(name = "Pagamento.findByCodigo", query = "SELECT p FROM Pagamento p WHERE p.codigo = :codigo"),
    @NamedQuery(name = "Pagamento.findByVenda", query = "SELECT p FROM Pagamento p WHERE p.venda = :venda"),
    @NamedQuery(name = "Pagamento.findByValor", query = "SELECT p FROM Pagamento p WHERE p.valor = :valor"),
    @NamedQuery(name = "Pagamento.findByForma", query = "SELECT p FROM Pagamento p WHERE p.forma = :forma")})

public class Pagamento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo")
    private int codigo;
    @JoinColumn(name = "venda", nullable = false)
    private Venda venda;
    @Column(name = "valor")
    private double valor;
    @Column(name = "forma")
    private String forma;

    public Pagamento() {
    }

    public Pagamento(int codigo) {
        this.codigo = codigo;
    }

    public Pagamento(Venda venda, double valor) {
        this.venda = venda;
        this.valor = valor;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getForma() {
        return forma;
    }

    public void setForma(String forma) {
        this.forma = forma;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 13 * hash + this.codigo;
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
        final Pagamento other = (Pagamento) obj;
        return this.codigo == other.codigo;
    }

    @Override
    public String toString() {
        return "br.ifsp.edu.pep.model.Pagamento[ codigo=" + codigo + " ]";
    }

}
