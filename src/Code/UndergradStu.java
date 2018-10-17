package Code;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import javax.swing.JOptionPane;

public class UndergradStu extends Student {

    private String alResult;
    private int alRank;

    public UndergradStu (String name, String dob, char gender, String nic, String civilStatus, String phoneNO, String email, String address, String alResult, int alRank) {
        super(name, dob, gender, nic, civilStatus, phoneNO, email, address);
        this.alResult = alResult;
        this.alRank = alRank;
    }

    public String getAlResult() {
        return alResult;
    }

    public void setAlResult(String alResult) {
        this.alResult = alResult;
    }

    public int getAlRank() {
        return alRank;
    }

    public void setAlRank(int alRank) {
        this.alRank = alRank;
    }

    public void enroll(String course, String[] sem1, String[] sem2, String intake) {
   
        int id = this.studentID;
        String name = this.name;
        String dob = this.dob;
        char gender = this.gender;
        String nic = this.nic;
        String civilStatus = this.civilStatus;
        String address = this.address;
        String phone = this.phoneNO;
        String email = this.email;
        String alResult = this.alResult;
        int alRank = this.alRank;
        
        String semId = "";
        String courseId = "";
        String courseEnroll = java.time.LocalDate.now().toString();
        
        //setting Semester id
        if(intake=="February") {
            semId = "S11";
        }
        else if(intake=="July") {
            semId = "S12";
        }
        
        //setting Course id
        if(course=="BM in Accounting and Finance") {
            courseId = "BB01";
        }
        else if(course=="BSc in Business Management"){
            courseId = "BB03";
        }
        else if(course=="BSc in Software Engineering") {
            courseId = "CB01";
        }
        else if(course=="BSc in Information System") {
            courseId = "CB03";
        }
        else if(course=="BSc in Civil Engineering") {
            courseId = "EB01";
        }
        else if(course=="BSc in Computer Systems Engineering") {
            courseId = "EB02";
        }
        
        //setting Subjects
        String subjects[] = new String[14];
        String realSubjects[];
        int num = 0;
        if(courseId=="BB01") {
            String subs[] = {"BAF1101", "BAF1102", "BAF1103", sem1[0], sem1[1], sem1[2], sem1[3], "BAF1201", "BAF1202", "BAF1203", sem2[0], sem2[1], sem2[2], sem2[3]};
            for(String s:subs) {
                subjects[num] = s;
                num += 1;
            }
        }
        else if(courseId=="BB03") {
            String subs[] = {"BBM1101", "BBM1102", "BBM1103", sem1[0], sem1[1], sem1[2], sem1[3], "BBM1201", "BBM1202", "BBM1203", sem2[0], sem2[1], sem2[2], sem2[3]};
            for(String s:subs) {
                subjects[num] = s;
                num += 1;
            }
        }
        else if(courseId=="CB01") {
            String subs[] = {"BSW1101", "BSW1102", "BSW1103", sem1[0], sem1[1], sem1[2], sem1[3], "BSW1201", "BSW1202", "BSW1203", sem2[0], sem2[1], sem2[2], sem2[3]};
            for(String s:subs) {
                subjects[num] = s;
                num += 1;
            }
        }
        else if(courseId=="CB03") {
            String subs[] = {"BIS1101", "BIS1102", "BIS1103", sem1[0], sem1[1], sem1[2], sem1[3], "BIS1201", "BIS1202", "BIS1203", sem2[0], sem2[1], sem2[2], sem2[3]};
            for(String s:subs) {
                subjects[num] = s;
                num += 1;
            }
        }
        else if(courseId=="EB01") {
            String subs[] = {"BCE1101", "BCE1102", "BCE1103", sem1[0], sem1[1], sem1[2], sem1[3], "BCE1201", "BCE1202", "BCE1203", sem2[0], sem2[1], sem2[2], sem2[3]};
            for(String s:subs) {
                subjects[num] = s;
                num += 1;
            }
        }
        else if(courseId=="EB02") {
            String subs[] = {"BSE1101", "BSE1102", sem1[0], sem1[1], sem1[2], sem1[3], "BSE1201", "BSE1202", sem2[0], sem2[1], sem2[2], sem2[3]};
            for(String s:subs) {
                subjects[num] = s;
                num += 1;
            }
        }
        
        //triming subjects array (removing null values)
        if (courseId=="EB02") {
            int someIndex = Arrays.asList(subjects).indexOf(null);
            realSubjects = Arrays.copyOfRange(subjects,0,someIndex);
        }
        else {
            realSubjects = subjects.clone();
        }
        
        //Connecting and work with Database
        Connection con = null;
        PreparedStatement pst = null;
        
        con = ConnectDB.connect();
        
        String sql1 = "INSERT INTO undergradStu VALUES ('"+ id +"', '"+ name +"', '"+ dob +"', '"+ gender +"', '"+ nic +"', '"+ civilStatus +"', '"+ address +"', '"+ phone +"', '"+ email +"', '"+ alResult +"', '"+ alRank +"', '"+ semId +"', '"+ courseId +"', '"+ courseEnroll +"', '"+ intake +"')";
        
        try {
            
            pst = con.prepareStatement(sql1);
            pst.execute();
            //JOptionPane.showConfirmDialog(null, "Sql1 successfully executed", "Succesfull", JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE);
            
        } catch (SQLException ex) {
            
            JOptionPane.showConfirmDialog(null,ex);
            
        }
        
        try {
            for(String s : realSubjects) {
                String sql2 = "INSERT INTO ustu_subject VALUES ('"+ id +"', '"+ s +"')";
                pst = con.prepareStatement(sql2);
                pst.execute();
            }
            JOptionPane.showConfirmDialog(null, "Student Successfully Enrolled", "Succesfull", JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE);
        }
        catch (SQLException ex) {
            JOptionPane.showConfirmDialog(null,ex);
        }
        
    }

    public void enroll(String course, String[] sem2, String intake) {
        
        int id = this.studentID;
        String name = this.name;
        String dob = this.dob;
        char gender = this.gender;
        String nic = this.nic;
        String civilStatus = this.civilStatus;
        String address = this.address;
        String phone = this.phoneNO;
        String email = this.email;
        String alResult = this.alResult;
        int alRank = this.alRank;
        
        String semId = "";
        String courseId = "";
        String courseEnroll = java.time.LocalDate.now().toString();
        
        //setting Semester id
        if(intake=="February") {
            semId = "S11";
        }
        else if(intake=="July") {
            semId = "S12";
        }
        
        //setting Course id
        if(course=="BM in Accounting and Finance") {
            courseId = "BB01";
        }
        else if(course=="BSc in Business Management"){
            courseId = "BB03";
        }
        else if(course=="BSc in Software Engineering") {
            courseId = "CB01";
        }
        else if(course=="BSc in Information System") {
            courseId = "CB03";
        }
        else if(course=="BSc in Civil Engineering") {
            courseId = "EB01";
        }
        else if(course=="BSc in Computer Systems Engineering") {
            courseId = "EB02";
        }
        
        //setting Subjects
        String subjects[] = new String[7];
        String realSubjects[];
        int num = 0;
        if(courseId=="BB01") {
            String subs[] = {"BAF1201", "BAF1203", "BAF1204", sem2[0], sem2[1], sem2[2], sem2[3]};
            for(String s:subs) {
                subjects[num] = s;
                num += 1;
            }
        }
        else if(courseId=="BB03") {
            String subs[] = {"BBM1201", "BBM1202", "BBM1203", sem2[0], sem2[1], sem2[2], sem2[3]};
            for(String s:subs) {
                subjects[num] = s;
                num += 1;
            }
        }
        else if(courseId=="CB01") {
            String subs[] = {"BSW1201", "BSW1202", "BSW1203", sem2[0], sem2[1], sem2[2], sem2[3]};
            for(String s:subs) {
                subjects[num] = s;
                num += 1;
            }
        }
        else if(courseId=="CB03") {
            String subs[] = {"BIS1201", "BIS1202", "BIS1203", sem2[0], sem2[1], sem2[2], sem2[3]};
            for(String s:subs) {
                subjects[num] = s;
                num += 1;
            }
        }
        else if(courseId=="EB01") {
            String subs[] = {"BCE1201", "BCE1202", "BCE1203", sem2[0], sem2[1], sem2[2], sem2[3]};
            for(String s:subs) {
                subjects[num] = s;
                num += 1;
            }
        }
        else if(courseId=="EB02") {
            String subs[] = {"BSE1201", "BSE1202", sem2[0], sem2[1], sem2[2], sem2[3]};
            for(String s:subs) {
                subjects[num] = s;
                num += 1;
            }
        }
        
        //triming subjects array (removing null values)
        if (courseId=="EB02") {
            int someIndex = Arrays.asList(subjects).indexOf(null);
            realSubjects = Arrays.copyOfRange(subjects,0,someIndex);
        }
        else {
            realSubjects = subjects.clone();
        }
        
        
        //Connecting and work with Database
        Connection con = null;
        PreparedStatement pst = null;
        
        con = ConnectDB.connect();
        
        String sql1 = "INSERT INTO undergradStu VALUES ('"+ id +"', '"+ name +"', '"+ dob +"', '"+ gender +"', '"+ nic +"', '"+ civilStatus +"', '"+ address +"', '"+ phone +"', '"+ email +"', '"+ alResult +"', '"+ alRank +"', '"+ semId +"', '"+ courseId +"', '"+ courseEnroll +"', '"+ intake +"')";
        
        try {
            
            pst = con.prepareStatement(sql1);
            pst.execute();
            //JOptionPane.showConfirmDialog(null, "Sql1 successfully executed", "Succesfull", JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE);
            
        } catch (SQLException ex) {
            
            JOptionPane.showConfirmDialog(null,ex);
            
        }
        
        try {
            for(String s : realSubjects) {
                String sql2 = "INSERT INTO ustu_subject VALUES ('"+ id +"', '"+ s +"')";
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
