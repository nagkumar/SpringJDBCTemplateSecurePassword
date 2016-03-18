package com.teja.customer.dao;

import com.teja.customer.model.Customer;

import java.util.List;

public interface CustomerDAO
{
    public void insert(final Customer aCustomer);

    public void insertNamedParameter(final Customer aCustomer);

    public void insertBatch(List<Customer> aCustomer);

    public void insertBatchNamedParameter(List<Customer> aCustomer);

    public void insertBatchNamedParameter2(List<Customer> aCustomer);

    public void insertBatchSQL(String sql);

    public Customer findByCustomerId(int aCustomerID);

    public Customer findByCustomerId2(int aCustomerID);

    public List<Customer> findAll();

    public List<Customer> findAll2();

    public String findCustomerNameById(int aCustomerID);

    public int findTotalCustomer();
}