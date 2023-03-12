package br.ifsp.edu.pep.dao;

import br.ifsp.edu.pep.dao.emf.EntityManagerFactoryEMF;
import br.ifsp.edu.pep.dao.generec.AbstractDAO;
import br.ifsp.edu.pep.model.Bebida;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;

public class BebidaDAO extends AbstractDAO {

    public List<Bebida> findByName(String name) {
        EntityManager em = EntityManagerFactoryEMF.getGerente();
        TypedQuery<Bebida> query = em.createNamedQuery("Bebida.findByNome", Bebida.class);
        query.setParameter("nome", "%" + name + "%");
        query.setHint(QueryHints.REFRESH, HintValues.TRUE);

        return query.getResultList();
    }

}
