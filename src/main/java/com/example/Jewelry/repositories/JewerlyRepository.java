package com.example.Jewelry.repositories;

import com.example.Jewelry.models.Jewelry;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JewerlyRepository extends JpaRepository<Jewelry, UUID> {
}
