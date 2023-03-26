package demo.malouhov.crudrestapidemo.customer;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class CustomerController {

    private final CustomerService customerService;

    /**
     * Sends a request to create a new Customer.
     *
     * @param customer - object CustomerEntity
     * @return - if created ResponseEntity with CustomerEntity object and HttpStatus
     */
    @PostMapping("/customers")
    public ResponseEntity<CustomerEntity> createCustomer(@Valid @RequestBody CustomerEntity customer) {
        try {
            CustomerEntity createdCustomer = customerService.create(customer);
            return new ResponseEntity<>(createdCustomer, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Sends a request to retrieve Customer by id.
     *
     * @param id - retrieved Customer id.
     * @return - if received ResponseEntity with CustomerEntity object and HttpStatus
     */
    @GetMapping("/customers/{id}")
    public ResponseEntity<CustomerEntity> getCustomerById(@PathVariable("id") long id) {
        try {

            Optional<CustomerEntity> savedCustomer = customerService.getById(id);
            return savedCustomer.map(c -> new ResponseEntity<>(c, HttpStatus.OK))
                    .orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Sends a request to retrieve all Customers.
     *
     * @return - if received List with ResponseEntity with CustomerEntity object and HttpStatus
     */
    @GetMapping("/customers")
    public ResponseEntity<List<CustomerEntity>> getAllCustomers() {
        try {
            List<CustomerEntity> savedCustomers = customerService.getAll();
            if (savedCustomers.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(savedCustomers, HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Sends a request to update Customer with given id.
     *
     * @param id          - updated Customer id
     * @param newCustomer - new data
     * @return - if updated ResponseEntity with CustomerEntity object and HttpStatus
     */
    @PutMapping("/customers/{id}")
    public ResponseEntity<CustomerEntity> updateCustomer(@PathVariable("id") long id,
                                                         @RequestBody CustomerEntity newCustomer) {
        try {
            return customerService.getById(id)
                    .map(c -> {
                        c.setFirstName(newCustomer.getFirstName());
                        c.setLastName(newCustomer.getLastName());
                        c.setEmail(newCustomer.getEmail());
                        return new ResponseEntity<>(customerService.create(c), HttpStatus.OK);
                    })
                    .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Sends a request to delete Customer with given id.
     *
     * @param id - deleted Customer id
     * @return - HttpStatus
     */
    @DeleteMapping("/customers/{id}")
    public ResponseEntity<HttpStatus> deleteCustomer(@PathVariable("id") long id) {
        try {
            customerService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Sends a request to delete All Customers.
     *
     * @return - HttpStatus
     */
    @DeleteMapping("/customers")
    public ResponseEntity<HttpStatus> deleteAllCustomers() {
        try {
            customerService.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
