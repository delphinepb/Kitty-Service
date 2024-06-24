package com.bforbank.cagnotteservice.service;

import com.bforbank.cagnotteservice.entity.Client;
import com.bforbank.cagnotteservice.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client createClient() {
        Client newClient = new Client();
        newClient.setNom("nom");
        newClient.setEmail("email");
        return clientRepository.save(newClient);
    }

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public Optional<Client> getClientById(Long clientId) throws Exception{
        return Optional.ofNullable(clientRepository.findById(clientId).orElseThrow(() -> new Exception("Client not found")));

    }

    public void deleteClient(Long clientId) throws Exception {
        if (clientRepository.existsById(clientId)) {
            clientRepository.deleteById(clientId);
        } else {
            throw new Exception("Client not found");
        }
    }
}
