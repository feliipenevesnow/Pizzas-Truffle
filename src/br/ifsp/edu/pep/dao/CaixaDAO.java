package br.ifsp.edu.pep.dao;

import br.ifsp.edu.pep.dao.emf.EntityManagerFactoryEMF;
import br.ifsp.edu.pep.dao.generec.AbstractDAO;
import br.ifsp.edu.pep.model.Caixa;
import br.ifsp.edu.pep.model.Usuario;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;

public class CaixaDAO extends AbstractDAO {

    public static Caixa caixa;

    public static void setCaixa(Caixa caixa) {
        CaixaDAO.caixa = caixa;
    }

    public List<Caixa> findOpenCashRegister() {

        EntityManager em = EntityManagerFactoryEMF.getGerente();

        TypedQuery<Caixa> query = em.createNamedQuery("Caixa.findOpen", Caixa.class);

        return query.getResultList();
    }

    public List<Caixa> filter(String strQuery, Map<String, Object> map) {
        EntityManager em = EntityManagerFactoryEMF.getGerente();

        TypedQuery<Caixa> query = em.createQuery(strQuery, Caixa.class);

        if (map.containsKey("firstDate")) {
            query.setParameter("firstDate", (Date) map.get("firstDate"), TemporalType.TIMESTAMP);
        }
        if (map.containsKey("secoundDate")) {
            query.setParameter("secoundDate", (Date) map.get("secoundDate"), TemporalType.TIMESTAMP);
        }
        if (map.containsKey("usuario")) {
            query.setParameter("usuario", (Usuario) map.get("usuario"));
        }
        if (map.containsKey("total")) {
            query.setParameter("total", (double) map.get("total"));
        }

        query.setHint(QueryHints.REFRESH, HintValues.TRUE);

        return query.getResultList();
    }

}
