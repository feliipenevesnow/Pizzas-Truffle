package br.ifsp.edu.pep.model;

import br.ifsp.edu.pep.model.Compra;
import br.ifsp.edu.pep.model.Ingrediente;
import br.ifsp.edu.pep.model.IngredienteCompraPK;
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
@Table(name = "ingrediente_compra")
@NamedQueries({
    @NamedQuery(name = "IngredienteCompra.findAll", query = "SELECT i FROM IngredienteCompra i"),
    @NamedQuery(name = "IngredienteCompra.findByQuantidade", query = "SELECT i FROM IngredienteCompra i WHERE i.quantidade = :quantidade"),
    @NamedQuery(name = "IngredienteCompra.findBySubtotal", query = "SELECT i FROM IngredienteCompra i WHERE i.subtotal = :subtotal")})
@IdClass(IngredienteCompraPK.class)
public class IngredienteCompra implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @JoinColumn(name = "ingrediente", nullable = false)
    @ManyToOne
    private Ingrediente ingrediente;
    @Id
    @JoinColumn(name = "compra", nullable = false)
    @ManyToOne
    private Compra compra;
    @Column(name = "quantidade")
    private int quantidade;
    @Column(name = "subtotal")
    private double subtotal;

    public IngredienteCompra() {
    }

    public IngredienteCompra(Ingrediente ingrediente, Compra compra, int quantidade, double subtotal) {
        this.ingrediente = ingrediente;
        this.compra = compra;
        this.quantidade = quantidade;
        this.subtotal = subtotal;
    }

    public IngredienteCompra(Ingrediente ingrediente, int quantidade, double subtotal) {
        this.ingrediente = ingrediente;
        this.quantidade = quantidade;
        this.subtotal = subtotal;
    }

    public Ingrediente getIngrediente() {
        return ingrediente;
    }

    public void setIngrediente(Ingrediente ingrediente) {
        this.ingrediente = ingrediente;
    }

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
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
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.ingrediente);
        hash = 23 * hash + Objects.hashCode(this.compra);
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
        final IngredienteCompra other = (IngredienteCompra) obj;
        if (!Objects.equals(this.ingrediente, other.ingrediente)) {
            return false;
        }
        return Objects.equals(this.compra, other.compra);
    }

    @Override
    public String toString() {
        return "IngredienteCompra{" + "ingrediente=" + ingrediente + ", compra=" + compra + ", quantidade=" + quantidade + ", subtotal=" + subtotal + '}';
    }

}
