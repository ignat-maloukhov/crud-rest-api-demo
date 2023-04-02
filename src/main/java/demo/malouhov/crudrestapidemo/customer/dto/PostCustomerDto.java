package demo.malouhov.crudrestapidemo.customer.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record PostCustomerDto(
        @NotBlank(message = "First Name is mandatory") String firstName,
        @NotBlank(message = "Last Name is mandatory") String lastName,
        @NotBlank(message = "Email is mandatory") @Email String email) {
}