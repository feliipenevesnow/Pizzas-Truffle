package br.ifsp.edu.pep.dao;

import br.ifsp.edu.pep.dao.emf.EntityManagerFactoryEMF;
import br.ifsp.edu.pep.dao.generec.AbstractDAO;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

public class PagamentoEntregadorDAO extends AbstractDAO {

    public double sumPaymentDelivery(Date data) {
        EntityManager em = EntityManagerFactoryEMF.getGerente();

        StoredProcedureQuery query = em.createStoredProcedureQuery("sumPaymentDelivery");
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
