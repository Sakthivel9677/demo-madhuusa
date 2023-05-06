package com.bezkoder.spring.datajpa.ServiceImpl;

import com.bezkoder.spring.datajpa.Service.PurchaseProductService;
import com.bezkoder.spring.datajpa.Service.SubscriptionService;
import com.bezkoder.spring.datajpa.dao.Productdao;
import com.bezkoder.spring.datajpa.exception.UserDefinedException;
import com.bezkoder.spring.datajpa.model.PurchaseProduct;
import com.bezkoder.spring.datajpa.model.Subscription;
import com.bezkoder.spring.datajpa.repository.SubscriptionRepository;
;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static java.time.temporal.ChronoUnit.DAYS;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {
    @Autowired
    Productdao productdao;
    @Autowired
    SubscriptionRepository subscriptionRepository;
    @Autowired
     @Lazy
    PurchaseProductService purchaseProductService;
    @Override
    public String loadSubscription(List<Subscription> c) {
        return   productdao.loadSubscription(c);
    }

    @Override
    public Subscription getSubscriptionBySubscription(String subscription) {
        return subscriptionRepository.findBySubscriptionName(subscription);
    }

    @Override

    public String modifySubscription(int custId, String subscription) {
        LocalDate currentDate=LocalDate.now();
        try{
            int cnt=purchaseProductService.getcustcountbycustId(custId);
            if(cnt>0){
                List<PurchaseProduct> existingPurchasedtl=purchaseProductService.getAllrowOfGivenCustomer(custId);
                for(int i=0;i< existingPurchasedtl.size();i++){
                    Subscription existSubscription=getSubscriptionBySubscription(existingPurchasedtl.get(i).getCustomerSubscription());
                    long diffdays=DAYS.between(existingPurchasedtl.get(i).getSubscriptionDate(),currentDate);
                    LocalDate subendDate=existingPurchasedtl.get(i).getSubscriptionDate().plusDays(30);
                    DateTimeFormatter dtf=DateTimeFormatter.ofPattern("dd-MM-yyyy");
                    if((existSubscription.getSubscriptionType().contains("postpaid"))&& subscription.contains("postpaid")){
                        throw new UserDefinedException(("You cannot buy new postpaid again"));
                    }
                    if((existSubscription.getSubscriptionType().contains("prepaid"))
                        && subscription.contains("postpaid")){
                        throw new UserDefinedException("You cannot buy prepaid and postpaid together");
                    }
                    if(existSubscription.getSubscriptionType().contains("postpaid")&& existSubscription.getSubscriptionName().contains("30D")&& diffdays <=30){
                        throw new UserDefinedException("you can buy new subscription only on"+dtf.format(subendDate));

                    }
                    existingPurchasedtl.get(i).setCustomerSubscription(subscription);
                    purchaseProductService.modifyPurchaseProduct(existingPurchasedtl.get(i));
                }}
                else {
                    throw new UserDefinedException("customer not exist so cannot modify subscription");
                }
                return "sucess";

        }
            catch(UserDefinedException ude){
                return ude.getMessage();
            }
        }

    }

