package br.ifsp.edu.pep.model;

import br.ifsp.edu.pep.model.Usuario;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-11-25T13:48:40", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Caixa.class)
public class Caixa_ { 

    public static volatile SingularAttribute<Caixa, Date> horarioFechamento;
    public static volatile SingularAttribute<Caixa, Integer> codigo;
    public static volatile SingularAttribute<Caixa, Double> valorInicial;
    public static volatile SingularAttribute<Caixa, Usuario> usuario;
    public static volatile SingularAttribute<Caixa, Date> dataFechamento;
    public static volatile SingularAttribute<Caixa, Double> valorFinal;
    public static volatile SingularAttribute<Caixa, Date> horarioAbertura;
    public static volatile SingularAttribute<Caixa, Date> dataAbertura;

}