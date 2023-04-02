package demo.malouhov.crudrestapidemo.customer;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import demo.malouhov.crudrestapidemo.account.AccountEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "customers")
public class CustomerEntity {

    @Id
    @GeneratedValue
    private long id;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    @Column(unique = true)
    private String email;

    @JsonManagedReference
    @OneToMany(mappedBy = "owner")
    private List<AccountEntity> accounts = new ArrayList<>();

    public CustomerEntity() {
    }

    public CustomerEntity(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    @Override
    public String toString() {
        return "CustomerEntity{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
