package br.ifsp.edu.pep.dao.emf;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFactoryEMF {

    private static EntityManagerFactory emf;

    public static EntityManager getGerente() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("PizzasTrufflePU");
        }

        return emf.createEntityManager();
    }
}
