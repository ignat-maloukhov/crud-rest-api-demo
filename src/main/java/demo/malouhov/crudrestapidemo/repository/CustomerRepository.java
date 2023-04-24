package demo.malouhov.crudrestapidemo.repository;

import demo.malouhov.crudrestapidemo.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {

}
