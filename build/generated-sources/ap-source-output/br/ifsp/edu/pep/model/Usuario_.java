package br.ifsp.edu.pep.model;

import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-11-25T13:48:40", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Usuario.class)
public class Usuario_ { 

    public static volatile SingularAttribute<Usuario, String> senha;
    public static volatile SingularAttribute<Usuario, Integer> codigo;
    public static volatile SingularAttribute<Usuario, String> cidade;
    public static volatile SingularAttribute<Usuario, String> estado;
    public static volatile SingularAttribute<Usuario, String> endereco;
    public static volatile SingularAttribute<Usuario, String> nome;
    public static volatile SingularAttribute<Usuario, Date> dataNascimento;
    public static volatile SingularAttribute<Usuario, String> cargo;
    public static volatile SingularAttribute<Usuario, String> contato;
    public static volatile SingularAttribute<Usuario, String> email;

}