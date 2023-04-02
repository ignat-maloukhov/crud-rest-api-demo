package demo.malouhov.crudrestapidemo.cashback;

import demo.malouhov.crudrestapidemo.account.AccountEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@Entity
@Table(name = "cashback")
public class CashbackEntity {

    @Id
    @GeneratedValue
    private long id;

    @NotNull
    @Enumerated(EnumType.ORDINAL)
    private CashbackCategory category;

    @NotNull
    private BigDecimal rate;

    @ManyToMany(mappedBy = "cashback")
    private Set<AccountEntity> accounts = new HashSet<>();

    public enum CashbackCategory {

        NONE,
        RESTAURANTS,
        TRANSPORT,
        MARKETS

    }

    public CashbackEntity() {
    }

    public CashbackEntity(CashbackCategory category, BigDecimal rate) {
        this.category = category;
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "AccountEntity{" +
                "id=" + id +
                ", category='" + category + '\'' +
                ", rate='" + rate + '\'' +
                '}';
    }
}
