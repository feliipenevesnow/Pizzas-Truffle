package br.ifsp.edu.pep.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "bebida_venda")
@NamedQueries({
    @NamedQuery(name = "BebidaVenda.findAll", query = "SELECT b FROM BebidaVenda b"),
    @NamedQuery(name = "BebidaVenda.findByQuantidade", query = "SELECT b FROM BebidaVenda b WHERE b.quantidade = :quantidade"),
    @NamedQuery(name = "BebidaVenda.findBySubtotal", query = "SELECT b FROM BebidaVenda b WHERE b.subtotal = :subtotal")})
@IdClass(BebidaVendaPK.class)
public class BebidaVenda implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @JoinColumn(name = "venda", nullable = false)
    @ManyToOne
    private Venda venda;
    @Id
    @JoinColumn(name = "bebida", nullable = false)
    @ManyToOne
    private Bebida bebida;

    @Column(name = "quantidade")
    private int quantidade;

    @Column(name = "subtotal")
    private Double subtotal;

    public BebidaVenda() {
    }

    public BebidaVenda(Bebida bebida, int quantidade, Double subtotal) {
        this.bebida = bebida;
        this.quantidade = quantidade;
        this.subtotal = subtotal;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda Venda) {
        this.venda = Venda;
    }

    public Bebida getBebida() {
        return bebida;
    }

    public void setBebida(Bebida bebida) {
        this.bebida = bebida;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 43 * hash + Objects.hashCode(this.venda);
        hash = 43 * hash + Objects.hashCode(this.bebida);
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
        final BebidaVenda other = (BebidaVenda) obj;
        if (!Objects.equals(this.venda, other.venda)) {
            return false;
        }
        return Objects.equals(this.bebida, other.bebida);
    }

    @Override
    public String toString() {
        return "BebidaVenda{" + "Venda=" + venda + ", bebida=" + bebida + ", quantidade=" + quantidade + ", subtotal=" + subtotal + '}';
    }

}
