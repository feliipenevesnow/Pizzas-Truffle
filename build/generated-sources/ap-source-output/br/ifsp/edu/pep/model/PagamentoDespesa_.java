package br.ifsp.edu.pep.model;

import br.ifsp.edu.pep.model.Caixa;
import br.ifsp.edu.pep.model.Despesa;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-11-25T13:48:40", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(PagamentoDespesa.class)
public class PagamentoDespesa_ { 

    public static volatile SingularAttribute<PagamentoDespesa, Date> dataPagamento;
    public static volatile SingularAttribute<PagamentoDespesa, Despesa> despesa;
    public static volatile SingularAttribute<PagamentoDespesa, Caixa> caixa;

}