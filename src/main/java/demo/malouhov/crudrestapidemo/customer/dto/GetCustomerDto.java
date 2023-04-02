package demo.malouhov.crudrestapidemo.customer.dto;

import demo.malouhov.crudrestapidemo.account.AccountEntity;

import java.util.List;

public record GetCustomerDto(String firstName,
                             String lastName,
                             String email,
                             List<AccountEntity> accounts) {
}