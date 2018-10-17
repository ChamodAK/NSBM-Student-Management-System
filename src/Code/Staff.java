package Code;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class Staff {
    
    private int staffId;
    private String name;
    private String dob;
    private String gender;
    private String civilStatus;
    private String nic;
    private String phoneNo;
    private String address;
    private String email;
    private String category;

    public Staff(String name, String dob, String gender, String civilStatus, String nic, String phoneNo, String address, String email, String category) {
        this.name = name;
        this.dob = dob;
        this.gender = gender;
        this.civilStatus = civilStatus;
        this.nic = nic;
        this.phoneNo = phoneNo;
        this.address = address;
        this.email = email;
        this.category = category;
        
    }
    
    public Staff(int staffId, String name, String dob, String gender, String civilStatus, String nic, String phoneNo, String address, String email, String category) {
        this.staffId = staffId;
        this.name = name;
        this.dob = dob;
        this.gender = gender;
        this.civilStatus = civilStatus;
        this.nic = nic;
        this.phoneNo = phoneNo;
        this.address = address;
        this.email = email;
        this.category = category;
        
    }
    
    public Staff(int staffId) {
        this.staffId = staffId;
    
    }

    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCivilStatus() {
        return civilStatus;
    }

    public void setCivilStatus(String civilStatus) {
        this.civilStatus = civilStatus;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    
    public void add() {
    
        Connection con = null;
        PreparedStatement pst = null;
        con = ConnectDB.connect();
    
        try{
                
            String sql = "INSERT INTO staff (name, dob, gender, civilStatus, nic, phoneNo, address, email, category) VALUES ('"+ this.name +"', '"+ this.dob +"', '"+ this.gender +"', '"+ this.civilStatus +"', '"+ this.nic +"', '"+ this.phoneNo +"', '"+ this.address +"', '"+ this.email +"', '"+ this.category +"')";
            pst = con.prepareStatement(sql);
            pst.execute();

            JOptionPane.showConfirmDialog(null, "New Staff Member Successfully Added", "Succesfull", JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE);


        }
        catch (Exception e) {

            JOptionPane.showConfirmDialog(null,e);

        }
    
    }
    
    public void update() {
    
        Connection con = null;
        PreparedStatement pst = null;
        con = ConnectDB.connect();
        
        String sql = "UPDATE staff SET name = '"+ this.name +"', dob = '"+ this.dob +"', gender = '"+ this.gender +"', civilStatus = '"+ this.civilStatus +"', nic = '"+ this.nic +"', phoneNo = '"+ this.phoneNo +"', address = '"+ this.address +"', email = '"+ this.email +"', category = '"+ this.category +"' WHERE staffId = '"+ this.staffId +"'";
        
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
        
        String sql = "DELETE FROM staff WHERE staffId = '"+ this.staffId +"'";
            
        try {
            
            pst = con.prepareStatement(sql);
            pst.execute();

        }
        
        catch (Exception e) {
            
            JOptionPane.showConfirmDialog(null, e);
            
        }
    
    }
    
    
    
    
    

}
