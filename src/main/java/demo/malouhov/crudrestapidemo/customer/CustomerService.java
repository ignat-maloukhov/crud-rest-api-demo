package demo.malouhov.crudrestapidemo.customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {

    /**
     * Create new Customer.
     *
     * @param customer - object CustomerEntity
     * @return - created object CustomerEntity
     */
    CustomerEntity create(CustomerEntity customer);

    /**
     * Retrieve Customer by id.
     *
     * @param id - retrieved Customer id.
     * @return - object CustomerEntity or Optional.empty()
     */
    Optional<CustomerEntity> getById(Long id);

    /**
     * Retrieve all Customer.
     *
     * @return - List of CustomerEntity or Collections.<CustomerEntity>emptyList()
     */
    List<CustomerEntity> getAll();

    /**
     * Update Customer.
     *
     * @param customer - object CustomerEntity
     * @return - updated CustomerEntity
     */
    CustomerEntity update(CustomerEntity customer);

    /**
     * Delete Customer.
     *
     * @param id - deleted Customer id.
     */
    void delete(Long id);

    /**
     * Delete all Customers.
     */
    void deleteAll();

}
