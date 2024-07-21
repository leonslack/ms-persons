package com.leon.ms_persons.domain.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class PersonRequestDTO {
    private String name;
    private String gender;
    private LocalDate birthdate;
    private String identification;
    private String address;
    private String phoneNumber;
}
