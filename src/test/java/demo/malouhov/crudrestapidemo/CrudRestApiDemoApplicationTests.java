package demo.malouhov.crudrestapidemo;

import demo.malouhov.crudrestapidemo.controller.CustomerController;
import demo.malouhov.crudrestapidemo.repository.CustomerRepository;
import demo.malouhov.crudrestapidemo.service.CustomerService;
import demo.malouhov.crudrestapidemo.util.EntityToDtoMapper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CrudRestApiDemoApplicationTests {

    @Autowired
    private CustomerController customerController;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private EntityToDtoMapper entityToDtoMapper;

    @Test
    @DisplayName("Components Loads Test")
    public void contextLoads() throws Exception {
        Assertions.assertThat(customerController).isNotNull();
        Assertions.assertThat(customerRepository).isNotNull();
        Assertions.assertThat(customerService).isNotNull();
        Assertions.assertThat(entityToDtoMapper).isNotNull();
    }
}
