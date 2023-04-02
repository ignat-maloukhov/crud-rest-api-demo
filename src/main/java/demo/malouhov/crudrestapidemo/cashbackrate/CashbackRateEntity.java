package demo.malouhov.crudrestapidemo.cashbackrate;

import demo.malouhov.crudrestapidemo.cashback.CashbackEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
@Entity
@Table(name = "cashback_rates")
public class CashbackRateEntity {

    @Id
    @GeneratedValue
    private long id;

    @Enumerated(EnumType.ORDINAL)
    private CashbackEntity.CashbackCategory cashbackCategory;

    private BigDecimal amount;

    public CashbackRateEntity() {
    }

    public CashbackRateEntity(CashbackEntity.CashbackCategory cashbackCategory, BigDecimal amount) {
        this.cashbackCategory = cashbackCategory;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "CashbackRateEntity{" +
                "id=" + id +
                ", category='" + cashbackCategory + '\'' +
                ", amount='" + amount + '\'' +
                '}';
    }

}
