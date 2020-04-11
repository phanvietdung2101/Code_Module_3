package service;

import model.Customer;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface ICustomerDAO {
    public Connection getConnection ();
    public Customer findById(int id);
    public void save(Customer customer) throws SQLException;
    public List<Customer> findAll();
    public boolean update(int id, Customer customer);
    public boolean remove(int id);
}
