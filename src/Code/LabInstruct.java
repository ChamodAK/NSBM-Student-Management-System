package Code;

import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class LabInstruct {
    
    private String labId;
    private String instructId;

    public LabInstruct(String labId, String instructId) {
        
        this.labId = labId;
        this.instructId = instructId;
        
    }

    public String getLabId() {
        return labId;
    }

    public void setLabId(String labId) {
        this.labId = labId;
    }

    public String getInstructId() {
        return instructId;
    }

    public void setInstructId(String instructId) {
        this.instructId = instructId;
    }
    
    public void addAssign() {
    
        Connection con = null;
        PreparedStatement pst = null;
        con = ConnectDB.connect();
        
        try{
                
            String sql = "INSERT INTO lab_instruct VALUES ('"+ this.labId +"', '"+ this.instructId +"')";
            pst = con.prepareStatement(sql);
            pst.execute();

            JOptionPane.showConfirmDialog(null, "Lab Assigning Details Added Successfully", "Succesfull", JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE);
                
                
        }
        catch (Exception e) {
            
            JOptionPane.showConfirmDialog(null,e);
            
        }
    
    }
    
    public void updateAssign() {
    
        Connection con = null;
        PreparedStatement pst = null;
        con = ConnectDB.connect();
        
        String sql = "UPDATE lab_instruct SET instructId = '"+ this.instructId +"' WHERE labId = '"+ this.labId +"'";
        
        try {

            pst = con.prepareStatement(sql);
            pst.execute();

        } 
        catch (Exception ex) {

            JOptionPane.showConfirmDialog(null, ex);

        }
    
    }
    
    public void deleteAssign() {
    
        Connection con = null;
        PreparedStatement pst = null;
        con = ConnectDB.connect();
        
        String sql = "DELETE FROM lab_instruct WHERE labId = '"+ this.labId +"' AND instructId = '"+ this.instructId +"'";
            
        try {
            
            pst = con.prepareStatement(sql);
            pst.execute();

        }
        catch (Exception e) {
            
            JOptionPane.showConfirmDialog(null, e);
            
        }
    
    }

}
