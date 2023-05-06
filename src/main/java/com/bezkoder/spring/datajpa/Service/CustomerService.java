package com.bezkoder.spring.datajpa.Service;

import com.bezkoder.spring.datajpa.model.Customer;

import java.util.List;

public interface CustomerService {
    public String loadCustomer(List<Customer> d);
    public String loadCustomer(Customer c);
    public Customer getCustomer(int custId);
    public int getcustcountbycustId(int custid);
    public List<Customer> getallrowOfGivenCustomer(int custid);
}
