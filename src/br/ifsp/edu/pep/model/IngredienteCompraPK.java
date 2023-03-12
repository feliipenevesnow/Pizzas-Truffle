package br.ifsp.edu.pep.model;

import java.io.Serializable;

public class IngredienteCompraPK implements Serializable {

    private int compra;
    private String ingrediente;

    public IngredienteCompraPK() {
    }

    public IngredienteCompraPK(int compra, String ingrediente) {
        this.compra = compra;
        this.ingrediente = ingrediente;
    }

    public int getCompra() {
        return compra;
    }

    public void setCompra(int compra) {
        this.compra = compra;
    }

    public String getIngrediente() {
        return ingrediente;
    }

    public void setIngrediente(String ingrediente) {
        this.ingrediente = ingrediente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) compra;
        hash += (ingrediente != null ? ingrediente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {

        if (!(object instanceof IngredienteCompraPK)) {
            return false;
        }
        IngredienteCompraPK other = (IngredienteCompraPK) object;
        if (this.compra != other.compra) {
            return false;
        }
        if ((this.ingrediente == null && other.ingrediente != null) || (this.ingrediente != null && !this.ingrediente.equals(other.ingrediente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.ifsp.edu.pep.model.IngredienteCompraPK[ compra=" + compra + ", ingrediente=" + ingrediente + " ]";
    }

}
