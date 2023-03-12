package br.ifsp.edu.pep.dao.generec;

import java.util.List;

public interface IAbstractDAO<T> {

    public void insert(T t);

    public void update(T t);

    public void remove(T t);

    public List<T> findAll(Class<T> clazz);

}
