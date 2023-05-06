package com.bezkoder.spring.datajpa.dao;

import com.bezkoder.spring.datajpa.model.*;

import java.util.List;

public interface Productdao {
  public  String loadProduct(List<Product> a);

  public  String loadPromocode(List<PromoCode> b);

  public Product getProductByName(String name);
  public PromoCode getPromoByCode(String promocode);
  public String loadcustomer(List<Customer> c);
  public String loadCustomer(Customer c);

 public  String loadSubscription(List<Subscription> c);

   public  String loadCustomer(List<Customer> d);

   public String loadPurchaseProduct(PurchaseProduct b);

   public String modifyPurchaseProduct(PurchaseProduct b);

 public String update(PromoCode promoCode);

public   String loadPurchaseProduct(List<PurchaseProduct> b);
}
