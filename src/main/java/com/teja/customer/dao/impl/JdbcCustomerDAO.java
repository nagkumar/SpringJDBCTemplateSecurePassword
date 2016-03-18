package com.teja.customer.dao.impl;

import com.teja.customer.dao.CustomerDAO;
import com.teja.customer.model.Customer;
import com.teja.customer.model.CustomerRowMapper;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class JdbcCustomerDAO extends JdbcDaoSupport implements CustomerDAO
{
    public void insert(final Customer aCustomer)
    {
	String sql = "INSERT INTO CUSTOMER (CUST_ID, NAME, AGE) VALUES (?, ?, ?)";
	getJdbcTemplate().update(sql,
				 aCustomer.getCustId(),
				 aCustomer.getName(),
				 aCustomer.getAge());
    }

    public void insertNamedParameter(final Customer customer)
    {
	//not supported
    }

    //insert batch example
    public void insertBatch(final List<Customer> customers)
    {
	String sql = "INSERT INTO CUSTOMER (CUST_ID, NAME, AGE) VALUES (?, ?, ?)";
	getJdbcTemplate().batchUpdate(sql,
				      new BatchPreparedStatementSetter()
				      {
					  public void setValues(PreparedStatement ps, int i) throws SQLException
					  {
					      Customer customer = customers.get(i);
					      ps.setLong(1, customer.getCustId());
					      ps.setString(2, customer.getName());
					      ps.setInt(3, customer.getAge());
					  }

					  public int getBatchSize()
					  {
					      return customers.size();
					  }
				      });
    }

    public void insertBatchNamedParameter(final List<Customer> customers)
    {
	//not supported
    }

    //insert batch with named parameter
    public void insertBatchNamedParameter2(final List<Customer> customers)
    {
	//not supported
    }

    //insert batch example with SQL
    public void insertBatchSQL(final String sql)
    {
	getJdbcTemplate().batchUpdate(sql);
    }

    public Customer findByCustomerId(int custId)
    {
	String sql = "SELECT * FROM CUSTOMER WHERE CUST_ID = ?";
	return (Customer) getJdbcTemplate().queryForObject(sql,
							   new Object[]{custId},
							   new CustomerRowMapper());
    }

    public Customer findByCustomerId2(int custId)
    {
	String sql = "SELECT * FROM CUSTOMER WHERE CUST_ID = ?";
	return getJdbcTemplate().queryForObject(sql,
						new Object[]{custId},
						new BeanPropertyRowMapper<Customer>(Customer.class));
    }

    public List<Customer> findAll2(int custId)
    {
	String sql = "SELECT * FROM CUSTOMER WHERE CUST_ID = ?";
	return getJdbcTemplate().query(sql,
				       new Object[]{custId},
				       new BeanPropertyRowMapper<Customer>(Customer.class));
    }

    public List<Customer> findAll2()
    {
	String sql = "SELECT * FROM CUSTOMER";
	return getJdbcTemplate().query(sql,
				       new BeanPropertyRowMapper<Customer>(Customer.class));
    }

    public List<Customer> findAll()
    {
	String sql = "SELECT * FROM CUSTOMER";
	List<Customer> customers = new ArrayList<Customer>();
	List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
	for (Map row : rows)
	{
	    Customer customer = new Customer();
	    customer.setCustId((Long) (row.get("CUST_ID")));
	    customer.setName((String) row.get("NAME"));
	    customer.setAge((Integer) row.get("AGE"));
	    customers.add(customer);
	}
	return customers;
    }

    public String findCustomerNameById(int custId)
    {
	String sql = "SELECT NAME FROM CUSTOMER WHERE CUST_ID = ?";
	return getJdbcTemplate().queryForObject(sql, new Object[]{custId}, String.class);
    }

    public int findTotalCustomer()
    {
	String sql = "SELECT COUNT(*) FROM CUSTOMER";
	return getJdbcTemplate().queryForObject(sql, Integer.class);
    }
}
