package com.bforbank.cagnotteservice.repository;

import com.bforbank.cagnotteservice.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
