package br.ifsp.edu.pep.model;

import br.ifsp.edu.pep.model.Venda;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-11-25T13:48:40", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(PedidoOnline.class)
public class PedidoOnline_ { 

    public static volatile SingularAttribute<PedidoOnline, Integer> codigo;
    public static volatile SingularAttribute<PedidoOnline, Venda> venda;
    public static volatile SingularAttribute<PedidoOnline, String> endereco;
    public static volatile SingularAttribute<PedidoOnline, String> bairro;
    public static volatile SingularAttribute<PedidoOnline, String> nome;

}