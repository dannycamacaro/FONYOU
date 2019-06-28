package com.fonyou.test.employee.services;

import com.fonyou.test.employee.entity.EmployeeEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class EmployeeServices {

    @PersistenceContext
    private EntityManager entityManager;


    public Boolean create(EmployeeEntity employeeEntity) {
        entityManager.persist(employeeEntity);
        return true;
    }

    public Boolean delete(EmployeeEntity employeeEntity) {
        if (entityManager.contains(employeeEntity))
            entityManager.remove(employeeEntity);
        else
            entityManager.remove(entityManager.merge(employeeEntity));
        return true;
    }

    @SuppressWarnings("unchecked")
    public List<EmployeeEntity> getAll() {
        return entityManager.createQuery("from EmployeeEntity").getResultList();
    }

    public EmployeeEntity getById(Integer id) {
        return entityManager.find(EmployeeEntity.class, id);
    }

    public Boolean update(EmployeeEntity employeeEntity) {
        entityManager.merge(employeeEntity);
        return true;
    }

}
