package service;

import model.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO implements ICustomerDAO {

    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo_jdbc","root","password");
        } catch (SQLException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }


    @Override
    public Customer findById(int id) {
        Customer customer = null;
        String query = "call get_customer_by_id(?)";
        try(Connection connection = getConnection();
            CallableStatement callableStatement = connection.prepareCall(query);) {
            callableStatement.setInt(1,id);
            ResultSet rs = callableStatement.executeQuery();
            while (rs.next()){
                String name = rs.getString("name");
                String email = rs.getString("email");
                String address = rs.getString("address");
                customer = new Customer(id,name,email,address);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }

    @Override
    public void save(Customer customer) {
        String query = "{call insert_customer(?,?,?)}";
        try(Connection connection = getConnection();
        CallableStatement statement = connection.prepareCall(query)){
            statement.setString(1,customer.getName());
            statement.setString(2,customer.getEmail());
            statement.setString(3,customer.getAddress());
            statement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Customer> findAll() {
        List<Customer> customerList = new ArrayList<>();
        String query = "Select * from customers;";
        try(Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement(query)){
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String address = rs.getString("address");
                customerList.add(new Customer(id,name,email,address));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerList;
    }

    @Override
    public boolean update(int id, Customer customer) {
        boolean rowUpdated = false;
        String query = "update customer set name = ?, email = ?, country = ? where id = ?;";
        try(Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement(query)){
            statement.setString(1, customer.getName());
            statement.setString(2, customer.getEmail());
            statement.setString(3, customer.getAddress());
            statement.setInt(4,customer.getId());

            rowUpdated = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  rowUpdated;
    }

    @Override
    public boolean remove(int id) {
        boolean rowRemoved = false;
        String query = "delete from customers where id = ?;";
        try (Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement(query)){
            statement.setInt(1,id);
            rowRemoved = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowRemoved;
    }

    public static void main(String[] args) {
        CustomerDAO service = new CustomerDAO();
        List<Customer> list = null;
        list = service.findAll();
        for(Customer customer : list){
            System.out.println(customer.getName());
        }
    }

}
