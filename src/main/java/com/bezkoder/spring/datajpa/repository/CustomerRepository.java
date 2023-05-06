package com.bezkoder.spring.datajpa.repository;

import com.bezkoder.spring.datajpa.model.Customer;
import com.bezkoder.spring.datajpa.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
    Customer findByCustId(int custId);
    @Query(value="select count(*) from customer_details where cust_id=?",nativeQuery = true)
    int getcustcount(int cust_id);
    @Query(value="select * from customer_details where cust_id=?",nativeQuery = true)
    List<Customer> getallrowOfGivenCustomer(int cust_id);
}
