package com.bezkoder.spring.datajpa.ServiceImpl;

import com.bezkoder.spring.datajpa.Service.CustomerService;
import com.bezkoder.spring.datajpa.Service.PurchaseProductService;
import com.bezkoder.spring.datajpa.Service.SubscriptionService;
import com.bezkoder.spring.datajpa.Util.DateUtil;
import com.bezkoder.spring.datajpa.dao.Productdao;
import com.bezkoder.spring.datajpa.exception.UserDefinedException;
import com.bezkoder.spring.datajpa.model.Customer;
import com.bezkoder.spring.datajpa.model.PurchaseProduct;
import com.bezkoder.spring.datajpa.model.PurchaseProductRequest;
import com.bezkoder.spring.datajpa.model.Subscription;
import com.bezkoder.spring.datajpa.repository.PurchaseProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static java.time.temporal.ChronoUnit.DAYS;

@Service
public class PurchaseProductServiceImpl implements PurchaseProductService {
    @Autowired
    Productdao productdao;
    @Autowired
    PurchaseProductRepository purchaseProductRepository;
    @Autowired
    CustomerService customerService;
   @Autowired
   @Lazy
    SubscriptionService subscriptionService;
    @Override
    public List<PurchaseProduct> getAllrowOfGivenCustomer(int custid) {
        return purchaseProductRepository.getallrowOfGivenCustomer(custid);
    }
public String loadPurchaseProduct(List<PurchaseProduct>  b){
        return productdao.loadPurchaseProduct( b);
}


    @Override
    public String loadPurchaseProduct(PurchaseProduct b) {
        return productdao.loadPurchaseProduct(b);
    }


    @Override
    public String modifyPurchaseProduct(PurchaseProduct b) {
        return productdao.modifyPurchaseProduct(b);
    }

    @Override
    public int getcustcountbycustId(int custid) {
        return purchaseProductRepository.getcustcount(custid);
    }

    @Override
    public PurchaseProductRequest buyProduct(PurchaseProductRequest purchaseProductRequest) {
        LocalDate currentDate= LocalDate.now();
        try{
            int cnt=customerService.getcustcountbycustId(purchaseProductRequest.getCustId());
            Subscription newsubscription=subscriptionService.getSubscriptionBySubscription(purchaseProductRequest.getSubscription());
            if(cnt>0){
                List<PurchaseProduct> existingPurchasedtl=getAllrowOfGivenCustomer(purchaseProductRequest.getCustId());
                for(int i=0;i<existingPurchasedtl.size();i++){
                    Subscription existingsubscription=subscriptionService.getSubscriptionBySubscription(existingPurchasedtl.get(i).getCustomerSubscription());
                    long diffDays=DAYS.between(existingPurchasedtl.get(i).getSubscriptionDate(),currentDate);
                    LocalDate subendDate=existingPurchasedtl.get(i).getSubscriptionDate().plusDays(30);
                    DateTimeFormatter dtf=DateTimeFormatter.ofPattern("dd-MM-yyyy");
                    if(newsubscription.getSubscriptionType().equals("postpaid")&& existingsubscription.getSubscriptionType().equals("postpaid")){
                        throw new UserDefinedException("You can not buy multiple postpaid");
                    } else if (newsubscription.getSubscriptionName().equals("prepaid")&&existingsubscription.getSubscriptionType().equals("postpaid")&&existingsubscription.getSubscriptionName().contains("30D")&&diffDays <=30) {
                        throw new UserDefinedException("you can buy new subscription only on"+dtf.format(subendDate)+"date");
                        
                    }
                }
                PurchaseProductRequest request=new PurchaseProductRequest();
                request.setName(purchaseProductRequest.getName());
                request.setAge(purchaseProductRequest.getAge());
                request.setGender(purchaseProductRequest.getGender());
                request.setAddress(purchaseProductRequest.getAddress());
                request.setProductName(purchaseProductRequest.getProductName());
                request.setCustId(purchaseProductRequest.getCustId());
                request.setSubscription(purchaseProductRequest.getSubscription());
                request.setPromocode(purchaseProductRequest.getPromocode());
                request.setSubscriptionDate(currentDate);
                request.setResponse("Sucess");
                return request;
            }
            else{
                LocalDate localDate=LocalDate.now();
                DateTimeFormatter formatter= DateTimeFormatter.ISO_LOCAL_DATE;
                String formatedString=localDate.format(formatter);
                Customer c=new Customer();
                c.setAddress(purchaseProductRequest.getAddress());
                c.setAge(purchaseProductRequest.getAge());
                c.setCustId(purchaseProductRequest.getCustId());
                c.setName(purchaseProductRequest.getName());
                c.setGender(purchaseProductRequest.getGender());
                PurchaseProduct pp=new PurchaseProduct();
                pp.setCustomerSubscription(purchaseProductRequest.getSubscription());
                pp.setCustId(purchaseProductRequest.getCustId());
                pp.setPromoCode(purchaseProductRequest.getPromocode());
                pp.setCustomerProduct(purchaseProductRequest.getProductName());
                DateTimeFormatter format=DateTimeFormatter.ISO_LOCAL_DATE;
                String subDate=currentDate.format(formatter);
                pp.setSubscriptionDate(DateUtil.convertToDate(subDate));
                customerService.loadCustomer(c);
                productdao.loadPurchaseProduct(pp);
                PurchaseProductRequest request=new PurchaseProductRequest();
                request.setName(purchaseProductRequest.getName());
                request.setAge(purchaseProductRequest.getAge());
                request.setGender(purchaseProductRequest.getGender());
                request.setAddress(purchaseProductRequest.getAddress());
                request.setProductName(purchaseProductRequest.getProductName());
                request.setCustId(purchaseProductRequest.getCustId());
                request.setSubscription(purchaseProductRequest.getSubscription());
                request.setPromocode(purchaseProductRequest.getPromocode());
                request.setSubscription(purchaseProductRequest.getSubscription());
                request.setPromocode(purchaseProductRequest.getPromocode());
                request.setSubscription(purchaseProductRequest.getSubscription());
                request.setPromocode(purchaseProductRequest.getPromocode());
                request.setSubscription(purchaseProductRequest.getSubscription());
                request.setResponse("Sucess");
                return request;
            }
        }
        catch(UserDefinedException ude){
            PurchaseProductRequest request=new PurchaseProductRequest();
            request.setName(purchaseProductRequest.getName());
            request.setAge(purchaseProductRequest.getAge());
            request.setGender(purchaseProductRequest.getGender());
            request.setAddress(purchaseProductRequest.getAddress());
            request.setProductName(purchaseProductRequest.getProductName());
            request.setPromocode(purchaseProductRequest.getPromocode());
            request.setPromocode(purchaseProductRequest.getPromocode());
            request.setSubscriptionDate(currentDate);
            request.setResponse(ude.getMessage());
            return request;

        }
    }
}
