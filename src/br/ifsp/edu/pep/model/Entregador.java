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
import javax.persistence.UniqueConstraint;

@Entity

@Table(name = "entregador", uniqueConstraints = {
    @UniqueConstraint(name = "UniqueCpfAndEmail", columnNames = {"CPF", "email"})
})
@NamedQueries({
    @NamedQuery(name = "Entregador.findAll", query = "SELECT e FROM Entregador e"),
    @NamedQuery(name = "Entregador.findByNome", query = "SELECT e FROM Entregador e WHERE e.nome like :nome"),
    @NamedQuery(name = "Entregador.findByCpf", query = "SELECT e FROM Entregador e WHERE e.cpf = :cpf"),
    @NamedQuery(name = "Entregador.findById", query = "SELECT e FROM Entregador e WHERE e.codigo = :id")
})
public class Entregador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo")
    private int codigo;
    @Column(name = "nome")
    private String nome;
    @Column(name = "endereco")
    private String endereco;
    @Column(name = "cidade")
    private String cidade;
    @Column(name = "estado")
    private String estado;
    @Column(name = "CPF")
    private String cpf;
    @Column(name = "email", unique = true)
    private String email;
    @Column(name = "contato")
    private String contato;

    public Entregador() {
    }

    public Entregador(int codigo) {
        this.codigo = codigo;
    }

    public Entregador(String nome, String endereco, String cidade, String estado, String cpf, String contato, String email) {
        this.nome = nome;
        this.endereco = endereco;
        this.cidade = cidade;
        this.estado = estado;
        this.cpf = cpf;
        this.contato = contato;
        this.email = email;
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

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
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
        final Entregador other = (Entregador) obj;
        return this.codigo == other.codigo;
    }

    @Override
    public String toString() {
        return "br.ifsp.edu.pep.model.Entregador[ codigo=" + codigo + " ]";
    }

}
