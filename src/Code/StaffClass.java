package Code;

import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class StaffClass {
    
    private String subId;
    private int insId;
    private String room;

    public StaffClass(String subId, int insId, String room) {
        this.subId = subId;
        this.insId = insId;
        this.room = room;
    }

    public String getSubId() {
        return subId;
    }

    public void setSubId(String subId) {
        this.subId = subId;
    }

    public int getInsId() {
        return insId;
    }

    public void setInsId(int insId) {
        this.insId = insId;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }
    
    public void add() {
    
        Connection con = null;
        PreparedStatement pst = null;
        con = ConnectDB.connect();
    
        try{
                
            String sql = "INSERT INTO sub_instruct VALUES ('"+ this.subId +"', '"+ this.insId +"', '"+ this.room+"')";
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
        
        String sql = "UPDATE sub_instruct SET room = '"+ this.room +"' WHERE subjectId = '"+ this.subId +"' AND instructId = '"+ this.insId +"'";
        
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
        
        String sql = "DELETE FROM sub_instruct WHERE subjectId = '"+ this.subId +"' AND instructId = '"+ this.insId +"'";
            
        try {
            
            pst = con.prepareStatement(sql);
            pst.execute();

        }
        
        catch (Exception e) {
            
            JOptionPane.showConfirmDialog(null, e);
            
        }
    
    }

}
