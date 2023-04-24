package demo.malouhov.crudrestapidemo.repository;

import demo.malouhov.crudrestapidemo.entity.CashbackEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CashbackRepository extends JpaRepository<CashbackEntity, Long> {
}
