
package batchupdates;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class BatchUpdates {

    
    public static void main(String[] args) {
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/banking","root","");
            Statement stt = con.createStatement();
            
            //create an array of string to store all queries
            String[] queries = new String[3];
            queries[0] = "insert into bank values ('5','cheat','10000') ";
            queries[1] = "insert into bank values ('6','phaneth','1000') ";
            queries[2] = "update bank set balance = '10000' where acno = 6";
            
            //add all queries into the batch
            for(String query:queries)
            stt.addBatch(query);
            
            //execute all the queries in the batch one for all 
            stt.executeBatch();
            //batch is used to execute all the queries one for all instead of execute each queries one by one
            //we can also create a list of all the queries then add it into the batch then execute it!!!
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BatchUpdates.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BatchUpdates.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
