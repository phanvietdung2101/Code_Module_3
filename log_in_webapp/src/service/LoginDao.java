package service;


import java.sql.*;

public class LoginDao {
    public static boolean validate(String name,String pass){
        boolean status=false;
        String query = "select * from user where name = ? and password = ?";
        try(Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1,name);
            statement.setString(2,pass);

            ResultSet rs = statement.executeQuery();
            status = rs.next();

        } catch(Exception e){
            e.printStackTrace();
        }
        return status;
    }

    public static Connection getConnection(){
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/product_management","root","password");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

//    public static void main(String[] args) {
//        String query = "select * from user where name = ? and pass = ?";
//        try (Connection connection = getConnection();
//             PreparedStatement statement = connection.prepareStatement(query)) {
//                statement.setString(1,"admin");
//                statement.setString(2,"admin");
//
//                ResultSet rs = statement.executeQuery();
//            System.out.println(rs.next());
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
}  