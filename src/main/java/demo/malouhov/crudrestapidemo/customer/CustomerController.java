package demo.malouhov.crudrestapidemo.customer;

import demo.malouhov.crudrestapidemo.customer.dto.GetCustomerDto;
import demo.malouhov.crudrestapidemo.customer.dto.PostCustomerDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        var createdCustomer = customerService.save(entityToDtoMapper.postDtoToEntity(postCustomerDto));
        return new ResponseEntity<>(entityToDtoMapper.entityToPostDto(createdCustomer), HttpStatus.CREATED);
    }

    /**
     * Sends a request to retrieve Customer by id.
     *
     * @param id - retrieved Customer id.
     * @return - if received ResponseEntity with GetCustomerDto object and HttpStatus
     */
    @GetMapping("/customers/{id}")
    public ResponseEntity<GetCustomerDto> getCustomerById(@PathVariable("id") @Positive long id) {
        var savedCustomer = customerService.getById(id);
        return new ResponseEntity<>(entityToDtoMapper.entityToGetDto(savedCustomer), HttpStatus.OK);
    }

    /**
     * Sends a request to retrieve all Customers.
     *
     * @return - if received List with ResponseEntity with GetCustomerDto object and HttpStatus
     */
    @GetMapping("/customers")
    public ResponseEntity<List<GetCustomerDto>> getAllCustomers() {
        var savedCustomers = customerService.getAll();
        if (savedCustomers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(entityToDtoMapper.entityListToGetDtoList(savedCustomers), HttpStatus.OK);
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

        var updatedCustomer = customerService.getById(id);
        var customerData = entityToDtoMapper.postDtoToEntity(newCustomerDto);
        updatedCustomer.setId(id);
        updatedCustomer.setFirstName(customerData.getFirstName());
        updatedCustomer.setLastName(customerData.getLastName());
        updatedCustomer.setEmail(customerData.getEmail());
        customerService.save(updatedCustomer);
        return new ResponseEntity<>(entityToDtoMapper.entityToPostDto(updatedCustomer), HttpStatus.OK);
    }

    /**
     * Sends a request to delete Customer with given id.
     *
     * @param id - deleted Customer id
     * @return - HttpStatus
     */
    @DeleteMapping("/customers/{id}")
    public ResponseEntity<HttpStatus> deleteCustomer(@PathVariable("id") @Positive long id) {
        var deletedCustomer = customerService.getById(id);
        customerService.delete(deletedCustomer.getId());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * Sends a request to delete All Customers.
     *
     * @return - HttpStatus
     */
    @DeleteMapping("/customers")
    public ResponseEntity<HttpStatus> deleteAllCustomers() {
        customerService.deleteAll();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
