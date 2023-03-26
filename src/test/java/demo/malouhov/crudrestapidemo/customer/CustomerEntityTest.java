package demo.malouhov.crudrestapidemo.customer;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;

class CustomerEntityTest {

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(CustomerEntity.class).verify();
    }

    @Test
    public void simpleEqualsContract() {
        EqualsVerifier.simple().forClass(CustomerEntity.class).verify();
    }
}