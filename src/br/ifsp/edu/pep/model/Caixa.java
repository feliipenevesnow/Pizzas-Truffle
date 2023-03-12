package br.ifsp.edu.pep.model;

import java.io.Serializable;
import java.util.Date;

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
@Table(name = "caixa")
@NamedQueries({
    @NamedQuery(name = "Caixa.findAll", query = "SELECT c FROM Caixa c"),
    @NamedQuery(name = "Caixa.findOpen", query = "SELECT c FROM Caixa c WHERE c.dataFechamento = NULL"),
    @NamedQuery(name = "Caixa.findByCodigo", query = "SELECT c FROM Caixa c WHERE c.codigo = :codigo"),
    @NamedQuery(name = "Caixa.findByUsuario", query = "SELECT c FROM Caixa c WHERE c.usuario = :usuario"),
    @NamedQuery(name = "Caixa.findByDataAbertura", query = "SELECT c FROM Caixa c WHERE c.dataAbertura = :dataAbertura"),
    @NamedQuery(name = "Caixa.findByDataFechamento", query = "SELECT c FROM Caixa c WHERE c.dataFechamento = :dataFechamento"),
    @NamedQuery(name = "Caixa.findByHorarioAbertura", query = "SELECT c FROM Caixa c WHERE c.horarioAbertura = :horarioAbertura"),
    @NamedQuery(name = "Caixa.findByHorarioFechamento", query = "SELECT c FROM Caixa c WHERE c.horarioFechamento = :horarioFechamento"),
    @NamedQuery(name = "Caixa.findByValorInicial", query = "SELECT c FROM Caixa c WHERE c.valorInicial = :valorInicial"),
    @NamedQuery(name = "Caixa.findByValorFinal", query = "SELECT c FROM Caixa c WHERE c.valorFinal = :valorFinal")})
public class Caixa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo")
    private int codigo;
    @JoinColumn(name = "usuario", nullable = false)
    private Usuario usuario;
    @Column(name = "data_abertura")
    @Temporal(TemporalType.DATE)
    private Date dataAbertura;
    @Column(name = "data_fechamento")
    @Temporal(TemporalType.DATE)
    private Date dataFechamento;

    @Column(name = "horario_abertura")
    @Temporal(TemporalType.TIME)
    private Date horarioAbertura;
    @Column(name = "horario_fechamento")
    @Temporal(TemporalType.TIME)
    private Date horarioFechamento;

    @Column(name = "valor_inicial")
    private double valorInicial;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor_final")
    private Double valorFinal;

    public Caixa() {
    }

    public Caixa(int codigo) {
        this.codigo = codigo;
    }

    public Caixa(Usuario usuario, Date dataAbertura, Date dataFechamento, Date horarioAbertura, Date horarioFechamento, double valorInicial, Double valorFinal) {
        this.usuario = usuario;
        this.dataAbertura = dataAbertura;
        this.dataFechamento = dataFechamento;
        this.horarioAbertura = horarioAbertura;
        this.horarioFechamento = horarioFechamento;
        this.valorInicial = valorInicial;
        this.valorFinal = valorFinal;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Date getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(Date dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public Date getDataFechamento() {
        return dataFechamento;
    }

    public void setDataFechamento(Date dataFechamento) {
        this.dataFechamento = dataFechamento;
    }

    public Date getHorarioAbertura() {
        return horarioAbertura;
    }

    public void setHorarioAbertura(Date horarioAbertura) {
        this.horarioAbertura = horarioAbertura;
    }

    public Date getHorarioFechamento() {
        return horarioFechamento;
    }

    public void setHorarioFechamento(Date horarioFechamento) {
        this.horarioFechamento = horarioFechamento;
    }

    public double getValorInicial() {
        return valorInicial;
    }

    public void setValorInicial(double valorInicial) {
        this.valorInicial = valorInicial;
    }

    public Double getValorFinal() {
        return valorFinal;
    }

    public void setValorFinal(Double valorFinal) {
        this.valorFinal = valorFinal;
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        final Caixa other = (Caixa) obj;
        return this.codigo == other.codigo;
    }

    @Override
    public String toString() {
        return "br.ifsp.edu.pep.model.Caixa[ codigo=" + codigo + " ]";
    }

}
