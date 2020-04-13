import java.sql.*;

public class UserDAO {
    private static final String INSERT_USERS_SQL = "insert into user(name,email,country) values (?,?,?)";

    public void addUserTransaction(User user, int[] permissions) {

        Connection conn = null;

        // for insert a new user

        PreparedStatement pstmt = null;

        // for assign permission to user

        PreparedStatement pstmtAssignment = null;

        // for getting user id

        ResultSet rs = null;

        try {

            conn = getConnection();

            // set auto commit to false

            conn.setAutoCommit(false);

            //

            // Insert user

            //

            pstmt = conn.prepareStatement(INSERT_USERS_SQL, Statement.RETURN_GENERATED_KEYS);

            pstmt.setString(1, user.getName());

            pstmt.setString(2, user.getEmail());

            pstmt.setString(3, user.getCountry());

            int rowAffected = pstmt.executeUpdate();

            // get user id

            rs = pstmt.getGeneratedKeys();

            int userId = 0;

            if (rs.next())

                userId = rs.getInt(1);

            //

            // in case the insert operation successes, assign permission to user

            //

            if (rowAffected == 1) {

                // assign permission to user

                String sqlPivot = "INSERT INTO user_permission(user_id,permission_id) "

                        + "VALUES(?,?)";

                pstmtAssignment = conn.prepareStatement(sqlPivot);

                for (int permissionId : permissions) {

                    pstmtAssignment.setInt(1, userId);

                    pstmtAssignment.setInt(2, permissionId);

                    pstmtAssignment.executeUpdate();

                }

                conn.commit();

            } else {

                conn.rollback();

            }

        } catch (SQLException ex) {

            // roll back the transaction

            try {

                if (conn != null)

                    conn.rollback();

            } catch (SQLException e) {

                System.out.println(e.getMessage());

            }

            System.out.println(ex.getMessage());

        } finally {

            try {

                if (rs != null) rs.close();

                if (pstmt != null) pstmt.close();

                if (pstmtAssignment != null) pstmtAssignment.close();

                if (conn != null) conn.close();

            } catch (SQLException e) {

                System.out.println(e.getMessage());

            }

        }

    }

    public void addAndUpdateTransaction() throws SQLException {
        Connection connection = getConnection();
        try (
                PreparedStatement statement1 = connection.prepareStatement("insert into  user (name,email,country) value (?,?,?)");
                PreparedStatement statement2 = connection.prepareStatement("insert into  user (name,email,country) value (?,?,?)");
                PreparedStatement statement3 = connection.prepareStatement("update user set name = ?, email=?, country=? where id =?");
        ) {
            connection.setAutoCommit(false);
            statement1.setString(1,"Hien");
            statement1.setString(2,"hien@gmail.com");
            statement1.setString(3,"Viet Nam");
            statement1.executeUpdate();
            statement2.setString(1,"Loi");
            statement2.setString(2,"mail.com");
            statement2.setString(3,"Viet Nam");
            statement2.executeUpdate();
            statement3.setInt(1,2);
            statement3.setString(2,"asdsad");
            statement3.setInt(3,9);
            statement3.executeUpdate();

        } catch (SQLException e) {
            System.out.println("day la rollback");
            try {
                connection.rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } finally {
            connection.commit();
            connection.setAutoCommit(true);

        }

    }

    private Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_demo","root","password");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
