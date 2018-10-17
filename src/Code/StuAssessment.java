package Code;

import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class StuAssessment {
    
    private String studentId;
    private String assessmentId;
    private int marks;

    public StuAssessment(String studentId, String assessmentId, int marks) {
        this.studentId = studentId;
        this.assessmentId = assessmentId;
        this.marks = marks;
    }
    
    public StuAssessment(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getAssessmentId() {
        return assessmentId;
    }

    public void setAssessmentId(String assessmentId) {
        this.assessmentId = assessmentId;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }
    
    public void addStuAssess() {
    
        Connection con = null;
        PreparedStatement pst = null;
        con = ConnectDB.connect();
        
        try{
                
            String sql = "INSERT INTO stu_assess VALUES ('"+ this.studentId +"', '"+ this.assessmentId +"', '"+ this.marks +"')";
            pst = con.prepareStatement(sql);
            pst.execute();

            JOptionPane.showConfirmDialog(null, "Assessment Marks Successfully Added", "Succesfull", JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE);


        }
        catch (Exception e) {

            JOptionPane.showConfirmDialog(null,e);

        }
    
    }
    
    public void deleteStuAssess() {
    
        Connection con = null;
        PreparedStatement pst = null;
        con = ConnectDB.connect();
        
        String sql = "DELETE FROM stu_assess WHERE studentId = '"+ this.studentId +"'";
            
        try {
            
            pst = con.prepareStatement(sql);
            pst.execute();

        }
        catch (Exception e) {
            
            JOptionPane.showConfirmDialog(null, e);
            
        }
    
    }
    
    public void updateStuAssess() {
    
        Connection con = null;
        PreparedStatement pst = null;
        con = ConnectDB.connect();
        
        String sql = "UPDATE stu_assess SET assessmentId = '"+ this.assessmentId +"', marks = '"+ this.marks +"' WHERE studentId = '"+ this.studentId +"'";
        
        try {
            
            pst = con.prepareStatement(sql);
            pst.execute();

        } 
        catch (Exception ex) {
            
            JOptionPane.showConfirmDialog(null, ex);
            
        }
    
    }

}
