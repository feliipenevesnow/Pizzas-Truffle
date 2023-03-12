package br.ifsp.edu.pep.model;

import br.ifsp.edu.pep.model.Compra;
import br.ifsp.edu.pep.model.Ingrediente;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-11-25T13:48:40", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(IngredienteCompra.class)
public class IngredienteCompra_ { 

    public static volatile SingularAttribute<IngredienteCompra, Compra> compra;
    public static volatile SingularAttribute<IngredienteCompra, Double> subtotal;
    public static volatile SingularAttribute<IngredienteCompra, Integer> quantidade;
    public static volatile SingularAttribute<IngredienteCompra, Ingrediente> ingrediente;

}