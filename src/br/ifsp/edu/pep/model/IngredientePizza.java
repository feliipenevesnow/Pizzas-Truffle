package br.ifsp.edu.pep.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ingrediente_pizza")
@IdClass(IngredientePizzaPK.class)
public class IngredientePizza implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @JoinColumn(name = "pizza", nullable = false)
    @ManyToOne
    private Pizza pizza;
    @Id
    @JoinColumn(name = "ingrediente", nullable = false)
    @ManyToOne
    private Ingrediente ingrediente;

    public IngredientePizza() {
    }

    public IngredientePizza(Pizza pizza, Ingrediente ingrediente, int quantidadeUnidade, Double quantidadeGramas) {
        this.pizza = pizza;
        this.ingrediente = ingrediente;
    }

    public Pizza getPizza() {
        return pizza;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }

    public Ingrediente getIngrediente() {
        return ingrediente;
    }

    public void setIngrediente(Ingrediente ingrediente) {
        this.ingrediente = ingrediente;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.pizza);
        hash = 97 * hash + Objects.hashCode(this.ingrediente);
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
        final IngredientePizza other = (IngredientePizza) obj;
        if (!Objects.equals(this.pizza, other.pizza)) {
            return false;
        }
        return Objects.equals(this.ingrediente, other.ingrediente);
    }

    @Override
    public String toString() {
        return "IngredientePizza{" + "pizza=" + pizza + ", ingrediente=" + ingrediente + '}';
    }

}
