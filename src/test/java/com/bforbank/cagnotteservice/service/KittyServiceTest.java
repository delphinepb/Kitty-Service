package com.bforbank.cagnotteservice.service;

import com.bforbank.cagnotteservice.entity.Client;
import com.bforbank.cagnotteservice.entity.Kitty;
import com.bforbank.cagnotteservice.repository.ClientRepository;
import com.bforbank.cagnotteservice.repository.KittyRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class KittyServiceTest {
    @Autowired
    private KittyService kittyService;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private KittyRepository kittyRepository;

    @Test
    public void testAddAmount() {
        Client client = new Client();
        client.setNom("Test Client");
        clientRepository.save(client);

        Kitty kitty = kittyService.addAmount(client.getId(), 5);
        assertEquals(5, kitty.getAmount());
        assertEquals(1, kitty.getCheckout());
    }

    @Test
    public void testIsAvailable() {
        Client client = new Client();
        client.setNom("Test Client");
        clientRepository.save(client);

        kittyService.addAmount(client.getId(), 5);
        kittyService.addAmount(client.getId(), 3);
        kittyService.addAmount(client.getId(), 2);

        assertTrue(kittyService.isAvailable(client.getId()));
    }
}
