package br.ifsp.edu.pep.model;

import br.ifsp.edu.pep.model.BebidaVenda;
import br.ifsp.edu.pep.model.Caixa;
import br.ifsp.edu.pep.model.Entrega;
import br.ifsp.edu.pep.model.PedidoOnline;
import br.ifsp.edu.pep.model.PizzaVenda;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-11-25T13:48:40", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Venda.class)
public class Venda_ { 

    public static volatile SingularAttribute<Venda, Integer> codigo;
    public static volatile SingularAttribute<Venda, Double> total;
    public static volatile SingularAttribute<Venda, Caixa> caixa;
    public static volatile SingularAttribute<Venda, Date> data;
    public static volatile SingularAttribute<Venda, Double> desconto;
    public static volatile ListAttribute<Venda, PizzaVenda> pizzas;
    public static volatile SingularAttribute<Venda, PedidoOnline> pedido;
    public static volatile SingularAttribute<Venda, Entrega> entrega;
    public static volatile ListAttribute<Venda, BebidaVenda> bebidas;
    public static volatile SingularAttribute<Venda, String> status;

}