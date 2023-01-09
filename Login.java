package Main;

import Impl.Dbconnection;
import Impl.UserOperation;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Login {




    private Connection connection;

    public Login() throws SQLException {
        connection = Dbconnection.getConnection();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserOperation userDao = new UserOperation();
        for (; ; ) {
            System.out.println("*****JukeBox********");
            System.out.println("1.Sign Up\n2.Login \n3.Exit");
            int response = scanner.nextInt();
            switch (response) {
                case 1:
                    userDao.NewUserRegistration();
                    break;
                case 2:
                    userDao.ExistingUser();
                    break;
                case 3:
                    System.out.println("Exiting from menu.....");
                    break;
                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}
