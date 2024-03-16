package service;

import entity.CustomerEntity;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.util.Optional;

@ApplicationScoped

public class CustomerService {
    @PersistenceContext
    private EntityManager em;

    @Transactional
    public CustomerEntity save(CustomerEntity customer) {
        em.persist(customer);
        return customer;
    }

    public Optional<CustomerEntity> findById(Long id) {
        return Optional.ofNullable(em.find(CustomerEntity.class, id));
    }

    @Transactional
    public CustomerEntity update(CustomerEntity customer) {
        em.merge(customer);
        return customer;
    }

    @Transactional
    public void delete(Long id) {
        findById(id).ifPresent(em::remove);
    }
}
