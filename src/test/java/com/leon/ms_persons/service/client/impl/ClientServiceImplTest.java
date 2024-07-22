package com.leon.ms_persons.service.client.impl;

import com.leon.ms_persons.domain.Client;
import com.leon.ms_persons.domain.dto.request.ClientRequestDTO;
import com.leon.ms_persons.repository.ClientRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
class ClientServiceImplTest {

    @Autowired
    private ClientServiceImpl clientService;

    @MockBean
    private ClientRepository clientRepository;

    @Test
    void saveClient() {
        ClientRequestDTO client = new ClientRequestDTO();
        client.setClientId(12345L);
        client.setPassword("password");
        client.setStatus(true);

        Mockito.when(clientRepository.save(client.toDomain())).thenReturn(client.toDomain());
        Client createdClient = clientService.saveClient(client);
        assertEquals(createdClient.getClientId(), client.getClientId());
        assertEquals(createdClient.getPassword(), client.getPassword());
        assertEquals(createdClient.isStatus(), client.isStatus());
    }
}