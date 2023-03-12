package br.ifsp.edu.pep.dao;

import br.ifsp.edu.pep.dao.emf.EntityManagerFactoryEMF;
import br.ifsp.edu.pep.dao.generec.AbstractDAO;
import br.ifsp.edu.pep.model.Cliente;
import br.ifsp.edu.pep.model.Venda;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;

public class VendaDAO extends AbstractDAO {

    public List<Venda> findInPreparation() {
        EntityManager em = EntityManagerFactoryEMF.getGerente();

        TypedQuery<Venda> q = em.createNamedQuery("Venda.findInPreparation", Venda.class);

        return q.getResultList();
    }

    public List<Venda> findInDelivering() {
        EntityManager em = EntityManagerFactoryEMF.getGerente();

        TypedQuery<Venda> q = em.createNamedQuery("Venda.findInDelivering", Venda.class);

        return q.getResultList();
    }

    public List<Venda> findOnline() {
        EntityManager em = EntityManagerFactoryEMF.getGerente();

        TypedQuery<Venda> q = em.createNamedQuery("Venda.findOnline", Venda.class);

        return q.getResultList();
    }

    public double sumSellByDate(Date data) {
        EntityManager em = EntityManagerFactoryEMF.getGerente();

        StoredProcedureQuery query = em.createStoredProcedureQuery("sumSellByDate");
        query.registerStoredProcedureParameter("t", double.class, ParameterMode.OUT);
        query.registerStoredProcedureParameter("dia", Date.class, ParameterMode.IN);
        query.setParameter("dia", data);
        query.execute();

        double total;

        try {
            total = Double.parseDouble(query.getOutputParameterValue("t").toString());
        } catch (Exception ex) {
            total = 0;
        }

        return total;
    }

    public double countSell(Date data) {
        EntityManager em = EntityManagerFactoryEMF.getGerente();

        StoredProcedureQuery query = em.createStoredProcedureQuery("countSell");
        query.registerStoredProcedureParameter("t", double.class, ParameterMode.OUT);
        query.registerStoredProcedureParameter("dia", Date.class, ParameterMode.IN);
        query.setParameter("dia", data);
        query.execute();

        int total;

        try {
            total = Integer.parseInt(query.getOutputParameterValue("t").toString());
        } catch (Exception ex) {
            total = 0;
        }

        return total;
    }

    public List<Venda> filter(String strQuery, Map<String, Object> map) {
        EntityManager em = EntityManagerFactoryEMF.getGerente();

        TypedQuery<Venda> query = em.createQuery(strQuery, Venda.class);

        if (map.containsKey("firstDate")) {
            query.setParameter("firstDate", (Date) map.get("firstDate"), TemporalType.TIMESTAMP);
        }
        if (map.containsKey("secoundDate")) {
            query.setParameter("secoundDate", (Date) map.get("secoundDate"), TemporalType.TIMESTAMP);
        }
        if (map.containsKey("client")) {
            query.setParameter("client", (Cliente) map.get("client"));
        }
        if (map.containsKey("total")) {
            query.setParameter("total", (double) map.get("total"));
        }

        query.setHint(QueryHints.REFRESH, HintValues.TRUE);

        return query.getResultList();
    }

}
