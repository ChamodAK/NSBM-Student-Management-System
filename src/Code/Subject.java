package Code;

import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class Subject {
    
    private String subId;
    private String subName;
    private String category;
    private int noOfCredits;
    private double price;
    private String semId;
    private String courseId;

    public Subject(String subId, String subName, String category, int noOfCredits, double price, String semId, String courseId) {
        this.subId = subId;
        this.subName = subName;
        this.category = category;
        this.noOfCredits = noOfCredits;
        this.price = price;
        this.semId = semId;
        this.courseId = courseId;
    }
    
    public Subject(String subId) {
        this.subId = subId;
    }

    public String getSubId() {
        return subId;
    }

    public void setSubId(String subId) {
        this.subId = subId;
    }

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getNoOfCredits() {
        return noOfCredits;
    }

    public void setNoOfCredits(int noOfCredits) {
        this.noOfCredits = noOfCredits;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getSemId() {
        return semId;
    }

    public void setSemId(String semId) {
        this.semId = semId;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }
    
    public void add() {
    
        Connection con = null;
        PreparedStatement pst = null;
        con = ConnectDB.connect();
    
        try{
                
            String sql = "INSERT INTO subject VALUES ('"+ this.subId +"', '"+ this.subName +"', '"+ this.category +"', '"+ this.noOfCredits +"', '"+ this.price +"', '"+ this.semId +"', '"+ this.courseId +"')";
            pst = con.prepareStatement(sql);
            pst.execute();

            JOptionPane.showConfirmDialog(null, "New Subject Added Successfully", "Succesfull", JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE);


        }
        catch (Exception e) {

            JOptionPane.showConfirmDialog(null,e);

        }
    
    }
    
    public void update() {
    
        Connection con = null;
        PreparedStatement pst = null;
        con = ConnectDB.connect();
        
        String sql = "UPDATE subject SET name = '"+ this.subName +"', category = '"+ this.category +"', noOfCredits = '"+ this.noOfCredits +"', price = '"+ this.price +"', semId = '"+ this.semId +"', courseId = '"+ this.courseId +"' WHERE subjectId = '"+ this.subId +"'";
        
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
        
        String sql = "DELETE FROM subject WHERE subjectId = '"+ this.subId +"'";
            
        try {
            
            pst = con.prepareStatement(sql);
            pst.execute();

        }
        
        catch (Exception e) {
            
            JOptionPane.showConfirmDialog(null, e);
            
        }
    
    }

}
