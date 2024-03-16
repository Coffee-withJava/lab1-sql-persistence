package service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@ApplicationScoped

public class CustomerService {
    @PersistenceContext
    private EntityManager em;

    @Transactional
    public Object save(Object customer) {
        em.persist(customer);
        return customer;
    }

    public Object findById(Long id) {
        /*
        * TODO
        *  DEVE BUSCAR CUSTOMER PELO ID E RETORNAR UM CUSTOMERENTITY
        * */
        return null;
    }


    public Object update(Object customer) {
        /*
        * TODO
        *   DEVE REALIZAR UMA ATUALIZAÇÃO NO CUSTOMER E DEVE RETORNA UM CUSTOMER
        *   OBS ESSE METODO DEVE SER TRANSACTIONAL
        * */
        return null;
    }


    public void delete(Long id) {
        /*
        * TODO
        *  DEVE REMOVER O CUSTOMER PELO ID
        *   OBS ESSE METODO DEVE SER TRANSACTIONAL
        * */
    }
}
