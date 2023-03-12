package br.ifsp.edu.pep.dao;

import br.ifsp.edu.pep.dao.emf.EntityManagerFactoryEMF;
import br.ifsp.edu.pep.dao.generec.AbstractDAO;
import br.ifsp.edu.pep.model.Pizza;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class PizzaDAO extends AbstractDAO {

    public List<Pizza> findByName(String name) {

        EntityManager em = EntityManagerFactoryEMF.getGerente();

        TypedQuery<Pizza> query = em.createNamedQuery("Pizza.findByNome", Pizza.class);
        query.setParameter("nome", "%" + name + "%");

        return query.getResultList();
    }

}
