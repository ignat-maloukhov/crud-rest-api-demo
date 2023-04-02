package demo.malouhov.crudrestapidemo.account;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
import java.util.Set;

@Setter
@Getter
@Entity
@Table(name = "accounts")
public class AccountEntity {

    @Id
    @GeneratedValue
    private long id;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_customer")
    CustomerEntity owner;

    @NotNull
    private BigDecimal amount;

    @CreationTimestamp
    private LocalDate created;

    @JsonIgnore
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
    public String toString() {
        return "AccountEntity{" +
                "id=" + id +
                ", owner='" + owner + '\'' +
                ", firstName='" + amount + '\'' +
                ", lastName='" + created + '\'' +
                '}';
    }

}
