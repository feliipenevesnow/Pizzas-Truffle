package br.ifsp.edu.pep.dao.generec;

import br.ifsp.edu.pep.dao.emf.EntityManagerFactoryEMF;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;

public class AbstractDAO<T> implements IAbstractDAO {

    private Class<T> clazz;

    @Override
    public void insert(Object t) {
        EntityManager em = EntityManagerFactoryEMF.getGerente();

        em.getTransaction().begin();
        em.persist(t);
        em.getTransaction().commit();

        em.close();
    }

    @Override
    public void update(Object t) {
        EntityManager em = EntityManagerFactoryEMF.getGerente();

        em.getTransaction().begin();
        em.merge(t);
        em.getTransaction().commit();

        em.close();
    }

    @Override
    public void remove(Object t) {
        EntityManager em = EntityManagerFactoryEMF.getGerente();

        em.getTransaction().begin();
        em.remove(em.merge(t));
        em.getTransaction().commit();

        em.close();
    }

    @Override
    public List<T> findAll(Class clazz) {
        EntityManager em = EntityManagerFactoryEMF.getGerente();

        TypedQuery<T> query = em.createNamedQuery(clazz.getSimpleName() + ".findAll", clazz);
        query.setHint(QueryHints.REFRESH, HintValues.TRUE);

        return query.getResultList();
    }

}
