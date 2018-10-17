package Code;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import javax.swing.JOptionPane;

public class PostgradStu extends Student {
    
    private String qualification;
    private int yearComplete;
    private String institute;

    public PostgradStu(String name, String dob, char gender, String nic, String civilStatus, String phoneNO, String email, String address, String qualification, int yearComplete, String institute) {
        super(name, dob, gender, nic, civilStatus, phoneNO, email, address);
        this.qualification = qualification;
        this.yearComplete = yearComplete;
        this.institute = institute;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public int getYearComplete() {
        return yearComplete;
    }

    public void setYearComplete(int yearComplete) {
        this.yearComplete = yearComplete;
    }

    public String getInstitute() {
        return institute;
    }

    public void setInstitute(String institute) {
        this.institute = institute;
    }
    
    public void enroll(String course, String intake) {
    
        int id = this.studentID;
        String name = this.name;
        String dob = this.dob;
        char gender = this.gender;
        String nic = this.nic;
        String civilStatus = this.civilStatus;
        String address = this.address;
        String phone = this.phoneNO;
        String email = this.email;
        String qualification = this.qualification;
        int yearCompleted = this.yearComplete;
        String institute = this.institute;
        
        String semId = "S11";
        String courseId = "";
        String courseEnroll = java.time.LocalDate.now().toString();
        
        //setting Course id
        if(course=="Master of Business Management") {
            courseId = "BM01";
        }
        else if(course=="MSc in Computer Science"){
            courseId = "CM01";
        }
        else if(course=="MSc in Construction Project Management") {
            courseId = "EM01";
        }
        
        //setting Subjects
        String subjects[] = new String[14];
        String realSubjects[];
        int num = 0;
        if(courseId=="BM01") {
            String subs[] = {"MBA1101", "MBA1102", "MBA1103", "MBA1104", "MBA1105", "MBA1106", "MBA1201", "MBA1202", "MBA1203", "MBA1204", "MBA1205", "MBA1206"};
            for(String s:subs) {
                subjects[num] = s;
                num += 1;
            }
        }
        else if(courseId=="CM01") {
            String subs[] = {"MCS1101", "MCS1102", "MCS1103", "MCS1104", "MCS1201", "MCS1202", "MCS1203", "MCS1204"};
            for(String s:subs) {
                subjects[num] = s;
                num += 1;
            }
        }
        else if(courseId=="EM01") {
            String subs[] = {"MCP1101", "MCP1102", "MCP1103", "MCP1104", "MCP1201", "MCP1202", "MCP1203", "MCP1204"};
            for(String s:subs) {
                subjects[num] = s;
                num += 1;
            }
        }
        
        int nullIndex = Arrays.asList(subjects).indexOf(null);
        
        if(nullIndex!=-1) {
            realSubjects = Arrays.copyOfRange(subjects,0,nullIndex);
        }
        else {
            realSubjects = subjects.clone();
        }
        
        //Connecting and work with Database
        Connection con = null;
        PreparedStatement pst = null;
        
        con = ConnectDB.connect();
        
        String sql1 = "INSERT INTO postgradStu VALUES ('"+ id +"', '"+ name +"', '"+ dob +"', '"+ gender +"', '"+ nic +"', '"+ civilStatus +"', '"+ address +"', '"+ phone +"', '"+ email +"', '"+ qualification +"', '"+ yearCompleted +"', '"+ institute +"', '"+ semId +"', '"+ courseId +"', '"+ courseEnroll +"', '"+ intake +"')";
        
        try {
            
            pst = con.prepareStatement(sql1);
            pst.execute();
            //JOptionPane.showConfirmDialog(null, "Sql1 successfully executed", "Succesfull", JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE);
            
        } catch (SQLException ex) {
            
            JOptionPane.showConfirmDialog(null,ex);
            
        }
        
        try {
            for(String s : realSubjects) {
                String sql2 = "INSERT INTO pstu_subject VALUES ('"+ id +"', '"+ s +"')";
                pst = con.prepareStatement(sql2);
                pst.execute();
            }
            JOptionPane.showConfirmDialog(null, "Student Successfully Enrolled", "Succesfull", JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE);
        }
        catch (SQLException ex) {
            JOptionPane.showConfirmDialog(null,ex);
        }
         
        
    }
    

}
