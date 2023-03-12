package br.ifsp.edu.pep.model;

import br.ifsp.edu.pep.model.Caixa;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-11-25T13:48:40", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Movimentacao.class)
public class Movimentacao_ { 

    public static volatile SingularAttribute<Movimentacao, Integer> codigo;
    public static volatile SingularAttribute<Movimentacao, String> motivo;
    public static volatile SingularAttribute<Movimentacao, Integer> tipo;
    public static volatile SingularAttribute<Movimentacao, Caixa> caixa;
    public static volatile SingularAttribute<Movimentacao, Double> valor;

}