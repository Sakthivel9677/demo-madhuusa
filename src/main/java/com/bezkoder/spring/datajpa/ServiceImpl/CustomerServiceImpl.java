package com.bezkoder.spring.datajpa.ServiceImpl;

import com.bezkoder.spring.datajpa.Service.CustomerService;
import com.bezkoder.spring.datajpa.dao.Productdao;
import com.bezkoder.spring.datajpa.model.Customer;
import com.bezkoder.spring.datajpa.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    Productdao productdao;
    @Autowired
    CustomerRepository customerRepository;
    @Override
    public String loadCustomer(List<Customer> d) {
        return productdao.loadCustomer(d);
    }

    @Override
    public String loadCustomer(Customer c) {
        return productdao.loadCustomer(c);
    }

    @Override
    public Customer getCustomer(int custId) {
        return customerRepository.findByCustId(custId);
    }

    @Override
    public int getcustcountbycustId(int custid) {
        return customerRepository.getcustcount(custid);
    }

    @Override
    public List<Customer> getallrowOfGivenCustomer(int custid) {
        return customerRepository.getallrowOfGivenCustomer(custid);
    }
}
