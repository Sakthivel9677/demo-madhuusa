package com.bezkoder.spring.datajpa.repository;

import com.bezkoder.spring.datajpa.model.PromoCode;
import com.bezkoder.spring.datajpa.model.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription,Long> {
  Subscription  findBySubscriptionName(String subscription);
}
