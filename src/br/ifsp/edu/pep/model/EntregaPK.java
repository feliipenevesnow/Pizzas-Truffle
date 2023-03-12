package br.ifsp.edu.pep.model;

import java.io.Serializable;

public class EntregaPK implements Serializable {

    private int cliente;
    private int venda;

    public EntregaPK() {
    }

    public EntregaPK(int entregador, int venda) {
        this.cliente = entregador;
        this.venda = venda;
    }

    public int getEntregador() {
        return cliente;
    }

    public void setEntregador(int entregador) {
        this.cliente = entregador;
    }

    public int getVenda() {
        return venda;
    }

    public void setVenda(int venda) {
        this.venda = venda;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) cliente;
        hash += (int) venda;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EntregaPK)) {
            return false;
        }
        EntregaPK other = (EntregaPK) object;
        if (this.cliente != other.cliente) {
            return false;
        }
        if (this.venda != other.venda) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.ifsp.edu.pep.model.EntregaPK[ entregador=" + cliente + ", venda=" + venda + " ]";
    }

}
