package br.com.personal.expenses.personalexpenses.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.personal.expenses.personalexpenses.domain.model.Advertisement;

public interface AdvertisementRepository extends JpaRepository<Advertisement, Long> {
    

}
