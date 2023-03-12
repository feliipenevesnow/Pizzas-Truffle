package br.ifsp.edu.pep.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "venda")
@NamedQueries({
    @NamedQuery(name = "Venda.findAll", query = "SELECT v FROM Venda v"),
    @NamedQuery(name = "Venda.findInDelivering", query = "SELECT v FROM Venda v WHERE v.status = 'EM ENTREGA'"),
    @NamedQuery(name = "Venda.findInPreparation", query = "SELECT v FROM Venda v WHERE v.status = 'EM PREPARO'"),
    @NamedQuery(name = "Venda.findOnline", query = "SELECT v FROM Venda v WHERE v.status = 'ONLINE'"),
    @NamedQuery(name = "Venda.findByCodigo", query = "SELECT v FROM Venda v WHERE v.codigo = :codigo"),
    @NamedQuery(name = "Venda.findByCaixa", query = "SELECT v FROM Venda v WHERE v.caixa = :caixa"),
    @NamedQuery(name = "Venda.findByData", query = "SELECT v FROM Venda v WHERE v.data = :data"),
    @NamedQuery(name = "Venda.findByTotal", query = "SELECT v FROM Venda v WHERE v.total = :total")
})
public class Venda implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo")
    private int codigo;
    @JoinColumn(name = "caixa", nullable = false)
    private Caixa caixa;
    @Column(name = "data")
    @Temporal(TemporalType.TIMESTAMP)
    private Date data;
    @Column(name = "total")
    private double total;
    @Column(name = "desconto")
    private double desconto;
    @Column(name = "status")
    private String status;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "venda")
    private List<BebidaVenda> bebidas;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "venda")
    private List<PizzaVenda> pizzas;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "venda")
    private Entrega entrega;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "venda")
    private PedidoOnline pedido;

    public Venda() {
    }

    public Venda(Caixa caixa, Date data, double total, double desconto, String status) {
        this.caixa = caixa;
        this.data = data;
        this.total = total;
        this.desconto = desconto;
        this.status = status;
    }

    public PedidoOnline getPedido() {
        return pedido;
    }

    public void setPedido(PedidoOnline pedido) {
        this.pedido = pedido;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Caixa getCaixa() {
        return caixa;
    }

    public void setCaixa(Caixa caixa) {
        this.caixa = caixa;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<BebidaVenda> getBebidas() {
        return bebidas;
    }

    public void setBebidas(List<BebidaVenda> bebidas) {
        this.bebidas = bebidas;
        for (BebidaVenda bv : bebidas) {
            bv.setVenda(this);
        }
    }

    public List<PizzaVenda> getPizzas() {
        return pizzas;
    }

    public void setPizzas(List<PizzaVenda> pizzas) {
        this.pizzas = pizzas;
        for (PizzaVenda pv : pizzas) {
            pv.setVenda(this);
        }
    }

    public Entrega getEntrega() {
        return entrega;
    }

    public void setEntrega(Entrega entrega) {
        this.entrega = entrega;
        this.entrega.setVenda(this);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + this.codigo;
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
        final Venda other = (Venda) obj;
        return this.codigo == other.codigo;
    }

    @Override
    public String toString() {
        return "br.ifsp.edu.pep.model.Venda[ codigo=" + codigo + " ]";
    }

}
