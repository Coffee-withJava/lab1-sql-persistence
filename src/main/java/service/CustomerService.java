package service;

import entity.CustomerEntity;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped

public class CustomerService {
    @PersistenceContext
    private EntityManager em;

    @Transactional
    public CustomerEntity save(CustomerEntity customer) {
        em.persist(customer);
        return customer;
    }

    public CustomerEntity findById(Long id) {
        return em.find(CustomerEntity.class, id);
    }

    @Transactional
    public CustomerEntity update(CustomerEntity customer) {
        em.merge(customer);
        return findById(customer.getId());
    }

    @Transactional
    public void delete(Long id) {
        CustomerEntity customer = findById(id);
        if (customer != null) {
            em.remove(customer);
        }
    }
}
