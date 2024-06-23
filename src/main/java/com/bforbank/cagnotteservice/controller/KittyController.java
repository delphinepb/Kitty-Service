package com.bforbank.cagnotteservice.controller;

import com.bforbank.cagnotteservice.entity.Kitty;
import com.bforbank.cagnotteservice.service.KittyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/kitties")
public class KittyController {

    private final KittyService kittyService;

    @Autowired
    public KittyController(KittyService kittyService) {
        this.kittyService = kittyService;
    }

    // Create a new kitty
    @PostMapping
    public ResponseEntity<Kitty> createKitty() {
        Kitty createdKitty = kittyService.createKitty();
        return ResponseEntity.ok(createdKitty);
    }

    // Add an amount to the kitty
    @PostMapping("/{kittyId}/add")
    public ResponseEntity<Kitty> addAmountToKitty(@PathVariable Long kittyId, @RequestParam double amount) {
        try {
            Kitty updatedKitty = kittyService.addAmountToKitty(kittyId, amount);
            return ResponseEntity.ok(updatedKitty);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    // Check kitty availability
    @GetMapping("/{kittyId}/available")
    public ResponseEntity<Boolean> isKittyAvailable(@PathVariable Long kittyId) {
        try {
            boolean available = kittyService.isKittyAvailable(kittyId);
            return ResponseEntity.ok(available);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(false);
        }
    }

    // Get a kitty by ID
    @GetMapping("/{kittyId}")
    public ResponseEntity<Kitty> findKittyById(@PathVariable Long kittyId) {
        try {
            Kitty kitty = kittyService.findKittyById(kittyId);
            return ResponseEntity.ok(kitty);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete a kitty by ID
    @DeleteMapping("/{kittyId}")
    public ResponseEntity<Void> deleteKittyById(@PathVariable Long kittyId) {
        try {
            kittyService.deleteKittyById(kittyId);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    // List all pools
    @GetMapping
    public ResponseEntity<List<Kitty>> getAllKitties() {
        List<Kitty> kitties = kittyService.getAllKitties();
        return ResponseEntity.ok(kitties);
    }
}
