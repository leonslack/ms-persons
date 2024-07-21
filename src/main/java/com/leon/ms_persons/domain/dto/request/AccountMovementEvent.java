package com.leon.ms_persons.domain.dto.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AccountMovementEvent {
    private Long accountId;
    private Long clientId;
    private double newBalance;
}
