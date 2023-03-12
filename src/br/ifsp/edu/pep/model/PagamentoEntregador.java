package br.ifsp.edu.pep.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "pagamento_entregador")
@NamedQueries({
    @NamedQuery(name = "PagamentoEntregador.findAll", query = "SELECT p FROM PagamentoEntregador p"),
    @NamedQuery(name = "PagamentoEntregador.findByCodigo", query = "SELECT p FROM PagamentoEntregador p WHERE p.codigo = :codigo"),
    @NamedQuery(name = "PagamentoEntregador.findByEntregador", query = "SELECT p FROM PagamentoEntregador p WHERE p.entregador = :entregador"),
    @NamedQuery(name = "PagamentoEntregador.findByValor", query = "SELECT p FROM PagamentoEntregador p WHERE p.valor = :valor"),
    @NamedQuery(name = "PagamentoEntregador.findByData", query = "SELECT p FROM PagamentoEntregador p WHERE p.data = :data")})
public class PagamentoEntregador implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo")
    private Integer codigo;
    @JoinColumn(name = "entregador")
    private Entregador entregador;
    @Column(name = "valor")
    private double valor;
    @Column(name = "data")
    @Temporal(TemporalType.DATE)
    private Date data;

    public PagamentoEntregador() {
    }

    public PagamentoEntregador(Integer codigo) {
        this.codigo = codigo;
    }

    public PagamentoEntregador(Entregador entregador, double valor, Date data) {
        this.entregador = entregador;
        this.valor = valor;
        this.data = data;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Entregador getEntregador() {
        return entregador;
    }

    public void setEntregador(Entregador entregador) {
        this.entregador = entregador;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + Objects.hashCode(this.codigo);
        return hash;
    }

    @Override
    public boolean equals(Object object) {

        if (!(object instanceof PagamentoEntregador)) {
            return false;
        }
        PagamentoEntregador other = (PagamentoEntregador) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PagamentoEntregador{" + "codigo=" + codigo + ", entregador=" + entregador + ", valor=" + valor + ", data=" + data + '}';
    }

}
