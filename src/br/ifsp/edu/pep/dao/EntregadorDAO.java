package br.ifsp.edu.pep.dao;

import br.ifsp.edu.pep.dao.emf.EntityManagerFactoryEMF;
import br.ifsp.edu.pep.dao.generec.AbstractDAO;
import br.ifsp.edu.pep.model.Entregador;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;

public class EntregadorDAO extends AbstractDAO {

    public List<Entregador> findByName(String name) {
        EntityManager em = EntityManagerFactoryEMF.getGerente();

        TypedQuery<Entregador> query = em.createNamedQuery("Entregador.findByNome", Entregador.class);
        query.setParameter("nome", "%" + name + "%");

        return query.getResultList();
    }

    public Entregador find(int id) {
        EntityManager em = EntityManagerFactoryEMF.getGerente();

        TypedQuery<Entregador> query = em.createNamedQuery("Entregador.findById", Entregador.class);
        query.setParameter("id", id);
        query.setHint(QueryHints.REFRESH, HintValues.TRUE);

        return query.getResultList().get(0);
    }

}
