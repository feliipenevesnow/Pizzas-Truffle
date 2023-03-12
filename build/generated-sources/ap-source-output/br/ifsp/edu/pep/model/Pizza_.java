package br.ifsp.edu.pep.model;

import br.ifsp.edu.pep.model.IngredientePizza;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-11-25T13:48:40", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Pizza.class)
public class Pizza_ { 

    public static volatile SingularAttribute<Pizza, Double> preco;
    public static volatile SingularAttribute<Pizza, Integer> codigo;
    public static volatile SingularAttribute<Pizza, String> tamanho;
    public static volatile ListAttribute<Pizza, IngredientePizza> ingredientes;
    public static volatile SingularAttribute<Pizza, String> nome;

}