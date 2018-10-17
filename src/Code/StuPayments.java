package Code;

import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class StuPayments {
    
    private String paymentId;
    private String sId;
    private double amount;
    private String date;

    public StuPayments(String paymentId, String sId, double amount, String date) {
        this.paymentId = paymentId;
        this.sId = sId;
        this.amount = amount;
        this.date = date;
    }
    
    public StuPayments(String sId, double amount, String date) {
        this.sId = sId;
        this.amount = amount;
        this.date = date;
    }
    
    public StuPayments(String paymentId) {
        this.paymentId = paymentId;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public String getsId() {
        return sId;
    }

    public void setsId(String sId) {
        this.sId = sId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
    public void add() {
        
        Connection con = null;
        PreparedStatement pst = null;
        con = ConnectDB.connect();
    
        try{
                
            String sql = "INSERT INTO payment (studentId, payedAmount, payedDay) VALUES ('"+ this.sId +"', '"+ this.amount +"', '"+ this.date +"')";
            pst = con.prepareStatement(sql);
            pst.execute();

            JOptionPane.showConfirmDialog(null, "New Payment Successfully Added", "Succesfull", JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE);


        }
        catch (Exception e) {

            JOptionPane.showConfirmDialog(null,e);

        }
    
    }
    
    public void delete() {
    
        Connection con = null;
        PreparedStatement pst = null;
        con = ConnectDB.connect();
        
        String sql = "DELETE FROM payment WHERE paymentId = '"+ this.paymentId +"'";
            
        try {
            
            pst = con.prepareStatement(sql);
            pst.execute();

        }
        
        catch (Exception e) {
            
            JOptionPane.showConfirmDialog(null, e);
            
        }
        
    }

}
