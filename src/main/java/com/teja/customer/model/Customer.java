package com.teja.customer.model;

import java.io.Serializable;

public final class Customer implements Serializable
{
    private long custId;
    private String name;
    private int age;

    public Customer()
    {
    }

    public Customer(final long aCustomerID, final String aName, final int aAge)
    {
	custId = aCustomerID;
	name = aName;
	age = aAge;
    }

    public long getCustId()
    {
	return custId;
    }

    public void setCustId(long aCustomerID)
    {
	custId = aCustomerID;
    }

    public String getName()
    {
	return name;
    }

    public void setName(final String aName)
    {
	name = aName;
    }

    public int getAge()
    {
	return age;
    }

    public void setAge(int aAge)
    {
	age = aAge;
    }

    @Override
    public String toString()
    {
	return "Customer [age=" + age + ", custId=" + custId + ", name=" + name + "]";
    }
}
