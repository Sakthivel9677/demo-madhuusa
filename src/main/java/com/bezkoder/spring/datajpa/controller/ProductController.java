package com.bezkoder.spring.datajpa.controller;

import com.bezkoder.spring.datajpa.Service.*;
import com.bezkoder.spring.datajpa.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productapi")
public class ProductController {
    @Autowired
    ProductService productService;
    @Autowired
    PromoCodeService promoCodeService;
    @Autowired
    SubscriptionService subscriptionService;
    @Autowired
    CustomerService customerService;
    @Autowired
    PurchaseProductService purchaseProductService;


    @PostMapping(value="/loadProduct")
    public ResponseEntity<List<Product>>loadProduct(@RequestBody List<Product> a){
        productService.loadProduct(a);
        return new ResponseEntity<>(a, HttpStatus.OK);

    }
    @PostMapping(value="/loadPromocode")
    public ResponseEntity<List<PromoCode>> loadPromocode(@RequestBody List<PromoCode> b){
        promoCodeService.loadPromocode(b);
        return new ResponseEntity<>(b,HttpStatus.OK);

    }
    @PostMapping(value="/loadSubscription")
    public ResponseEntity<List<Subscription>> loadSubscription(@RequestBody List<Subscription> c){
        subscriptionService.loadSubscription(c);
        return new ResponseEntity<>(c,HttpStatus.OK);

    }
    @PostMapping(value="/loadCustomer")
    public ResponseEntity<List<Customer>> loadCustomer(@RequestBody List<Customer> d){
        customerService.loadCustomer(d);
        return new ResponseEntity<>(d,HttpStatus.OK);

    }
    @PostMapping("/PurchaseProduct")
    public ResponseEntity<PurchaseProductRequest> PurchaseProduct(@RequestBody PurchaseProductRequest purchaseProductRequest){
        PurchaseProductRequest response=purchaseProductService.buyProduct(purchaseProductRequest);
        if(response.getResponse().contains("Sucess")){
            return new ResponseEntity<>(response,HttpStatus.CREATED);
        }
        else{
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @PostMapping("/custId/{custId}/subscription/{subscription}")
    public ResponseEntity<String> modifySubscription(@PathVariable("custId")int custId,@PathVariable("subscription")String subscription){
        String response=subscriptionService.modifySubscription(custId,subscription);
        if(response.contains("Sucess")){
            return new ResponseEntity<>("subscription Modified",HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(response,HttpStatus.EXPECTATION_FAILED);
        }
    }
    @PostMapping("/productName/{productName}/promocode/{promocode}")
    public ResponseEntity<ProductPrice> getProductPrice(@PathVariable("productName")String productName,@PathVariable("promocode")String promocode){
        try{
            ProductPrice response=productService.getProductPrice(productName,promocode);
            return new ResponseEntity<>(response,HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(new ProductPrice(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
