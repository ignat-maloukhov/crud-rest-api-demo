package demo.malouhov.crudrestapidemo.customer.dto;

import demo.malouhov.crudrestapidemo.account.AccountEntity;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record GetCustomerDto(@NotNull String firstName,
                             @NotNull String lastName,
                             @NotNull String email,
                             @NotNull List<AccountEntity> accounts) {
}