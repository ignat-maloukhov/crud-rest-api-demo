package demo.malouhov.crudrestapidemo.dto;

import demo.malouhov.crudrestapidemo.entity.AccountEntity;

import java.util.List;

public record GetCustomerDto(
        String firstName,
        String lastName,
        String email,
        List<AccountEntity> accounts) {
}