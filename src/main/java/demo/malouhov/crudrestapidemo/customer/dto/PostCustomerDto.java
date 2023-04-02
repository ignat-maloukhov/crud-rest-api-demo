package demo.malouhov.crudrestapidemo.customer.dto;

import jakarta.validation.constraints.NotNull;

public record PostCustomerDto(@NotNull String firstName,
                              @NotNull String lastName,
                              @NotNull String email) {
}