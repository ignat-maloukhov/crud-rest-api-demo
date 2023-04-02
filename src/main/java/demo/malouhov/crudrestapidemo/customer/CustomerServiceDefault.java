package demo.malouhov.crudrestapidemo.customer;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerServiceDefault implements CustomerService {

    private final CustomerRepository repository;

    /**
     * Create new Customer.
     *
     * @param customer - object CustomerEntity
     * @return - created object CustomerEntity
     */
    @Override
    public CustomerEntity save(CustomerEntity customer) {
        return repository.save(customer);
    }

    /**
     * Retrieve Customer by id. Method throws CustomerNotFoundException if Customer is absent.
     *
     * @param id - retrieved Customer id.
     * @return - object CustomerEntity or Optional.empty()
     */
    @Override
    public CustomerEntity getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException("Customer with id=" + id + " not found."));
    }

    /**
     * Retrieve all Customer.
     *
     * @return - List of CustomerEntity or Collections.<CustomerEntity>emptyList()
     */
    @Override
    public List<CustomerEntity> getAll() {
        return repository.findAll();
    }

    /**
     * Delete Customer. Method throws CustomerNotFoundException if Customer is absent.
     *
     * @param id - deleted Customer id.
     * @return - true id deleting was successful and false if not
     */
    @Override
    public void delete(Long id) {
        CustomerEntity deletedCustomer = repository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException("Customer with id: " + id + " not found."));
        repository.delete(deletedCustomer);
    }

    /**
     * Delete all Customers.
     */
    @Override
    public void deleteAll() {
        repository.deleteAll();
    }
}
