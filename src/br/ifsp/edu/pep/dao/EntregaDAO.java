package br.ifsp.edu.pep.dao;

import br.ifsp.edu.pep.dao.emf.EntityManagerFactoryEMF;
import br.ifsp.edu.pep.dao.generec.AbstractDAO;
import br.ifsp.edu.pep.model.Entrega;
import br.ifsp.edu.pep.model.Cliente;
import br.ifsp.edu.pep.model.Entregador;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;

public class EntregaDAO extends AbstractDAO {

    public List<Entrega> filter(String strQuery, Map<String, Object> map) {
        EntityManager em = EntityManagerFactoryEMF.getGerente();

        TypedQuery<Entrega> query = em.createQuery(strQuery, Entrega.class);

        if (map.containsKey("firstDate")) {
            query.setParameter("firstDate", (Date) map.get("firstDate"), TemporalType.TIMESTAMP);
        }
        if (map.containsKey("secoundDate")) {
            query.setParameter("secoundDate", (Date) map.get("secoundDate"), TemporalType.TIMESTAMP);
        }
        if (map.containsKey("entregador")) {
            query.setParameter("entregador", (Entregador) map.get("entregador"));
        }
        if (map.containsKey("cliente")) {
            query.setParameter("cliente", (Cliente) map.get("cliente"));
        }

        query.setHint(QueryHints.REFRESH, HintValues.TRUE);

        return query.getResultList();
    }

}
