package br.ifsp.edu.pep.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import org.eclipse.persistence.annotations.ReadOnly;

@ReadOnly
@Entity
@Table(name = "pagarEntregador")
@NamedQueries({
    @NamedQuery(name = "PagarEntregador.findAll", query = "SELECT p FROM PagarEntregador p")
})
public class PagarEntregador {

    @Id
    @Column(name = "codigo")
    private int codigo;
    @Column(name = "nome")
    private String nome;
    @Column(name = "cpf")
    private String cpf;
    @Column(name = "taxa")
    private double taxa;

    public PagarEntregador(String nome, String cpf, double taxa) {
        this.nome = nome;
        this.cpf = cpf;
        this.taxa = taxa;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public PagarEntregador() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public double getTaxa() {
        return taxa;
    }

    public void setTaxa(double taxa) {
        this.taxa = taxa;
    }

}
