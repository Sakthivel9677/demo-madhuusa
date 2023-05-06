package com.bezkoder.spring.datajpa.Service;

import com.bezkoder.spring.datajpa.model.PromoCode;

import java.util.List;

public interface PromoCodeService {
    public PromoCode getPromocodeByCode(String promocode);
    public PromoCode save(PromoCode promoCode);

    public  String loadPromocode(List<PromoCode> b);

   public void updateVoucher(PromoCode promoCode);
}
