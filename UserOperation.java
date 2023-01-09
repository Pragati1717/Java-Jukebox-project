package Impl;


import Dao.UserDao;
import Main.App;

import java.sql.*;
import java.util.Scanner;



public class UserOperation implements UserDao {
    App app =new App();

    public UserOperation() {

    }
    @Override
    public void NewUserRegistration(){

        Scanner scanner=new Scanner(System.in);
        System.out.println("Create your own userID (only Numbers)");
        int userID=scanner.nextInt();
        System.out.println("Create your own Password");
        String password=scanner.next();
        System.out.println("Enter your Name");
        String name=scanner.next();
        System.out.println("Enter your phone number");
        long phoneNo=scanner.nextLong();
        System.out.println("Enter your Email Id");
        String emailId=scanner.next();

        try ( Connection connection1 =Dbconnection.getConnection()){
            String query="insert into userDetails values(?,?,?,?,?)";
            PreparedStatement preparedStatement=connection1.prepareStatement(query);
            Scanner scanner1=new Scanner(System.in);
            preparedStatement.setInt(1,userID);
            preparedStatement.setString(2,password);
            preparedStatement.setString(3,name);
            preparedStatement.setLong(4,phoneNo);
            preparedStatement.setString(5,emailId);
            int res=preparedStatement.executeUpdate();
            if (res==0){
                System.out.println("userID creation failed");
            }
            else {
                System.out.println("userID successfully created");
            }
        }catch (SQLException se){
            se.getMessage();
        }
    }
    @Override
    public void ExistingUser(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter your userID");
        int userID=scanner.nextInt();
        System.out.println("Enter your Password");
        String password=scanner.next();
        try (Connection connection1 = Dbconnection.getConnection()){
            boolean flag=false;
            int checkUserID=0;
            String checkPassword="";
            String query="select userID, password from userDetails";
            Statement statement=connection1.createStatement();
            ResultSet resultSet=statement.executeQuery(query);
            while (resultSet.next()){
                checkUserID=resultSet.getInt("userID");
                checkPassword=resultSet.getString("password");
                if (checkUserID==userID && checkPassword.equalsIgnoreCase(password)){
                    flag=true;
                    break;
                }
            }
            if (flag){
                System.out.println("Logged in succesfully");
                app.app(connection1);
            }
            else {
                System.out.println("give valid details");
            }
        }catch (SQLException se){
            se.getMessage();
        }
    }

}


