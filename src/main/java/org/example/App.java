package org.example;

import java.sql.*;

/**
 * Hello !
 * I AM MAJED
 * THIS IS CPIT 252 PROJECT
 */
public class App 
{
    public static void main( String[] args ) throws SQLException {

       DBConnection conn = DBConnection.getInstance();
       Statement statement = conn.getConnection().createStatement();


       Register register =new Register();
       register.signIn();

    }
}
