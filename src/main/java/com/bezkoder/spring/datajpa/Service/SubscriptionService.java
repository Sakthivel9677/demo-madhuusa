package com.bezkoder.spring.datajpa.Service;

import com.bezkoder.spring.datajpa.model.Subscription;

import java.util.List;

public interface SubscriptionService {
    public String loadSubscription(List<Subscription> c);
    public Subscription getSubscriptionBySubscription(String subscription);
    public String modifySubscription(int custId,String subscription);
}
