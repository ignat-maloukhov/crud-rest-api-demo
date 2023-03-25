package demo.malouhov.crudrestapidemo.customer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {

//    @Query("SELECT c FROM customers c WHERE m.first_name LIKE %:key% OR m.last_name LIKE %:key%")
//    List<CustomerEntity> searchByFirstNameOrLastName(@Param("key") String key);
}
