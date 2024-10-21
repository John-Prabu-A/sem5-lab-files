/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sqliteconnection;

/**
 *
 * @author student
 */

import java.sql.*;

public class SqliteConnection {
    String driver = "org.sqlite.JDBC";
    String DB_URL = "jdbc:sqlite:C:\\Users\\student\\Documents\\2022506113\\sem5-lab-files\\web-technologies-lab-files\\sqlite-db\\emp-mgmt.db";
    public SqliteConnection view(String tableName) throws SQLException, ClassNotFoundException {
        // connect the driver
        Class.forName(driver);
        // connect and open db
        Connection ct = DriverManager.getConnection(DB_URL);
        // create stmt object
        Statement st = ct.createStatement();
        // exec query & store the results
        ResultSet rs = st.executeQuery("SELECT * FROM " + tableName);
        // get metadata for columns
        ResultSetMetaData metadata = rs.getMetaData();
        // get column count
        int columnCount = metadata.getColumnCount();
        // print column names
        for(int i = 1; i <= columnCount; i++) {
            System.out.print(metadata.getColumnName(i) + "\t");
        }
        System.out.println(""); // move cursor to next line
        // iteratively print the result
        while(rs.next()) {
            for(int i = 1; i <= columnCount; i++) {
                System.out.print(rs.getString(i) + "\t");
            }
            System.out.println(""); // move cursor to next line
        }
        System.out.println("");
        return this;
    }
    
    public SqliteConnection modify(String query) throws SQLException, ClassNotFoundException {
        // connect the driver
        Class.forName(driver);
        // connect and open db
        Connection ct = DriverManager.getConnection(DB_URL);
        // create stmt object
        Statement st = ct.createStatement();
        // exec query & for inserting data and store affected rows in count
        int count = st.executeUpdate(query);
        // print affected rows count to ensure successful insertion
        System.out.println(count + " row affected");
        System.out.println("");
        return this;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        new SqliteConnection()
                .view("Employee")
                .modify("DELETE FROM Employee WHERE id = 6")
                .view("Employee")
                .modify("INSERT INTO Employee values (6, 'Reddy', 200000)")
                .view("Employee")
                .modify("UPDATE Employee SET name='Hareesh' WHERE id=6")
                .view("Employee");
    }
    
}
