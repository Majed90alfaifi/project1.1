package org.example;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Register {
    String name;
    String phone;
    String pass;
    String ID;
    DBConnection connection = DBConnection.getInstance();
    Statement statement = connection.getConnection().createStatement();
    ResultSet resultSet ;

    Scanner scan = new Scanner(System.in);

    private Register register;

    public Register() throws SQLException {
    }


    void signIn() throws SQLException {
        //-------------------------Phone section---------------------------
        while (true) {
            System.out.println("Enter Your Phone: ");
            phone = scan.nextLine();
            resultSet = statement.executeQuery("SELECT * FROM customer where customerPhone =" + phone + ";");
            //if the phone dose`t exit in DB
            //display an error message
            //break
            if (resultSet.next()) {
                //x= resultSet.getString("customerPhone");
                System.out.println("Great !! Your phone found in Database ");
            } else {
                System.out.println("Sorry >_< *We Can`t find your phone in the Database.\nMaybe you should go to create new account ..");
                this.signUp();
                break;
            }
            //-------------------------Password section---------------------------
            while (true) {
                System.out.println("Enter your Password: ");
                pass = scan.nextLine();
                resultSet = statement.executeQuery("SELECT * FROM customer where customerPass =" + pass + "AND customerPhone =" + phone + ";");
                if (resultSet.next()) {
                    String x = resultSet.getString("customerPass");
                    System.out.println(x);
                    System.out.println("Great!! Your Password is correct");
                    break;
                }
                System.out.println("Try Again .........");
            }break;
        }

    }
    void signUp() throws SQLException {

        System.out.println("please enter your information :");
        System.out.println("Name: ");
        name = scan.nextLine();

        while (true){
            System.out.println("Phone: ");
        phone = scan.nextLine();
        resultSet = statement.executeQuery("SELECT * FROM customer where customerPhone =" + phone + ";");
        if (resultSet.next()) {
            System.out.println("YOU ALREADY HAVE AN ACCOUNT!!");
            this.signIn();
            break;
        }

        System.out.println("Password: ");
        pass=scan.nextLine();
        statement.executeUpdate("INSERT INTO customer ( `customerPhone`, `customerName`, `customerPass`) VALUES ("+phone+", "+name+", "+pass+")");
        break;
        }
    }
}
