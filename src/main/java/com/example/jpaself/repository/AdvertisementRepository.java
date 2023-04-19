package com.example.jpaself.repository;

import com.example.jpaself.domain.mapping.Advertisement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdvertisementRepository extends JpaRepository<Advertisement, String> {
}
