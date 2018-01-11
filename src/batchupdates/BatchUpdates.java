
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
            //add all queries into the batch
            stt.addBatch("insert into bank values ('3','chhun','10000') ");
            stt.addBatch("insert into bank values ('4','vad','1000') ");
            stt.addBatch("update bank set balance = '10000' where acno = 4");
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
