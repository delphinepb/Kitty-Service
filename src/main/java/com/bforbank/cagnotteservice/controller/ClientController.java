package com.bforbank.cagnotteservice.controller;

import com.bforbank.cagnotteservice.entity.Client;
import com.bforbank.cagnotteservice.entity.Kitty;
import com.bforbank.cagnotteservice.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping
    public ResponseEntity<List<Client>> getAllClients() {
        List<Client> clients = clientService.getAllClients();
        return ResponseEntity.ok(clients);
    }

    @GetMapping("/{clientId}")
    public ResponseEntity<Client> getClientById(@PathVariable Long clientId) throws Exception {
        Optional<Client> client = clientService.getClientById(clientId);
        return client.map(ResponseEntity::ok)
                     .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Client> createClient() {
        Client createdClient = clientService.createClient();
        return ResponseEntity.ok(createdClient);
    }


    @DeleteMapping("/{clientId}")
    public ResponseEntity<Void> deleteClient(@PathVariable Long clientId) throws Exception {
        Optional<Client> optionalClient = clientService.getClientById(clientId);
        if (optionalClient.isPresent()) {
            clientService.deleteClient(clientId);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}