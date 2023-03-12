package br.ifsp.edu.pep.model;

import java.io.Serializable;

public class PizzaVendaPK implements Serializable {

    private int venda;
    private int pizza;

    public PizzaVendaPK() {
    }

    public PizzaVendaPK(int venda, int pizza) {
        this.venda = venda;
        this.pizza = pizza;
    }

    public int getVenda() {
        return venda;
    }

    public void setVenda(int venda) {
        this.venda = venda;
    }

    public int getPizza() {
        return pizza;
    }

    public void setPizza(int pizza) {
        this.pizza = pizza;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) venda;
        hash += (int) pizza;
        return hash;
    }

    @Override
    public boolean equals(Object object) {

        if (!(object instanceof PizzaVendaPK)) {
            return false;
        }
        PizzaVendaPK other = (PizzaVendaPK) object;
        if (this.venda != other.venda) {
            return false;
        }
        if (this.pizza != other.pizza) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.ifsp.edu.pep.model.PizzaVendaPK[ venda=" + venda + ", pizza=" + pizza + " ]";
    }

}
