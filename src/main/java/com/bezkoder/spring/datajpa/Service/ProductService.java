package com.bezkoder.spring.datajpa.Service;

import com.bezkoder.spring.datajpa.model.Product;
import com.bezkoder.spring.datajpa.model.ProductPrice;
import com.bezkoder.spring.datajpa.model.PromoCode;

import java.util.List;

public interface ProductService {
    public Product getProductName(String productName);
    public String loadProduct(List<Product> a);

    public ProductPrice getProductPrice(String productName,String promocode);


}
