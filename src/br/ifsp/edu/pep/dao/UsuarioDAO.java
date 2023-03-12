package br.ifsp.edu.pep.dao;

import br.ifsp.edu.pep.dao.emf.EntityManagerFactoryEMF;
import br.ifsp.edu.pep.dao.generec.AbstractDAO;
import br.ifsp.edu.pep.model.Usuario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class UsuarioDAO extends AbstractDAO {

    public static Usuario user;

    public List<Usuario> findByName(String name) {

        EntityManager em = EntityManagerFactoryEMF.getGerente();

        TypedQuery<Usuario> query = em.createNamedQuery("Usuario.findByNome", Usuario.class);
        query.setParameter("nome", "%" + name + "%");

        return query.getResultList();
    }

    public boolean connectUser(String email, char password[]) {
        boolean isLogged = false;
        EntityManager em = EntityManagerFactoryEMF.getGerente();

        TypedQuery<Usuario> query = em.createNamedQuery("Usuario.findByEmailAndPassword", Usuario.class);
        query.setParameter("email", email);
        query.setParameter("password", String.valueOf(password));

        if (!query.getResultList().isEmpty()) {
            user = query.getResultList().get(0);
            isLogged = true;
        }

        return isLogged;
    }

}
