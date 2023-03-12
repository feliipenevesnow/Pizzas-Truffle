package br.ifsp.edu.pep.model;

import br.ifsp.edu.pep.model.Entregador;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-11-25T13:48:40", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(PagamentoEntregador.class)
public class PagamentoEntregador_ { 

    public static volatile SingularAttribute<PagamentoEntregador, Integer> codigo;
    public static volatile SingularAttribute<PagamentoEntregador, Date> data;
    public static volatile SingularAttribute<PagamentoEntregador, Double> valor;
    public static volatile SingularAttribute<PagamentoEntregador, Entregador> entregador;

}