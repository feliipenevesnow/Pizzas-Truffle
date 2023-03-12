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
@Table(name = "pizza_venda")
@NamedQueries({
    @NamedQuery(name = "PizzaVenda.findAll", query = "SELECT p FROM PizzaVenda p"),
    @NamedQuery(name = "PizzaVenda.findByQuantidade", query = "SELECT p FROM PizzaVenda p WHERE p.quantidade = :quantidade"),
    @NamedQuery(name = "PizzaVenda.findBySubtotal", query = "SELECT p FROM PizzaVenda p WHERE p.subtotal = :subtotal")})
@IdClass(PizzaVendaPK.class)
public class PizzaVenda implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @JoinColumn(name = "pizza", nullable = false)
    @ManyToOne
    private Pizza pizza;
    @Id
    @JoinColumn(name = "venda", nullable = false)
    @ManyToOne
    private Venda venda;
    @JoinColumn(name = "borda", nullable = false)
    private String borda;
    @Column(name = "quantidade")
    private int quantidade;
    @Column(name = "subtotal")
    private double subtotal;
    @Column(name = "descricao")
    private String descricao;

    public PizzaVenda() {
    }

    public PizzaVenda(Pizza pizza, String borda, int quantidade, double subtotal, String descricao) {
        this.pizza = pizza;
        this.borda = borda;
        this.quantidade = quantidade;
        this.subtotal = subtotal;
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Pizza getPizza() {
        return pizza;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public String getBorda() {
        return borda;
    }

    public void setBorda(String borda) {
        this.borda = borda;
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
        int hash = 3;
        hash = 71 * hash + Objects.hashCode(this.pizza);
        hash = 71 * hash + Objects.hashCode(this.venda);
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
        final PizzaVenda other = (PizzaVenda) obj;
        if (!Objects.equals(this.pizza, other.pizza)) {
            return false;
        }
        return Objects.equals(this.venda, other.venda);
    }

    @Override
    public String toString() {
        return "PizzaVenda{" + "pizza=" + pizza + ", venda=" + venda + ", borda=" + borda + ", quantidade=" + quantidade + ", subtotal=" + subtotal + '}';
    }

}
