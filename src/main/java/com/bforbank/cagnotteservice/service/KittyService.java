package com.bforbank.cagnotteservice.service;

import com.bforbank.cagnotteservice.entity.Kitty;
import com.bforbank.cagnotteservice.repository.KittyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KittyService {

    private final KittyRepository kittyRepository;

    @Autowired
    public KittyService(KittyRepository kittyRepository) {
        this.kittyRepository = kittyRepository;
    }

    // Crée une nouvelle cagnotte
    public Kitty createKitty() {
        Kitty newKitty = new Kitty();
        newKitty.setAmount(0.0);
        newKitty.setCheckout(0);
        return kittyRepository.save(newKitty);
    }

    // Ajoute un montant à la cagnotte existante
    public Kitty addAmountToKitty(Long kittyId, double amount) throws Exception {
        Optional<Kitty> optionalKitty = kittyRepository.findById(kittyId);
        if (optionalKitty.isPresent()) {
            Kitty kitty = optionalKitty.get();
            kitty.setAmount(kitty.getAmount() + amount);
            kitty.setCheckout(kitty.getCheckout() + 1);
            return kittyRepository.save(kitty);
        } else {
            throw new Exception("Kitty not found");
        }
    }

    // Vérifie si une cagnotte est disponible
    public boolean isKittyAvailable(Long kittyId) throws Exception {
        Optional<Kitty> optionalKitty = kittyRepository.findById(kittyId);
        if (optionalKitty.isPresent()) {
            Kitty kitty = optionalKitty.get();
            return kitty.getCheckout() >= 3 && kitty.getAmount() >= 10.0;
        } else {
            throw new Exception("Kitty not found");
        }
    }

    // Obtient une cagnotte par ID
    public Kitty findKittyById(Long kittyId) throws Exception {
        return kittyRepository.findById(kittyId).orElseThrow(() -> new Exception("Kitty not found"));
    }

    // Supprime une cagnotte par ID
    public void deleteKittyById(Long kittyId) throws Exception {
        if (kittyRepository.existsById(kittyId)) {
            kittyRepository.deleteById(kittyId);
        } else {
            throw new Exception("Kitty not found");
        }
    }

    // Liste toutes les cagnottes
    public List<Kitty> getAllKitties() {
        return kittyRepository.findAll();
    }
}
