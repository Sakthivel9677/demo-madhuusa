package com.bezkoder.spring.datajpa.repository;

import com.bezkoder.spring.datajpa.model.PromoCode;
import com.bezkoder.spring.datajpa.model.PurchaseProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PurchaseProductRepository extends JpaRepository<PurchaseProduct,Long> {
    @Query(value="select * from purchase_product where cust_id=?",nativeQuery = true)
    List<PurchaseProduct> getallrowOfGivenCustomer(int cust_id);
    @Query(value="select count(*) from purchase_product where cust_id=?",nativeQuery = true)
    int getcustcount(int cust_id);
}
