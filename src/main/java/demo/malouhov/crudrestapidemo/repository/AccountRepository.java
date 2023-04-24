package demo.malouhov.crudrestapidemo.repository;

import demo.malouhov.crudrestapidemo.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<AccountEntity, Long> {
}
