package br.ifsp.edu.pep.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "pizza")
@NamedQueries({
    @NamedQuery(name = "Pizza.findAll", query = "SELECT p FROM Pizza p"),
    @NamedQuery(name = "Pizza.findByCodigo", query = "SELECT p FROM Pizza p WHERE p.codigo = :codigo"),
    @NamedQuery(name = "Pizza.findByNome", query = "SELECT p FROM Pizza p WHERE p.nome LIKE :nome")})
public class Pizza implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo")
    private int codigo;
    @Column(name = "nome")
    private String nome;
    @Column(name = "preco")
    private double preco;
    @Column(name = "tamanho")
    private String tamanho;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pizza")
    private List<IngredientePizza> ingredientes;

    public Pizza() {
    }

    public Pizza(int codigo) {
        this.codigo = codigo;
    }

    public Pizza(String nome, double preco, String tamanho, List<IngredientePizza> ingredientes) {
        this.nome = nome;
        this.preco = preco;
        this.tamanho = tamanho;
        this.ingredientes = ingredientes;
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

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public List<IngredientePizza> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<IngredientePizza> ingredientes) {
        this.ingredientes = ingredientes;
        for (IngredientePizza ip : ingredientes) {
            ip.setPizza(this);
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.codigo;
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
        final Pizza other = (Pizza) obj;
        return this.codigo == other.codigo;
    }

    @Override
    public String toString() {
        return "br.ifsp.edu.pep.model.Pizza[ codigo=" + codigo + " ]";
    }

}
