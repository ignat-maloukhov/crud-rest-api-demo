package demo.malouhov.crudrestapidemo.customer;

import java.util.List;

public interface CustomerService {

    /**
     * Create new Customer.
     *
     * @param customer - object CustomerEntity
     * @return - created object CustomerEntity
     */
    CustomerEntity save(CustomerEntity customer);

    /**
     * Retrieve Customer by id. Method throws CustomerNotFoundException if Customer is absent.
     *
     * @param id - retrieved Customer id.
     * @return - object CustomerEntity
     */
    CustomerEntity getById(Long id);

    /**
     * Retrieve all Customer.
     *
     * @return - List of CustomerEntity or Collections.<CustomerEntity>emptyList()
     */
    List<CustomerEntity> getAll();

    /**
     * Delete Customer. Method throws CustomerNotFoundException if Customer is absent.
     *
     * @param id - deleted Customer id.
     */
    void delete(Long id);

    /**
     * Delete all Customers.
     */
    void deleteAll();

}
