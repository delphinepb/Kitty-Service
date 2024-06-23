package com.bforbank.cagnotteservice.entity;

import jakarta.persistence.*;

@Entity
public class Kitty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double amount;
    private int checkout;

    @ManyToOne(optional = false)
    @JoinColumn(name = "CLIENT_ID", referencedColumnName = "ID")
    private Client client;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getCheckout() {
        return checkout;
    }

    public void setCheckout(int checkout) {
        this.checkout = checkout;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
