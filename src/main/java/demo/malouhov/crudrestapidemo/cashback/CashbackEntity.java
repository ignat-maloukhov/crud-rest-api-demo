package demo.malouhov.crudrestapidemo.cashback;

import demo.malouhov.crudrestapidemo.account.AccountEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Objects;
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
    private CashbackCategory category;

    @NotNull
    private BigDecimal rate;

    @ManyToMany(mappedBy = "cashback")
    private Set<AccountEntity> accounts = new HashSet<>();

    public enum CashbackCategory {

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CashbackEntity that = (CashbackEntity) o;
        return Objects.equals(this.id, that.id)
                && Objects.equals(this.category, that.category)
                && Objects.equals(this.rate, that.rate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.category, this.rate);
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
