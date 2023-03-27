package demo.malouhov.crudrestapidemo.account;

import demo.malouhov.crudrestapidemo.cashback.CashbackEntity;
import demo.malouhov.crudrestapidemo.customer.CustomerEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Setter
@Getter
@Entity
@Table(name = "accounts")
public class AccountEntity {

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_customer")
    CustomerEntity owner;

    @NotNull
    private BigDecimal amount;

    @CreationTimestamp
    private LocalDate created;

    @ManyToMany
    @JoinTable(name = "account_cashback",
            joinColumns = {@JoinColumn(name = "fk_account")},
            inverseJoinColumns = {@JoinColumn(name = "fk_cashback")})
    private Set<CashbackEntity> cashback = new HashSet<>();

    public AccountEntity() {
    }

    public AccountEntity(CustomerEntity owner) {
        this.owner = owner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountEntity that = (AccountEntity) o;
        return Objects.equals(this.id, that.id)
                && Objects.equals(this.amount, that.amount)
                && Objects.equals(this.created, that.created);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.amount, this.created);
    }

    @Override
    public String toString() {
        return "AccountEntity{" +
                "id=" + id +
                ", owner='" + owner + '\'' +
                ", firstName='" + amount + '\'' +
                ", lastName='" + created + '\'' +
                '}';
    }

}
