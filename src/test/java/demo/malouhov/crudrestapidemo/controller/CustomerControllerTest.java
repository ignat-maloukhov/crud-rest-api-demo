package demo.malouhov.crudrestapidemo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import demo.malouhov.crudrestapidemo.dto.PostCustomerDto;
import demo.malouhov.crudrestapidemo.entity.CustomerEntity;
import demo.malouhov.crudrestapidemo.service.CustomerService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CustomerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private CustomerService customerService;


    @Test
    @DisplayName("Test createCustomer method: Valid URL, Method and Content Type returns HTTP Status 200")
    void whenValidUrlAndMethodAndContentTypeThenReturns201() throws Exception {
        String uri = "/api/v1/customers";
        PostCustomerDto testCustomerDto = new PostCustomerDto("John", "Wick", "john@email.com");

        mockMvc.perform(post(uri)
                        .content(objectMapper.writeValueAsString(testCustomerDto))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated()).andDo(print());
    }

    @Test
    @DisplayName("Test createCustomer method: Valid URL and Method, invalid Content Type returns HTTP Status 500")
    void whenValidUrlAndMethodAndInvalidContentTypeThenReturns400() throws Exception {
        String uri = "/api/v1/customers";
        String invalidContentType = "John";

        mockMvc.perform(post(uri)
                        .content(objectMapper.writeValueAsString(invalidContentType))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isInternalServerError()).andDo(print());
    }

    @Test
    @DisplayName("Test createCustomer method: Valid URL and Method, invalid Content Type with null returns HTTP Status 500")
    void whenNullValueThenReturns400() throws Exception {
        String uri = "/api/v1/customers";
        PostCustomerDto testCustomerDto = new PostCustomerDto(null, "Wick", "john@email.com");

        mockMvc.perform(post(uri)
                        .content(objectMapper.writeValueAsString(testCustomerDto))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isInternalServerError()).andDo(print());
    }

    @Test
    @DisplayName("Test createCustomer method: Valid input calls Business Model")
    void whenValidInputThenCallsBusinessModel() throws Exception {
        String uri = "/api/v1/customers";
        PostCustomerDto testCustomer = new PostCustomerDto("John", "Wick", "john@email.com");

        mockMvc.perform(post(uri)
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