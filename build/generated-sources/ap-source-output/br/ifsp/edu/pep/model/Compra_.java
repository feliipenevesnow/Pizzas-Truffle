package br.ifsp.edu.pep.model;

import br.ifsp.edu.pep.model.BebidaCompra;
import br.ifsp.edu.pep.model.Caixa;
import br.ifsp.edu.pep.model.Fornecedor;
import br.ifsp.edu.pep.model.IngredienteCompra;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-11-25T13:48:40", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Compra.class)
public class Compra_ { 

    public static volatile SingularAttribute<Compra, Integer> codigo;
    public static volatile SingularAttribute<Compra, Double> total;
    public static volatile ListAttribute<Compra, IngredienteCompra> ingredientes;
    public static volatile SingularAttribute<Compra, Date> dataPagamento;
    public static volatile SingularAttribute<Compra, Caixa> caixa;
    public static volatile SingularAttribute<Compra, Date> data;
    public static volatile SingularAttribute<Compra, Date> dataVencimento;
    public static volatile SingularAttribute<Compra, Fornecedor> fornecedor;
    public static volatile ListAttribute<Compra, BebidaCompra> bebidas;

}