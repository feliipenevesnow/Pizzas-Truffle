package br.ifsp.edu.pep.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "bebida")
@NamedQueries({
    @NamedQuery(name = "Bebida.findAll", query = "SELECT b FROM Bebida b"),
    @NamedQuery(name = "Bebida.findByCodigo", query = "SELECT b FROM Bebida b WHERE b.codigo = :codigo"),
    @NamedQuery(name = "Bebida.findByNome", query = "SELECT b FROM Bebida b WHERE b.nome LIKE :nome"),
    @NamedQuery(name = "Bebida.findByPreco", query = "SELECT b FROM Bebida b WHERE b.preco = :preco"),
    @NamedQuery(name = "Bebida.findByQuantidade", query = "SELECT b FROM Bebida b WHERE b.quantidade = :quantidade")})
public class Bebida implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo")
    private int codigo;
    @Column(name = "nome")
    private String nome;
    @Column(name = "preco")
    private double preco;
    @Column(name = "quantidade")
    private int quantidade;

    public Bebida() {
    }

    public Bebida(int codigo) {
        this.codigo = codigo;
    }

    public Bebida(int codigo, String nome, double preco, int quantidade) {
        this.codigo = codigo;
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.codigo;
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
        final Bebida other = (Bebida) obj;
        return this.codigo == other.codigo;
    }

    @Override
    public String toString() {
        return "br.ifsp.edu.pep.model.Bebida[ codigo=" + codigo + " ]";
    }

}
