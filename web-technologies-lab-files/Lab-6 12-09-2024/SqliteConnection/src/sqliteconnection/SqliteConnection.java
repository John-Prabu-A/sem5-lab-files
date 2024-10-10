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
    String query = "select * from Employee"; // INSERT INTO Employee values (4, 'Sandhip', 100000)
    public void disp() throws SQLException, ClassNotFoundException {
        // connect the driver
        Class.forName(driver);
        // connect and open db
        Connection ct = DriverManager.getConnection(DB_URL);
        // create stmt object
        Statement st = ct.createStatement();
        // exec query & store the results
        ResultSet rs = st.executeQuery(query);
        // iteratively print the result
        System.out.println("ID\tNAME\tSALARY");
        while(rs.next()) {
            System.out.println(rs.getString(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3));
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        new SqliteConnection().disp();
    }
    
}
