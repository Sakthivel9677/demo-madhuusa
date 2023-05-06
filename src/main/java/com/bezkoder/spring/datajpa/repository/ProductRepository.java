package com.bezkoder.spring.datajpa.repository;

import com.bezkoder.spring.datajpa.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    @Query(value="select * from product_details where product_name=?",nativeQuery = true)
    Product findByProductName(String product_name);

}
