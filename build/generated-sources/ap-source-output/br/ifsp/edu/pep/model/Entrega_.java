package br.ifsp.edu.pep.model;

import br.ifsp.edu.pep.model.Cliente;
import br.ifsp.edu.pep.model.Entregador;
import br.ifsp.edu.pep.model.Venda;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-11-25T13:48:40", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Entrega.class)
public class Entrega_ { 

    public static volatile SingularAttribute<Entrega, Double> taxa;
    public static volatile SingularAttribute<Entrega, Cliente> cliente;
    public static volatile SingularAttribute<Entrega, Venda> venda;
    public static volatile SingularAttribute<Entrega, String> endereco;
    public static volatile SingularAttribute<Entrega, String> bairro;
    public static volatile SingularAttribute<Entrega, Entregador> entregador;
    public static volatile SingularAttribute<Entrega, String> status;

}