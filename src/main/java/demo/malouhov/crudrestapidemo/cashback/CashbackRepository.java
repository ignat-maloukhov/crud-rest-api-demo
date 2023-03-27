package demo.malouhov.crudrestapidemo.cashback;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CashbackRepository extends JpaRepository<CashbackEntity, Long> {
}
