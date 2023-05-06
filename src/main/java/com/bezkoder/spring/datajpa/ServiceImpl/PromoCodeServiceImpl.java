package com.bezkoder.spring.datajpa.ServiceImpl;

import com.bezkoder.spring.datajpa.Service.PromoCodeService;
import com.bezkoder.spring.datajpa.dao.Productdao;
import com.bezkoder.spring.datajpa.model.PromoCode;
import com.bezkoder.spring.datajpa.repository.PromoCodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PromoCodeServiceImpl implements PromoCodeService {
    @Autowired
    Productdao productdao;
    @Autowired
    PromoCodeRepository promoCodeRepository;

    @Override
    public PromoCode getPromocodeByCode(String promocode) {
        return promoCodeRepository.findByPromocode(promocode);
    }

    @Override
    public PromoCode save(PromoCode promoCode) {
        return promoCodeRepository.save(promoCode);
    }



    @Override
    public String loadPromocode(List<PromoCode> b) {
        return productdao.loadPromocode(b);
    }

    @Override
    public void updateVoucher(PromoCode promoCode) {
        productdao.update(promoCode);
    }
}
