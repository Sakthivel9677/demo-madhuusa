package com.bezkoder.spring.datajpa.Service;

import com.bezkoder.spring.datajpa.model.PurchaseProduct;
import com.bezkoder.spring.datajpa.model.PurchaseProductRequest;

import java.util.List;

public interface PurchaseProductService {

    public List<PurchaseProduct> getAllrowOfGivenCustomer(int custid);
public String loadPurchaseProduct(List<PurchaseProduct>b);

    public String loadPurchaseProduct(PurchaseProduct b);
    public String modifyPurchaseProduct(PurchaseProduct b);
    public int getcustcountbycustId(int custid);
    public PurchaseProductRequest buyProduct(PurchaseProductRequest purchaseProductRequest);
}
