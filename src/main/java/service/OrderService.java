package service;

import adapter.AdapterOrder;
import entity.dto.OrderDTO;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@ApplicationScoped
public class OrderService {
    @PersistenceContext
    private EntityManager em;

    @Inject
    AdapterOrder adapterOrder;

    @Inject
    CustomerService customerService;

    public Object buscarPorId(Long id) {
        /*
         * TODO DO
         *   DEVE BUSCAR O OrderItemsEntity PELO ID E RETORNAR O MESMO
         *
         * */
        return null;
    }


    public Object update(Object order) {
        /*
         * TODO DO
         *  DEVE RECEBER OrderItemsEntity PARA ATUALIZAR O MESMO E DEVE RETORNAR UM OrderItemsEntity
         *  OBS ESSA E UMA OPERAÇÃO Transactional
         * */
        return null;
    }


    public List<Object> saveOrder(OrderDTO orderDTO) {

        /*
        * TODO
        *  DEVE IMPLEMENTAR A LOGICA ONDE VAMOS ESTA RECEBENDO UM ORDERDTO E ESTA SALVANDO NO ORDER ITENS
        *  JA TEMOS UMA CLASS DE ADAPTER PARA VOCE TRABALHAR E TAMBEM DEVE RETORNAR UMA LISTA DE
        *  ORDERITEMSENTITY
        *
        * OBS:  ESTA METODO DEVE SER TRANSACTIONAL
        *
        * */
        return null;
    }

    public List<Object> getOrderItemsByOrderId(Long orderId) {

        /*
        * TODO
        *  DEVE BUSCAR O OrderItems PELO OrderId E RETORNAR UMA LISTA DE ITEMS EXEMPLO DE RETORNO
        *   [
                {
                    "orderId": 0,
                    "price": "STRING",
                    "productId": "STRING",
                    "quantity": 0
                }
            ]
        *
        *
        * */
        return null;
    }


    private Object getOrderItemEntity(Object customer, String payment) {
        /*
         * TODO DO
         *  DEVE PERSIST A ENTIDADE ORDENENTITY E RETORNAR A MESMA
         * */
        return null;
    }


}
