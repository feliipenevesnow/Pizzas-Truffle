package br.ifsp.edu.pep.model;

import java.io.Serializable;
import java.util.Objects;

public class IngredientePizzaPK implements Serializable {

    private int pizza;
    private String ingrediente;

    public IngredientePizzaPK() {
    }

    public IngredientePizzaPK(int pizza, String ingrediente) {
        this.pizza = pizza;
        this.ingrediente = ingrediente;
    }

    public int getPizza() {
        return pizza;
    }

    public void setPizza(int pizza) {
        this.pizza = pizza;
    }

    public String getIngrediente() {
        return ingrediente;
    }

    public void setIngrediente(String ingrediente) {
        this.ingrediente = ingrediente;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + this.pizza;
        hash = 29 * hash + Objects.hashCode(this.ingrediente);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IngredientePizzaPK)) {
            return false;
        }
        IngredientePizzaPK other = (IngredientePizzaPK) object;
        if (this.pizza != other.pizza) {
            return false;
        }
        if (this.ingrediente != other.ingrediente) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.ifsp.edu.pep.model.IngredientePizzaPK[ pizza=" + pizza + ", ingrediente=" + ingrediente + " ]";
    }

}
