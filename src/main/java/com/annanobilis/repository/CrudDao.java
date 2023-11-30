package com.annanobilis.repository;

import com.annanobilis.entity.Employee;

import java.util.List;

public interface CrudDao <E> {

    List<E> findAll();
    E findById(int id);
    E save(E entity);
    E updateoneposition(E entity);
    void update(E entity);
    void delete(E entity);

}
