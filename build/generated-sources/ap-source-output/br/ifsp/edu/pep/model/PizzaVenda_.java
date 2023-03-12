package br.ifsp.edu.pep.model;

import br.ifsp.edu.pep.model.Pizza;
import br.ifsp.edu.pep.model.Venda;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-11-25T13:48:40", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(PizzaVenda.class)
public class PizzaVenda_ { 

    public static volatile SingularAttribute<PizzaVenda, Venda> venda;
    public static volatile SingularAttribute<PizzaVenda, Pizza> pizza;
    public static volatile SingularAttribute<PizzaVenda, Double> subtotal;
    public static volatile SingularAttribute<PizzaVenda, String> borda;
    public static volatile SingularAttribute<PizzaVenda, Integer> quantidade;
    public static volatile SingularAttribute<PizzaVenda, String> descricao;

}