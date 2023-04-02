package demo.malouhov.crudrestapidemo.customer;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
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
    @DisplayName("Test createCustomer method: Valid URL, Method and Content Type returns HTTP Status 200")
    void whenValidUrlAndMethodAndContentTypeThenReturns201() throws Exception {

        CustomerEntity testCustomer = new CustomerEntity("John", "Wick", "john@email.com");

        mockMvc.perform(post("/api/v1/customers")
                        .content(objectMapper.writeValueAsString(testCustomer))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated()).andDo(print());
    }

    @Test
    @DisplayName("Test createCustomer method: Valid URL and Method, invalid Content Type returns HTTP Status 400")
    void whenValidUrlAndMethodAndInvalidContentTypeThenReturns400() throws Exception {

        String invalidContentType = "John";

        mockMvc.perform(post("/api/v1/customers")
                        .content(objectMapper.writeValueAsString(invalidContentType))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest()).andDo(print());
    }

    @Test
    @DisplayName("Test createCustomer method: Valid URL and Method, invalid Content Type with null returns HTTP Status 400")
    void whenNullValueThenReturns400() throws Exception {

        CustomerEntity testCustomer = new CustomerEntity(null, "Wick", "john@email.com");

        mockMvc.perform(post("/api/v1/customers")
                        .content(objectMapper.writeValueAsString(testCustomer))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest()).andDo(print());
    }

    @Test
    @DisplayName("Test createCustomer method: Valid input calls Business Model")
    void whenValidInputThenCallsBusinessModel() throws Exception {

        CustomerEntity testCustomer = new CustomerEntity("John", "Wick", "john@email.com");

        mockMvc.perform(post("/api/v1/customers")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(testCustomer)))
                .andExpect(status().isCreated()).andDo(print());

        ArgumentCaptor<CustomerEntity> customerCaptor = ArgumentCaptor.forClass(CustomerEntity.class);
        verify(customerService, times(1)).save(customerCaptor.capture());
        assertThat(customerCaptor.getValue().getFirstName()).isEqualTo("John");
        assertThat(customerCaptor.getValue().getLastName()).isEqualTo("Wick");
        assertThat(customerCaptor.getValue().getEmail()).isEqualTo("john@email.com");

    }

}