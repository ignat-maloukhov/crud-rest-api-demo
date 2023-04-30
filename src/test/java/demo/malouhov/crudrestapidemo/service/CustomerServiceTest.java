package demo.malouhov.crudrestapidemo.service;

import demo.malouhov.crudrestapidemo.entity.CustomerEntity;
import demo.malouhov.crudrestapidemo.repository.CustomerRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CustomerServiceTest {

    @InjectMocks
    private CustomerServiceDefault customerService;

    @Mock
    private CustomerRepository customerRepository;

    private CustomerEntity testCustomer;

    @BeforeEach
    public void setup() {
        testCustomer = new CustomerEntity("John", "Wick", "john@email.com");
        testCustomer.setId(1L);
    }

    @AfterEach
    public void tearDown() {
        testCustomer = null;
    }

    @Test
    @DisplayName("save method Test")
    public void saveTest() {
        customerService.save(testCustomer);
        verify(customerRepository, times(1)).save(testCustomer);
    }

    @Test
    @DisplayName("getById method Test")
    public void getById() {
        when(customerRepository.findById(1L)).thenReturn(Optional.ofNullable(testCustomer));
        CustomerEntity actualCustomer = customerService.getById(1L);

        assertThat(actualCustomer).isNotNull();
        assertEquals("John", actualCustomer.getFirstName());
        assertEquals("Wick", actualCustomer.getLastName());
        assertEquals("john@email.com", actualCustomer.getEmail());
    }

    @Test
    @DisplayName("getAll method Test")
    public void getAll() {
        List<CustomerEntity> expectedCustomers = new ArrayList<>();
        expectedCustomers.add(testCustomer);

        when(customerRepository.findAll()).thenReturn(expectedCustomers);

        List<CustomerEntity> actualCustomers = customerService.getAll();
        
        assertEquals(1, actualCustomers.size());
        verify(customerRepository, times(1)).findAll();

    }

}