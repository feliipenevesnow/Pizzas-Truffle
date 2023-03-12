/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ifsp.edu.pep.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Aluno
 */
@Entity
@Table(name = "pedido_online")
@NamedQueries({
    @NamedQuery(name = "PedidoOnline.findAll", query = "SELECT p FROM PedidoOnline p")})
public class PedidoOnline implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo")
    private int codigo;
    @JoinColumn(name = "venda", nullable = false)
    private Venda venda;
    @Basic(optional = false)
    @Column(name = "endereco", nullable = false, length = 60)
    private String endereco;
    @Basic(optional = false)
    @Column(name = "bairro", nullable = false, length = 60)
    private String bairro;
    @Basic(optional = false)
    @Column(name = "nome", nullable = false, length = 50)
    private String nome;

    public PedidoOnline() {
    }

    public PedidoOnline(Venda venda, String endereco, String bairro, String nome) {
        this.venda = venda;
        this.endereco = endereco;
        this.bairro = bairro;
        this.nome = nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.codigo;
        hash = 37 * hash + Objects.hashCode(this.venda);
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
        final PedidoOnline other = (PedidoOnline) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        return Objects.equals(this.venda, other.venda);
    }

}
