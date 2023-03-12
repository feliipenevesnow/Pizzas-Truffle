package br.ifsp.edu.pep.dao;

import br.ifsp.edu.pep.dao.emf.EntityManagerFactoryEMF;
import br.ifsp.edu.pep.model.PagarEntregador;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;

public class PagarEntregadorDAO {

    public List<PagarEntregador> findAll() {
        EntityManager em = EntityManagerFactoryEMF.getGerente();

        TypedQuery<PagarEntregador> query = em.createNamedQuery("PagarEntregador.findAll", PagarEntregador.class);
        query.setHint(QueryHints.REFRESH, HintValues.TRUE);

        return query.getResultList();
    }

}
