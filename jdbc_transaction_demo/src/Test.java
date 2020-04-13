import java.sql.SQLException;

public class Test {
    public static void main(String[] args) throws SQLException {
        UserDAO userDAO = new UserDAO();
//        User user1 = new User("t","dd@com","NA");
//        int[] permissions = {1,2,5};
//        userDAO.addUserTransaction(user1,permissions);
        userDAO.addAndUpdateTransaction();
    }
}
