package com.kpq.store.customer.service;

import com.kpq.store.customer.repository.entity.Customer;
import com.kpq.store.customer.repository.entity.Region;

import java.util.List;

public interface ICustomerService {

    public List<Customer> findCustomerAll();
    public List<Customer> findCustomersByRegion(Region region);

    public Customer createCustomer(Customer customer);
    public Customer updateCustomer(Customer customer);
    public Customer deleteCustomer(Customer customer);
    public Customer getCustomer(Long id);
}
