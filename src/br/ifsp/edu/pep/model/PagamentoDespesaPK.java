package br.ifsp.edu.pep.model;

import java.io.Serializable;

public class PagamentoDespesaPK implements Serializable {

    private int despesa;
    private int caixa;

    public PagamentoDespesaPK() {
    }

    public PagamentoDespesaPK(int despesaCodigo, int caixaCodigo) {
        this.despesa = despesaCodigo;
        this.caixa = caixaCodigo;
    }

    public int getDespesaCodigo() {
        return despesa;
    }

    public void setDespesaCodigo(int despesaCodigo) {
        this.despesa = despesaCodigo;
    }

    public int getCaixaCodigo() {
        return caixa;
    }

    public void setCaixaCodigo(int caixaCodigo) {
        this.caixa = caixaCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) despesa;
        hash += (int) caixa;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PagamentoDespesaPK)) {
            return false;
        }
        PagamentoDespesaPK other = (PagamentoDespesaPK) object;
        if (this.despesa != other.despesa) {
            return false;
        }
        if (this.caixa != other.caixa) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.ifsp.edu.pep.model.PagamentoDespesaPK[ despesaCodigo=" + despesa + ", caixaCodigo=" + caixa + " ]";
    }

}
