package br.ifsp.edu.pep.dao;

import br.ifsp.edu.pep.dao.emf.EntityManagerFactoryEMF;
import br.ifsp.edu.pep.dao.generec.AbstractDAO;
import br.ifsp.edu.pep.model.Compra;
import br.ifsp.edu.pep.model.Fornecedor;
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

public class CompraDAO extends AbstractDAO {

    public double sumBuyByDate(Date data) {
        EntityManager em = EntityManagerFactoryEMF.getGerente();

        StoredProcedureQuery query = em.createStoredProcedureQuery("sumBuyByDate");
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

    public double countBuy(Date data) {
        EntityManager em = EntityManagerFactoryEMF.getGerente();

        StoredProcedureQuery query = em.createStoredProcedureQuery("countBuy");
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

    public List<Compra> filter(String strQuery, Map<String, Object> map) {
        EntityManager em = EntityManagerFactoryEMF.getGerente();

        System.out.println((String) map.get("status"));

        TypedQuery<Compra> query = em.createQuery(strQuery, Compra.class);

        if (map.containsKey("firstDate")) {
            query.setParameter("firstDate", (Date) map.get("firstDate"), TemporalType.TIMESTAMP);
        }
        if (map.containsKey("secoundDate")) {
            query.setParameter("secoundDate", (Date) map.get("secoundDate"), TemporalType.TIMESTAMP);
        }
        if (map.containsKey("fornecedor")) {
            query.setParameter("fornecedor", (Fornecedor) map.get("fornecedor"));
        }
        if (map.containsKey("total")) {
            query.setParameter("total", (double) map.get("total"));
        }

        if (map.containsKey("status")) {
            //query.setParameter("status", "%" + (String) map.get("status") + "%");
        }

        System.out.println(query);

        query.setHint(QueryHints.REFRESH, HintValues.TRUE);

        return query.getResultList();
    }

    public List<Compra> findByAll() {
        EntityManager em = EntityManagerFactoryEMF.getGerente();

        TypedQuery<Compra> query = em.createNamedQuery("Compra.findAll", Compra.class);

        return query.getResultList();
    }

}
