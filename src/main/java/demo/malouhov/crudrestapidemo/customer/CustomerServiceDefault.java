package demo.malouhov.crudrestapidemo.customer;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public CustomerEntity create(CustomerEntity customer) {
        return repository.save(customer);
    }

    /**
     * Retrieve Customer by id.
     *
     * @param id - retrieved Customer id.
     * @return - object CustomerEntity or Optional.empty()
     */
    @Override
    public Optional<CustomerEntity> getById(Long id) {
        return repository.findById(id);
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
     * Update Customer.
     *
     * @param customer - object CustomerEntity
     * @return - updated CustomerEntity
     */
    @Override
    public CustomerEntity update(CustomerEntity customer) {
        CustomerEntity updatedCustomer = repository
                .findById(customer.getId())
                .orElseThrow(() -> new CustomerNotFoundException("Customer " + customer + " not found"));
        updatedCustomer.setFirstName(customer.getFirstName());
        updatedCustomer.setLastName(customer.getLastName());
        updatedCustomer.setEmail(customer.getEmail());
        return repository.save(updatedCustomer);
    }

    /**
     * Delete Customer.
     *
     * @param id - deleted Customer id.
     * @return - true id deleting was successful and false if not
     */
    @Override
    public void delete(Long id) {
        repository.delete(repository.getReferenceById(id));
    }

    /**
     * Delete all Customers.
     */
    @Override
    public void deleteAll() {
        repository.deleteAll();
    }
}
