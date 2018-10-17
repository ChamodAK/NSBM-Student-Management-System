package Code;

import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class SubjectsLabs {
    
    private String subId;
    private String labId;
    private int duration;

    public SubjectsLabs(String subId, String labId, int duration) {
        this.subId = subId;
        this.labId = labId;
        this.duration = duration;
    }

    public String getSubId() {
        return subId;
    }

    public void setSubId(String subId) {
        this.subId = subId;
    }

    public String getLabId() {
        return labId;
    }

    public void setLabId(String labId) {
        this.labId = labId;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
    
    public void add() {
    
        Connection con = null;
        PreparedStatement pst = null;
        con = ConnectDB.connect();
    
        try{
                
            String sql = "INSERT INTO sub_lab VALUES ('"+ this.subId +"', '"+ this.labId +"', '"+ this.duration +"')";
            pst = con.prepareStatement(sql);
            pst.execute();

            JOptionPane.showConfirmDialog(null, "New Record Successfully Added", "Succesfull", JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE);


        }
        catch (Exception e) {

            JOptionPane.showConfirmDialog(null,e);

        }
    
    }
    
    public void update() {
    
        Connection con = null;
        PreparedStatement pst = null;
        con = ConnectDB.connect();
        
        String sql = "UPDATE sub_lab SET labDuration = '"+ this.duration +"' WHERE subjectId = '"+ this.subId +"' AND labId = '"+ this.labId +"'";
        
        try {
            
            pst = con.prepareStatement(sql);
            pst.execute();

        } 
        catch (Exception ex) {
            
            JOptionPane.showConfirmDialog(null, ex);
            
        }
    
    }
    
    public void delete() {
    
        Connection con = null;
        PreparedStatement pst = null;
        con = ConnectDB.connect();
        
        String sql = "DELETE FROM sub_lab WHERE subjectId = '"+ this.subId +"' AND labId = '"+ this.labId +"'";
            
        try {
            
            pst = con.prepareStatement(sql);
            pst.execute();

        }
        
        catch (Exception e) {
            
            JOptionPane.showConfirmDialog(null, e);
            
        }
    
    }

}
