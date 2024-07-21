package com.leon.ms_persons.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

import java.io.Serializable;

@Table(name = "client")
@Data
@Entity
public class Client extends Person implements Serializable{
    private Long clientId;
    private String password;
    private boolean status;
}
