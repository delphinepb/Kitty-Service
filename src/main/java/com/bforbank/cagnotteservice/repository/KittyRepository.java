package com.bforbank.cagnotteservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bforbank.cagnotteservice.entity.Kitty;

public interface KittyRepository extends JpaRepository<Kitty, Long> {
}
