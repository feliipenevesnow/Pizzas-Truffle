package br.ifsp.edu.pep.model;

import br.ifsp.edu.pep.model.Venda;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-11-25T13:48:40", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Pagamento.class)
public class Pagamento_ { 

    public static volatile SingularAttribute<Pagamento, Integer> codigo;
    public static volatile SingularAttribute<Pagamento, Venda> venda;
    public static volatile SingularAttribute<Pagamento, Double> valor;
    public static volatile SingularAttribute<Pagamento, String> forma;

}