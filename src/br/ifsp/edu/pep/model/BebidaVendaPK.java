package br.ifsp.edu.pep.model;

import java.io.Serializable;

public class BebidaVendaPK implements Serializable {

    private int venda;
    private int bebida;

    public BebidaVendaPK() {
    }

    public BebidaVendaPK(int venda, int bebida) {
        this.venda = venda;
        this.bebida = bebida;
    }

    public int getVenda() {
        return venda;
    }

    public void setVenda(int venda) {
        this.venda = venda;
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
        hash += (int) venda;
        hash += (int) bebida;
        return hash;
    }

    @Override
    public boolean equals(Object object) {

        if (!(object instanceof BebidaVendaPK)) {
            return false;
        }
        BebidaVendaPK other = (BebidaVendaPK) object;
        if (this.venda != other.venda) {
            return false;
        }
        if (this.bebida != other.bebida) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.ifsp.edu.pep.model.BebidaVendaPK[ venda=" + venda + ", bebida=" + bebida + " ]";
    }

}
