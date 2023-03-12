package br.ifsp.edu.pep.model;

import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-11-25T13:48:40", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Despesa.class)
public class Despesa_ { 

    public static volatile SingularAttribute<Despesa, Integer> codigo;
    public static volatile SingularAttribute<Despesa, Date> dataVencimento;
    public static volatile SingularAttribute<Despesa, Double> valor;
    public static volatile SingularAttribute<Despesa, String> nome;
    public static volatile SingularAttribute<Despesa, String> descricao;
    public static volatile SingularAttribute<Despesa, String> status;

}