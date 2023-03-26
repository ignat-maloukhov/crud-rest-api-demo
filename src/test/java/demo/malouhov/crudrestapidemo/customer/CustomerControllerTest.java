package demo.malouhov.crudrestapidemo.customer;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = CustomerController.class)
class CustomerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private CustomerService customerService;

    @Test
    @DisplayName("Test createCustomer: Valid URL, Method and Content Type")
    void whenValidUrlAndMethodAndContentTypeThenReturns201() throws Exception {

        CustomerEntity testCustomer = new CustomerEntity("John", "Wick", "john@email.com");

        mockMvc.perform(post("/api/v1/customers")
                        .content(objectMapper.writeValueAsString(testCustomer))
                        .contentType("application/json"))
                .andExpect(status().isCreated());
    }

    @Test
    @DisplayName("Test createCustomer: Valid URL and Method, invalid Content Type")
    void whenValidUrlAndMethodAndInvalidContentTypeThenReturns400() throws Exception {

        String invalidContentType = "John";

        mockMvc.perform(post("/api/v1/customers")
                        .content(objectMapper.writeValueAsString(invalidContentType))
                        .contentType("application/json"))
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("Test createCustomer: Valid URL and Method, invalid Content Type with null")
    void whenNullValueThenReturns400() throws Exception {

        CustomerEntity testCustomer = new CustomerEntity(null, "Wick", "john@email.com");

        mockMvc.perform(post("/api/v1/customers")
                        .content(objectMapper.writeValueAsString(testCustomer))
                        .contentType("application/json"))
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("Test createCustomer: Valid input calls Business Model")
    void whenValidInputThenCallsBusinessModel() throws Exception {

        CustomerEntity testCustomer = new CustomerEntity("John", "Wick", "john@email.com");

        mockMvc.perform(post("/api/v1/customers")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(testCustomer)))
                .andExpect(status().isCreated());

        ArgumentCaptor<CustomerEntity> customerCaptor = ArgumentCaptor.forClass(CustomerEntity.class);
        verify(customerService, times(1)).create(customerCaptor.capture());
        assertThat(customerCaptor.getValue().getFirstName()).isEqualTo("John");
        assertThat(customerCaptor.getValue().getLastName()).isEqualTo("Wick");
        assertThat(customerCaptor.getValue().getEmail()).isEqualTo("john@email.com");

    }

    @Test
    void createCustomer() {
    }

    @Test
    void getCustomerById() {
    }

    @Test
    void getAllCustomers() {
    }

    @Test
    void updateCustomer() {
    }

    @Test
    void deleteCustomer() {
    }

    @Test
    void deleteAllCustomers() {
    }
}