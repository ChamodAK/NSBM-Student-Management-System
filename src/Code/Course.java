package Code;

import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class Course {
    
    private String courseId;
    private String courseName;
    private String faculty;
    private String category;
    private int duration;

    public Course(String courseId, String courseName, String faculty, String category, int duration) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.faculty = faculty;
        this.category = category;
        this.duration = duration;
    }
    
    public Course(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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
                
            String sql = "INSERT INTO course VALUES ('"+ this.courseId +"', '"+ this.courseName +"', '"+ this.faculty +"', '"+ this.category +"', '"+ this.duration +"')";
            pst = con.prepareStatement(sql);
            pst.execute();

            JOptionPane.showConfirmDialog(null, "New Course Successfully Added", "Succesfull", JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE);


        }
        catch (Exception e) {

            JOptionPane.showConfirmDialog(null,e);

        }
    
    }
    
    public void update() {
    
        Connection con = null;
        PreparedStatement pst = null;
        con = ConnectDB.connect();
        
        String sql = "UPDATE course SET courseName = '"+ this.courseName +"', faculty = '"+ this.faculty +"', category = '"+ this.category +"', duration = '"+ this.duration +"' WHERE courseId = '"+ this.courseId +"'";
        
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
        
        String sql = "DELETE FROM course WHERE courseId = '"+ this.courseId +"'";
            
        try {
            
            pst = con.prepareStatement(sql);
            pst.execute();

        }
        
        catch (Exception e) {
            
            JOptionPane.showConfirmDialog(null, e);
            
        }
        
    }

}
