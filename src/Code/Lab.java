package Code;

import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class Lab {
    
    private String labId;
    private String labName;
    private int capacity;

    public Lab(String labId, String labName, int capacity) {
        
        this.labId = labId;
        this.labName = labName;
        this.capacity = capacity;
        
    }
    
    public Lab(String labId) {
    
        this.labId = labId;
    
    }

    public String getLabId() {
        return labId;
    }

    public void setLabId(String labId) {
        this.labId = labId;
    }

    public String getLabName() {
        return labName;
    }

    public void setLabName(String labName) {
        this.labName = labName;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    
    public void addLab() {
        
        //Connect and work with database
        
        Connection con = null;
        PreparedStatement pst = null;
        
        con = ConnectDB.connect();
            
        try {
                
            String sql = "INSERT INTO lab VALUES ('"+ this.labId +"', '"+ this.labName +"', '"+ this.capacity +"')";
            pst = con.prepareStatement(sql);
            pst.execute();
                
            JOptionPane.showConfirmDialog(null, "Lab Details Successfully Added", "Succesfull", JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE);
                
                
        }
        catch (Exception e) {
            
            JOptionPane.showConfirmDialog(null,e);
            
        }
    
    }
    
    public void updateLab() {
    
        //Connecting database
        
        Connection con = null;
        PreparedStatement pst = null;
        
        con = ConnectDB.connect();
        
        String sql = "UPDATE lab SET name = '"+ this.labName +"', capacity = '"+ this.capacity +"' WHERE labId = '"+ this.labId +"'";
        
            try {
                pst = con.prepareStatement(sql);
                pst.execute();
                
            } 
            catch (Exception ex) {
                JOptionPane.showConfirmDialog(null, ex);
            }
    
    }
    
    public void deleteLab() {
    
        Connection con = null;
        PreparedStatement pst = null;
        con = ConnectDB.connect();
        
        String sql = "DELETE FROM lab WHERE labId = '"+ this.labId +"'";
            
            try {
                
                pst = con.prepareStatement(sql);
                pst.execute();
                
            }
            catch (Exception e) {
                
                JOptionPane.showConfirmDialog(null, e);
                
            }
    
    }

}
