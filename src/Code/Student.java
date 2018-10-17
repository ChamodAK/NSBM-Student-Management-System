package Code;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;
import javax.swing.JOptionPane;

public abstract class Student {
    
    protected int studentID;
    protected String name;
    protected String dob;
    protected char gender;
    protected String nic;
    protected String civilStatus;
    protected String phoneNO;
    protected String email;
    protected String address;
    

    public Student(String name, String dob, char gender, String nic, String civilStatus, String phoneNO, String email, String address) {
        this.name = name;
        this.dob = dob;
        this.gender = gender;
        this.nic = nic;
        this.civilStatus = civilStatus;
        this.phoneNO = phoneNO;
        this.email = email;
        this.address = address;
        
        setStudentID();
    }

    public void setStudentID() {
        
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        
        con = ConnectDB.connect();
        
        int lastIndex = 0;
        int newId = 0;
        
        try {
            String sql = "SELECT lastIndex from studentIndex";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
           
            while(rs.next()) {
                lastIndex = rs.getInt("lastIndex");
                newId = lastIndex+1;
                this.studentID = newId;
                
            }
            
        }
        catch (Exception e) {
            JOptionPane.showConfirmDialog(null,e);
        }
        
        try {
            String sql2 = "UPDATE studentIndex SET lastIndex = '"+ newId +"' WHERE lastIndex = '"+ lastIndex +"'";
            pst = con.prepareStatement(sql2);
            pst.execute();
        }
        catch (Exception e) {
            JOptionPane.showConfirmDialog(null,e);
        }
        
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(String dob) {
        this.dob = dob;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public void setCivilStatus(String civilStatus) {
        this.civilStatus = civilStatus;
    }

    public void setPhoneNO(String phoneNO) {
        this.phoneNO = phoneNO;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getStudentID() {
        return studentID;
    }

    public String getName() {
        return name;
    }

    public String getDob() {
        return dob;
    }

    public char getGender() {
        return gender;
    }

    public String getNic() {
        return nic;
    }

    public String getCivilStatus() {
        return civilStatus;
    }

    public String getPhoneNO() {
        return phoneNO;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }
    
    
    
}

