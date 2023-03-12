package br.ifsp.edu.pep.dao;

import br.ifsp.edu.pep.dao.emf.EntityManagerFactoryEMF;
import br.ifsp.edu.pep.dao.generec.AbstractDAO;
import br.ifsp.edu.pep.model.Ingrediente;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class IngredienteDAO extends AbstractDAO {

    public List<Ingrediente> findByName(String name) {

        EntityManager em = EntityManagerFactoryEMF.getGerente();

        TypedQuery<Ingrediente> query = em.createNamedQuery("Ingrediente.findByNome", Ingrediente.class);
        query.setParameter("nome", "%" + name + "%");

        return query.getResultList();
    }

}
