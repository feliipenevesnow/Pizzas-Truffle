package br.ifsp.edu.pep.dao;

import br.ifsp.edu.pep.dao.emf.EntityManagerFactoryEMF;
import br.ifsp.edu.pep.dao.generec.AbstractDAO;
import br.ifsp.edu.pep.model.Fornecedor;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class FornecedorDAO extends AbstractDAO {

    public List<Fornecedor> findByName(String text) {

        EntityManager em = EntityManagerFactoryEMF.getGerente();

        TypedQuery<Fornecedor> query = em.createNamedQuery("Fornecedor.findByName", Fornecedor.class);

        query.setParameter("name", "%" + text + "%");

        return query.getResultList();
    }

    public List<Fornecedor> findByAll() {
        EntityManager em = EntityManagerFactoryEMF.getGerente();

        TypedQuery<Fornecedor> query = em.createNamedQuery("Fornecedor.findAll", Fornecedor.class);

        return query.getResultList();
    }

}
