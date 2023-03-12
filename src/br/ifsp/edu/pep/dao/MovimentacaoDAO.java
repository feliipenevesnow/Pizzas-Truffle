package br.ifsp.edu.pep.dao;

import br.ifsp.edu.pep.dao.emf.EntityManagerFactoryEMF;
import br.ifsp.edu.pep.dao.generec.AbstractDAO;
import br.ifsp.edu.pep.model.Caixa;
import br.ifsp.edu.pep.model.Movimentacao;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.TypedQuery;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;

public class MovimentacaoDAO extends AbstractDAO {

    public List<Movimentacao> findByCash(Caixa caixa) {
        EntityManager em = EntityManagerFactoryEMF.getGerente();
        System.out.println("Codigo: " + caixa.getCodigo());
        TypedQuery<Movimentacao> query = em.createNamedQuery("Movimentacao.findByCaixa", Movimentacao.class);
        query.setParameter("caixa", caixa);
        query.setHint(QueryHints.REFRESH, HintValues.TRUE);

        return query.getResultList();
    }

    public double sumSupplementation(Date data) {
        EntityManager em = EntityManagerFactoryEMF.getGerente();

        StoredProcedureQuery query = em.createStoredProcedureQuery("sumSupplementation");
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

    public double sumBloodletting(Date data) {
        EntityManager em = EntityManagerFactoryEMF.getGerente();

        StoredProcedureQuery query = em.createStoredProcedureQuery("sumBloodletting");
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
}
