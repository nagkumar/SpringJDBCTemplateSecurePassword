package com.teja.customer.model;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerRowMapper implements RowMapper
{
    public Object mapRow(final ResultSet aRowSet, final int aRowNumber) throws SQLException
    {
	Customer customer = new Customer();
	customer.setCustId(aRowSet.getInt("CUST_ID"));
	customer.setName(aRowSet.getString("NAME"));
	customer.setAge(aRowSet.getInt("AGE"));
	return customer;
    }
}
