package br.ifsp.edu.pep.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "entrega")
@NamedQueries({
    @NamedQuery(name = "Entrega.findAll", query = "SELECT e FROM Entrega e"),
    @NamedQuery(name = "Entrega.findByStatus", query = "SELECT e FROM Entrega e WHERE e.status = :status"),
    @NamedQuery(name = "Entrega.findByEndereco", query = "SELECT e FROM Entrega e WHERE e.endereco = :endereco"),
    @NamedQuery(name = "Entrega.findByBairro", query = "SELECT e FROM Entrega e WHERE e.bairro = :bairro")
})

public class Entrega implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @JoinColumn(name = "venda", nullable = false)
    @OneToOne
    private Venda venda;
    @Column(name = "status")
    private String status;
    @Column(name = "endereco")
    private String endereco;
    @Column(name = "bairro")
    private String bairro;
    @Column(name = "taxa")
    private double taxa;
    @JoinColumn(name = "entregador", nullable = false)
    @ManyToOne
    private Entregador entregador;
    @JoinColumn(name = "cliente", nullable = true)
    @ManyToOne
    private Cliente cliente;

    public Entrega() {
    }

    public Entrega(Venda venda, String status, String endereco, String bairro, double taxa, Entregador entregador) {
        this.venda = venda;
        this.status = status;
        this.endereco = endereco;
        this.bairro = bairro;
        this.taxa = taxa;
        this.entregador = entregador;
    }

    public Entrega(Cliente cliente, String status, String endereco, String bairro, double taxa, Entregador entregador) {
        this.cliente = cliente;
        this.status = status;
        this.endereco = endereco;
        this.bairro = bairro;
        this.taxa = taxa;
        this.entregador = entregador;
    }

    public Entrega(String status, String endereco, String bairro, double taxa, Entregador entregador) {
        this.venda = venda;
        this.status = status;
        this.endereco = endereco;
        this.bairro = bairro;
        this.taxa = taxa;
        this.entregador = entregador;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public double getTaxa() {
        return taxa;
    }

    public void setTaxa(double taxa) {
        this.taxa = taxa;
    }

    public Entregador getEntregador() {
        return entregador;
    }

    public void setEntregador(Entregador entregador) {
        this.entregador = entregador;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.cliente);
        hash = 41 * hash + Objects.hashCode(this.venda);
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
        final Entrega other = (Entrega) obj;
        if (!Objects.equals(this.cliente, other.cliente)) {
            return false;
        }
        return Objects.equals(this.venda, other.venda);
    }

}
