package demo.malouhov.crudrestapidemo.customer;

import demo.malouhov.crudrestapidemo.customer.dto.GetCustomerDto;
import demo.malouhov.crudrestapidemo.customer.dto.PostCustomerDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@Validated
@RequestMapping("/api/v1")
public class CustomerController {

    private final CustomerService customerService;

    private final EntityToDtoMapper entityToDtoMapper;

    /**
     * Sends a request to create a new Customer.
     *
     * @param postCustomerDto - object PostCustomerDto
     * @return - if created ResponseEntity with PostCustomerDto object and HttpStatus
     */
    @PostMapping("/customers")
    public ResponseEntity<PostCustomerDto> createCustomer(@Valid @RequestBody PostCustomerDto postCustomerDto) {
        try {
            CustomerEntity createdCustomer = customerService.create(entityToDtoMapper.postDtoToEntity(postCustomerDto));
            return new ResponseEntity<>(entityToDtoMapper.entityToPostDto(createdCustomer), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Sends a request to retrieve Customer by id.
     *
     * @param id - retrieved Customer id.
     * @return - if received ResponseEntity with GetCustomerDto object and HttpStatus
     */
    @GetMapping("/customers/{id}")
    public ResponseEntity<GetCustomerDto> getCustomerById(@PathVariable("id") @Positive long id) {
        try {
            Optional<CustomerEntity> savedCustomer = customerService.getById(id);
            return savedCustomer.map(customer -> new ResponseEntity<>(entityToDtoMapper.entityToGetDto(customer), HttpStatus.OK))
                    .orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Sends a request to retrieve all Customers.
     *
     * @return - if received List with ResponseEntity with GetCustomerDto object and HttpStatus
     */
    @GetMapping("/customers")
    public ResponseEntity<List<GetCustomerDto>> getAllCustomers() {
        try {
            List<CustomerEntity> savedCustomers = customerService.getAll();
            if (savedCustomers.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {

                return new ResponseEntity<>(entityToDtoMapper.entityListToGetDtoList(savedCustomers), HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Sends a request to update Customer with given id.
     *
     * @param id             - updated Customer id
     * @param newCustomerDto - new data
     * @return - if updated ResponseEntity with PostCustomerDto object and HttpStatus
     */
    @PutMapping("/customers/{id}")
    public ResponseEntity<PostCustomerDto> updateCustomer(@PathVariable("id") @Positive long id,
                                                          @Valid @RequestBody PostCustomerDto newCustomerDto) {
        try {
            CustomerEntity newCustomer = entityToDtoMapper.postDtoToEntity(newCustomerDto);
            return customerService.getById(id)
                    .map(customer -> {
                        customer.setFirstName(newCustomer.getFirstName());
                        customer.setLastName(newCustomer.getLastName());
                        customer.setEmail(newCustomer.getEmail());
                        customerService.create(customer);
                        return new ResponseEntity<>(entityToDtoMapper.entityToPostDto(newCustomer), HttpStatus.OK);
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
    public ResponseEntity<HttpStatus> deleteCustomer(@PathVariable("id") @Positive long id) {
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
