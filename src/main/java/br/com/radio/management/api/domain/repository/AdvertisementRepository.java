package br.com.radio.management.api.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.radio.management.api.domain.model.Advertisement;

public interface AdvertisementRepository extends JpaRepository<Advertisement, Long> {
    

}
