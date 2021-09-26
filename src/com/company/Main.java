package com.company;

import java.sql.*;

public class Main {

    public static void main(String[] args) {

        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Alekos Dazer\\databases\\testjava.db");
            Statement statement = conn.createStatement();
            statement.execute ("CREATE TABLE IF NOT EXISTS contacts (name TEXT, phone INTEGER, email TEXT)");
//            statement.execute("INSERT INTO contacts (name, phone, email) "+
//                                  "VALUES ('Ron', 543213,'ron@mail.com')");
//            statement.execute("INSERT INTO contacts (name, phone, email) "+
//                                  "VALUES ('Fred', 34598893,'fred@mail.com')");
//              statement.execute("UPDATE contacts SET phone = 56781234 WHERE name = 'Pit'");
//              statement.execute("DELETE FROM contacts WHERE name = 'Ron'");
                statement.execute("SELECT * FROM contacts");
            ResultSet results = statement.getResultSet();
            while (results.next()){
                System.out.println(results.getString("name") +" "+
                                   results.getInt("phone")+ " "+
                                   results.getString("email"));
            }
            results.close();

            System.out.println("test");

            statement.close();
            conn.close();
        } catch (SQLException e){
            System.out.println("Something went wrong: "+ e.getMessage());
        }
    }
}
