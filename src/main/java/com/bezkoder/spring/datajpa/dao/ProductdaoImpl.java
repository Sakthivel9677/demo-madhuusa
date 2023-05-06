package com.bezkoder.spring.datajpa.dao;

import com.bezkoder.spring.datajpa.model.*;
import com.bezkoder.spring.datajpa.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductdaoImpl implements Productdao {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    PromoCodeRepository promoCodeRepository;
    @Autowired
    SubscriptionRepository subscriptionRepository;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    PurchaseProductRepository purchaseProductRepository;


    @Override
    public String loadProduct(List<Product> a) {
        productRepository.saveAll(a);
        return "sucessfully saved";
    }

    @Override
    public String loadPromocode(List<PromoCode> b) {
        promoCodeRepository.saveAll(b);

        return "sucessfullysaved";
    }

    @Override
    public String update(PromoCode promoCode) {
        promoCodeRepository.save(promoCode);
        return "sucessfullysaved";
    }

    @Override
    public String loadPurchaseProduct(List<PurchaseProduct> b) {
        purchaseProductRepository.saveAll(b);
        return "sucessfullly saved";
    }

    @Override
    public Product getProductByName(String name) {
        return productRepository.findByProductName(name);
    }

    @Override
    public PromoCode getPromoByCode(String promocode) {
        return promoCodeRepository.findByPromocode(promocode);
    }

    @Override
    public String loadcustomer(List<Customer> c) {
        customerRepository.saveAll(c);
        return "customer load was sucessfully saved";
    }

    @Override
    public String loadCustomer(Customer c) {
        return null;
    }


    @Override
    public String loadSubscription(List<Subscription> c) {
        subscriptionRepository.saveAll(c);
        return "sucessfullysaved";
    }

    @Override
    public String loadCustomer(List<Customer> d) {
        customerRepository.saveAll(d);
        return "sucessfullysaved";
    }




    @Override
    public String loadPurchaseProduct(PurchaseProduct b) {
        purchaseProductRepository.save(b);
        return "sucessfull";
    }

    @Override
    public String modifyPurchaseProduct(PurchaseProduct b) {
        purchaseProductRepository.save(b);
        return "sucessfull";
    }
}
