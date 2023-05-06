package com.bezkoder.spring.datajpa.ServiceImpl;

import com.bezkoder.spring.datajpa.Service.ProductService;


import com.bezkoder.spring.datajpa.Service.PromoCodeService;
import com.bezkoder.spring.datajpa.dao.Productdao;
import com.bezkoder.spring.datajpa.model.Product;
import com.bezkoder.spring.datajpa.model.ProductPrice;
import com.bezkoder.spring.datajpa.model.PromoCode;
import com.bezkoder.spring.datajpa.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    Productdao productdao;
    @Autowired
    PromoCodeService promoCodeService;
    @Autowired
    ProductRepository productRepository;

    @Override
    public Product getProductName(String productName) {
        return productRepository.findByProductName(productName);
    }

    @Override
    public String loadProduct(List<Product> a) {
        // TODO Auto-generated method stub
        return productdao.loadProduct(a);
    }

    @Override
    public ProductPrice getProductPrice(String productName, String promocode) {
        Product product=getProductName(productName);
        PromoCode promoCode=promoCodeService.getPromocodeByCode(promocode);
        double finalPrice=product.getPrice();
        double discount=0;
        String appliedpromo=promocode;
        if(promocode != null && promoCode.getNumberOfVoucher()>0){
            appliedpromo=promoCode.getPromocode();
            if(promoCode.getDiscountType().equals("%")){
                discount=product.getPrice()*promoCode.getDiscount()/100;
                finalPrice=product.getPrice()-discount;
            } else if (promoCode.getDiscountType().equals("CHF")) {
                discount=promoCode.getDiscount();
                finalPrice=product.getPrice()-discount;

            }
            promoCode.setNumberOfVoucher(promoCode.getNumberOfVoucher()-1);
            promoCodeService.updateVoucher(promoCode);
        }
        return new ProductPrice(product.getProductName(),product.getPrice(),appliedpromo,discount,finalPrice);
    }
}
