package com.bezkoder.spring.datajpa.repository;

import com.bezkoder.spring.datajpa.model.Product;
import com.bezkoder.spring.datajpa.model.PromoCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PromoCodeRepository extends JpaRepository<PromoCode,Long> {
    PromoCode findByPromocode(String promocode);
}
