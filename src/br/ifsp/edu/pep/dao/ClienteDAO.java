package br.ifsp.edu.pep.dao;

import br.ifsp.edu.pep.dao.emf.EntityManagerFactoryEMF;
import br.ifsp.edu.pep.dao.generec.AbstractDAO;
import br.ifsp.edu.pep.model.Cliente;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class ClienteDAO extends AbstractDAO {

    public List<Cliente> findByName(String text) {

        EntityManager em = EntityManagerFactoryEMF.getGerente();

        TypedQuery<Cliente> query = em.createNamedQuery("Cliente.findByNome", Cliente.class);

        query.setParameter("nome", "%" + text + "%");

        return query.getResultList();
    }

}
