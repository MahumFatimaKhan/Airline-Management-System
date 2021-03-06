
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Acer
 */
 
class ObjectStack implements objects{
public Object[] stackarr;
public int top;
public int max=6;


public ObjectStack(){
    stackarr=new Object[max];
    top=-1;
}

public boolean isEmpty(){
    return (top==-1);
        
}

public boolean isFull(){
    return (top==max-1);
}

public void clearStack(){
    top=-1;  
}

public void push(Object value){
    if (top < max){
     stackarr[++top] = value;
 }
}

public Object pop(){
    Object result=stackarr[top];
    if(top!=-1){
        top--;
    }
    return result;   
}

public void CheckStack(String s){
        if(s.equals("f2")){
        f2.setLocationRelativeTo(null);
        f2.setVisible(true);
      }
      else if(s.equals("f1")){
        f1.setLocationRelativeTo(null);
        f1.setVisible(true);
      }
      else if(s.equals("f3")){
        f3.setLocationRelativeTo(null);
        f3.setVisible(true);
      }
      else if(s.equals("pf")) {
        pf.setLocationRelativeTo(null);
        pf.setVisible(true);
      }
    }
}


public class Flight1 extends javax.swing.JFrame implements objects{
public String email;
public String pw;

    /**
     * Creates new form Flight1
     */
    public Flight1() {
        initComponents();
    }
    public String Dest;
    public String Origin;
    
    public void setEmailPw(String email,String pw){
       this.email=email;
       this.pw=pw;
               
   }
    
    int readFileForDest() throws IOException{
        int count=0;
        try {
            File file = new File("ShortestPath.txt");
            Scanner reader = new Scanner(file);
            reader.nextLine();
            while (reader.hasNextLine()) {
                String data = reader.nextLine();
                String[] split = data.split(",");
                for (String word : split) 
          {
                 if (word.equals(Dest))   //Search for the given word
                 {
                  count++;   //If Present increase the count by one
                 }

          }
            }
          
      
         
    }   catch (FileNotFoundException ex) { 

         }
    return count;
    }
    
        int readFileForOrigin() throws IOException{
        int count=0;
        try {
            File file = new File("ShortestPath.txt");
            Scanner reader = new Scanner(file);
            reader.nextLine();
            while (reader.hasNextLine()) {
                String data = reader.nextLine();
                String[] split = data.split(",");
                for (String word : split) 
          {
                 if (word.equals(Origin))   //Search for the given word
                 {
                  count++;   //If Present increase the count by one
                 }

          }
            }
          
      
         
    }   catch (FileNotFoundException ex) { 

         }
    return count;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        CityDEST = new javax.swing.JComboBox<>();
        CityORIGIN = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        PathFinderbtn = new javax.swing.JButton();
        Searchbtn = new javax.swing.JButton();
        CountryOrigin = new javax.swing.JComboBox<>();
        CountryDEST = new javax.swing.JComboBox<>();
        Logout = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(650, 440));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 3, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 255));
        jLabel1.setText("WELCOME USER!");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 610, -1));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Sitka Text", 0, 35)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("SEARCH AND BOOK FLIGHT");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, -1, -1));

        CityDEST.setBackground(new java.awt.Color(204, 204, 204));
        CityDEST.setFont(new java.awt.Font("Sitka Text", 0, 14)); // NOI18N
        CityDEST.setForeground(new java.awt.Color(162, 118, 141));
        CityDEST.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CityDESTActionPerformed(evt);
            }
        });
        jPanel1.add(CityDEST, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 190, 80, 40));

        CityORIGIN.setBackground(new java.awt.Color(204, 204, 204));
        CityORIGIN.setFont(new java.awt.Font("Sitka Text", 0, 14)); // NOI18N
        CityORIGIN.setForeground(new java.awt.Color(162, 118, 141));
        CityORIGIN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CityORIGINActionPerformed(evt);
            }
        });
        jPanel1.add(CityORIGIN, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 130, 80, 40));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Sitka Text", 1, 20)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Select Destination");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 180, 190, 40));

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Sitka Text", 1, 20)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Select Origin");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, 130, 30));

        PathFinderbtn.setFont(new java.awt.Font("Sitka Small", 0, 18)); // NOI18N
        PathFinderbtn.setForeground(new java.awt.Color(162, 118, 141));
        PathFinderbtn.setText("PATH FINDER");
        PathFinderbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PathFinderbtnActionPerformed(evt);
            }
        });
        jPanel1.add(PathFinderbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 300, 180, 40));

        Searchbtn.setFont(new java.awt.Font("Sitka Small", 0, 18)); // NOI18N
        Searchbtn.setForeground(new java.awt.Color(162, 118, 141));
        Searchbtn.setText("SEARCH");
        Searchbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchbtnActionPerformed(evt);
            }
        });
        jPanel1.add(Searchbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 300, 170, 40));

        CountryOrigin.setBackground(new java.awt.Color(204, 204, 204));
        CountryOrigin.setFont(new java.awt.Font("Sitka Text", 0, 14)); // NOI18N
        CountryOrigin.setForeground(new java.awt.Color(162, 118, 141));
        CountryOrigin.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "US", "PK" }));
        CountryOrigin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CountryOriginActionPerformed(evt);
            }
        });
        jPanel1.add(CountryOrigin, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 130, 80, 40));

        CountryDEST.setBackground(new java.awt.Color(204, 204, 204));
        CountryDEST.setFont(new java.awt.Font("Sitka Text", 0, 14)); // NOI18N
        CountryDEST.setForeground(new java.awt.Color(162, 118, 141));
        CountryDEST.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "UK", "PK", "AU" }));
        CountryDEST.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CountryDESTActionPerformed(evt);
            }
        });
        jPanel1.add(CountryDEST, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 190, 80, 40));

        Logout.setFont(new java.awt.Font("Sitka Small", 0, 18)); // NOI18N
        Logout.setForeground(new java.awt.Color(162, 118, 141));
        Logout.setText("Logout");
        Logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutActionPerformed(evt);
            }
        });
        jPanel1.add(Logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 0, 100, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images.jpeg (1).jpg"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 730, 410));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 410));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CityDESTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CityDESTActionPerformed
        // TODO add your handling code here:
        Dest = CityDEST.getSelectedItem()+"("+CountryDEST.getSelectedItem()+")";

        
    }//GEN-LAST:event_CityDESTActionPerformed

    private void CityORIGINActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CityORIGINActionPerformed
        // TODO add your handling code here:
       Origin =  CityORIGIN.getSelectedItem()+"("+CountryOrigin.getSelectedItem()+")";
    }//GEN-LAST:event_CityORIGINActionPerformed

    private void SearchbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchbtnActionPerformed
         
        try {
            f2.setlocation(Origin, Dest);
            f2.setEmailPw(email, pw);
            dispose();
            f2.setLocationRelativeTo(null);
            f2.setVisible(true);
            stack.push("f1");
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Flight1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Flight1.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }//GEN-LAST:event_SearchbtnActionPerformed

    private void CountryOriginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CountryOriginActionPerformed
        // TODO add your handling code here:
        if(CountryOrigin.getSelectedItem().equals("US")){
            CityORIGIN.removeAllItems();
            CityORIGIN.setSelectedItem(null);
            CityORIGIN.addItem("NY");
            CityORIGIN.addItem("SF");
            CityORIGIN.addItem("LA");
            CityORIGIN.addItem("CHI");
        }
        else if(CountryOrigin.getSelectedItem().equals("PK")){
            CityORIGIN.removeAllItems();
            CityORIGIN.setSelectedItem(null);
            CityORIGIN.addItem("KHI");
            CityORIGIN.addItem("LHE");
         
            
        }
        
    }//GEN-LAST:event_CountryOriginActionPerformed

    private void CountryDESTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CountryDESTActionPerformed
        // TODO add your handling code here:
        
         if(CountryDEST.getSelectedItem().equals("UK")){
            CityDEST.removeAllItems();
            CityDEST.setSelectedItem(null);
            CityDEST.addItem("LDN");
            CityDEST.addItem("MCR");
            CityDEST.addItem("BHM");
            CityDEST.addItem("BRS");
            
        }else if(CountryDEST.getSelectedItem().equals("PK")){
            CityDEST.removeAllItems();
            CityDEST.setSelectedItem(null);
            CityDEST.addItem("KHI");
            CityDEST.addItem("LHE");
            CityDEST.addItem("ISB");
            CityDEST.addItem("PEW");
            
        }
        else if(CountryDEST.getSelectedItem().equals("AU")){
            CityDEST.removeAllItems();
            CityDEST.setSelectedItem(null);
            CityDEST.addItem("SY");
            CityDEST.addItem("MELB");
            
        }
        
    }//GEN-LAST:event_CountryDESTActionPerformed

    private void PathFinderbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PathFinderbtnActionPerformed
    
        try {
        int check1=readFileForDest();
        int check2=readFileForOrigin();
 
        if(check1!=0 && check2!=0){
            pf.Finder(Origin, Dest);
            dispose();
            stack.push("f1");
            pf.setLocationRelativeTo(null);
            pf.setVisible(true);
        }
        else {
                 JOptionPane.showMessageDialog(this, "You have direct flights available.");
        }
        
    } catch (IOException ex) {
       // JOptionPane.showMessageDialog(this, "You have direct flights available.");
    }

    }//GEN-LAST:event_PathFinderbtnActionPerformed

    private void LogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutActionPerformed
        dispose();
        AdminCustomer ac=new AdminCustomer();
        ac.setLocationRelativeTo(null);
        ac.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_LogoutActionPerformed
    
    

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Flight1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Flight1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Flight1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Flight1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Flight1().setVisible(true);
            }
        });
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CityDEST;
    private javax.swing.JComboBox<String> CityORIGIN;
    private javax.swing.JComboBox<String> CountryDEST;
    private javax.swing.JComboBox<String> CountryOrigin;
    private javax.swing.JButton Logout;
    private javax.swing.JButton PathFinderbtn;
    private javax.swing.JButton Searchbtn;
    public javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}

