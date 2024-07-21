package com.leon.ms_persons.domain.dto.request;

import com.leon.ms_persons.domain.Client;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ClientRequestDTO extends PersonRequestDTO{
    private Long clientId;
    private String password;
    private boolean status;

    public Client toDomain() {
        Client client = new Client();
        client.setClientId(this.getClientId());
        client.setName(this.getName());
        client.setGender(this.getGender());
        client.setBirthdate(this.getBirthdate());
        client.setIdentification(this.getIdentification());
        client.setAddress(this.getAddress());
        client.setPhoneNumber(this.getPhoneNumber());
        client.setPassword(this.getPassword());
        client.setStatus(this.isStatus());
        return client;
    }
}
