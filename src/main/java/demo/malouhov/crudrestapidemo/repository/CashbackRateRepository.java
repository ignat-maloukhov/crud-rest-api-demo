package demo.malouhov.crudrestapidemo.repository;

import demo.malouhov.crudrestapidemo.entity.CashbackRateEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CashbackRateRepository extends JpaRepository<CashbackRateEntity, Long> {

}
