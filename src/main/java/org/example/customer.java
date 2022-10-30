package org.example;

import java.sql.SQLException;
import java.sql.Statement;

public class customer {
    String name;
    String phone;
    String ID;
    String password;
    DBConnection connection = DBConnection.getInstance();
    Statement statement = connection.getConnection().createStatement();

    public customer(String name, String phone, String password) throws SQLException {
        this.name = name;
        this.phone = phone;
        this.password = password;
        statement.executeUpdate("INSERT INTO `cpit252project_db`.`customer` (`customerPhone`, `customerName`, `customerPass`) VALUES ("+phone+", "+name+", "+password+")");
    }
    public customer() throws SQLException {
    }

    public String getName() {
        return name;
        //RETURN FROM db
    }

    public void setName(String name) {
        this.name = name;
        //DB FOR EDIT NAME
    }

    public String getPhone() {
        return phone;
        //RETURN FROM db
    }

    public void setPhone(String phone) {
        this.phone = phone;
        //DB FOR EDIT PHONE
    }

    public String getID() {
        return ID;
        //RETURN FROM db
    }

    public void setID(String ID) {
        this.ID = ID;
        //DB FOR EDIT ID
    }

    public String getPassword() {
        return password;
        //RETURN FROM db
    }

    public void setPassword(String password) {
        this.password = password;
        //DB FOR EDIT PASS
    }
}

