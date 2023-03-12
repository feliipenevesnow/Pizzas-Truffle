package br.ifsp.edu.pep.model;

import br.ifsp.edu.pep.model.Bebida;
import br.ifsp.edu.pep.model.Venda;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-11-25T13:48:40", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(BebidaVenda.class)
public class BebidaVenda_ { 

    public static volatile SingularAttribute<BebidaVenda, Venda> venda;
    public static volatile SingularAttribute<BebidaVenda, Double> subtotal;
    public static volatile SingularAttribute<BebidaVenda, Integer> quantidade;
    public static volatile SingularAttribute<BebidaVenda, Bebida> bebida;

}