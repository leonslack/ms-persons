package com.leon.ms_persons.service.client;

import com.leon.ms_persons.domain.Client;
import com.leon.ms_persons.domain.dto.request.ClientRequestDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ClientService {
    Client saveClient(ClientRequestDTO client);
    Page<Client> getAllClients(Pageable pageable);
    Optional<Client> getClientById(Long id);
    void deleteClient(Long id);
    Client updateClient(Long id,Client client);
}
