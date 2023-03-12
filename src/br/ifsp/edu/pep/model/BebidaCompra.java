package br.ifsp.edu.pep.model;

import br.ifsp.edu.pep.model.Bebida;
import br.ifsp.edu.pep.model.BebidaCompraPK;
import br.ifsp.edu.pep.model.Compra;
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
@Table(name = "bebida_compra")
@NamedQueries({
    @NamedQuery(name = "BebidaCompra.findAll", query = "SELECT b FROM BebidaCompra b"),
    @NamedQuery(name = "BebidaCompra.findByQuantidade", query = "SELECT b FROM BebidaCompra b WHERE b.quantidade = :quantidade"),
    @NamedQuery(name = "BebidaCompra.findBySubtotal", query = "SELECT b FROM BebidaCompra b WHERE b.subtotal = :subtotal")})
@IdClass(BebidaCompraPK.class)
public class BebidaCompra implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @JoinColumn(name = "compra", nullable = false)
    @ManyToOne
    private Compra compra;
    @Id
    @JoinColumn(name = "bebida", nullable = false)
    @ManyToOne
    private Bebida bebida;

    @Column(name = "quantidade")
    private int quantidade;

    @Column(name = "subtotal")
    private double subtotal;

    public BebidaCompra() {
    }

    public BebidaCompra(Compra compra, Bebida bebida, int quantidade, double subtotal) {
        this.compra = compra;
        this.bebida = bebida;
        this.quantidade = quantidade;
        this.subtotal = subtotal;
    }

    public BebidaCompra(Bebida bebida, int quantidade, double subtotal) {
        this.bebida = bebida;
        this.quantidade = quantidade;
        this.subtotal = subtotal;
    }

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
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

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.compra);
        hash = 53 * hash + Objects.hashCode(this.bebida);
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
        final BebidaCompra other = (BebidaCompra) obj;
        if (!Objects.equals(this.compra, other.compra)) {
            return false;
        }
        return Objects.equals(this.bebida, other.bebida);
    }

    @Override
    public String toString() {
        return "BebidaCompra{" + "compra=" + compra + ", bebida=" + bebida + ", quantidade=" + quantidade + ", subtotal=" + subtotal + '}';
    }

}
