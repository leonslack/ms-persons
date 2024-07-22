package com.leon.ms_persons.service.client.impl;

import com.leon.ms_persons.domain.Client;
import com.leon.ms_persons.domain.dto.request.ClientRequestDTO;
import com.leon.ms_persons.exception.EntityNotFoundException;
import com.leon.ms_persons.repository.ClientRepository;
import com.leon.ms_persons.service.client.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;


    @Override
    public Client saveClient(ClientRequestDTO client) {
        return clientRepository.save(client.toDomain());
    }

    @Override
    public Page<Client> getAllClients(Pageable pageable) {
        return clientRepository.findAll(pageable);
    }

    @Override
    public Optional<Client> getClientById(Long id) {
        return clientRepository.findById(id);
    }

    @Override
    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }

    @Override
    public Client updateClient(Long id, Client updatedClient) {
        Optional<Client> existingClientOptional = getClientById(id);
        if(existingClientOptional.isEmpty()) {
            throw new EntityNotFoundException("Client not found with id " + updatedClient.getId());
        }

        Client existingClient = existingClientOptional.get();
        existingClient.setName(updatedClient.getName());
        existingClient.setGender(updatedClient.getGender());
        existingClient.setBirthdate(updatedClient.getBirthdate());
        existingClient.setIdentification(updatedClient.getIdentification());
        existingClient.setAddress(updatedClient.getAddress());
        existingClient.setPhoneNumber(updatedClient.getPhoneNumber());
        existingClient.setPassword(updatedClient.getPassword());
        existingClient.setStatus(updatedClient.isStatus());
        return clientRepository.save(existingClient);
    }
}
