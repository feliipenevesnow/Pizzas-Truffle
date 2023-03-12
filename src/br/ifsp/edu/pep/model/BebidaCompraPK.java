package br.ifsp.edu.pep.model;

import java.io.Serializable;

public class BebidaCompraPK implements Serializable {

    private int compra;
    private int bebida;

    public BebidaCompraPK() {
    }

    public BebidaCompraPK(int compra, int bebida) {
        this.compra = compra;
        this.bebida = bebida;
    }

    public int getCompra() {
        return compra;
    }

    public void setCompra(int compra) {
        this.compra = compra;
    }

    public int getBebida() {
        return bebida;
    }

    public void setBebida(int bebida) {
        this.bebida = bebida;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) compra;
        hash += (int) bebida;
        return hash;
    }

    @Override
    public boolean equals(Object object) {

        if (!(object instanceof BebidaCompraPK)) {
            return false;
        }
        BebidaCompraPK other = (BebidaCompraPK) object;
        if (this.compra != other.compra) {
            return false;
        }
        if (this.bebida != other.bebida) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.ifsp.edu.pep.model.BebidaCompraPK[ compra=" + compra + ", bebida=" + bebida + " ]";
    }

}
