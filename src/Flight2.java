
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Acer
 */
public class Flight2 extends javax.swing.JFrame implements objects {

    /**
     * Creates new form International
     */
    
    public String Dest;
    public String Origin; 
    public String email;
    public String pw;
    public int line;
    public String airline;
    public String date;
    public String time;
    
      
    ArrayList<String> records = new ArrayList<String>();
     Connection con;
    PreparedStatement pst;
    ResultSet rs;
    
    public Flight2() {
        initComponents();
         
    }
   public void setlocation(String Origin,String Dest) throws ClassNotFoundException, SQLException{
       this.Dest=Dest;
       this.Origin=Origin;
       search();
       
   }
   public void setEmailPw(String email,String pw){
       this.email=email;
       this.pw=pw;
               
   }
   
  //MergeSort:
        public void Sort(double[] arr, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;

            Sort(arr, left, middle);
            Sort(arr, middle + 1, right);
            Merge(arr, left, middle, right);
           
        }
    }
        
     public void Merge(double[] arr, int left, int middle, int right) {
        
        //size of the 2 subarrays:
        int size1 = middle - left + 1; //this will include middle too
        int size2 = right - middle;

        //ceating new subarrays
        double[] L = new double[size1];
        double[] R = new double[size2];

        //copying data to the new arrays
        for (int i = 0; i < size1; ++i) { 
            L[i] = arr[left + i]; //left se place karne hain elements
        }
        for (int i = 0; i < size2; ++i) {
            R[i] = arr[middle + 1 + i]; //middle ke agay se place karne hain elements
        }

        //Now merging:
        int i = 0;
        int j = 0;
        int k = left; //for placing the sorted elements into arr 

        while (i < size1 && j < size2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i]; //placing the smaller element into the array
                i++;
            } else { //when L[i]>R[j]
                arr[k] = R[j]; //placing the smaller element into the array
                j++;
            }

            k++; // to prevent overwriting on the same spot in the array
        }

        // Copy the remaining elements of L[], if there are any  
        while (i < size1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        // Copy the remaining elements of R[], if there are any  
        while (j < size2) {
            arr[k] = R[j];
            j++;
            k++;
        }

    }
     
      public void searchSelected() throws ClassNotFoundException, SQLException{
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
              DefaultTableModel dft = (DefaultTableModel)jTable1.getModel();
           con= DriverManager.getConnection("jdbc:ucanaccess://E:/Data Structures Ms Aleenah/DSPORJECTCODE/DSPROJECT/AirplaneDatabase1.accdb");
         //con= DriverManager.getConnection("jdbc:ucanaccess://C:/Users/Dell/Documents/Downloads/DSPROJECT NEW/DSPROJECT (1)/DSPROJECT/AirplaneDatabase1.accdb");
         
         //Tooba: "jdbc:ucanaccess://C:/Users/Dell/Documents/Downloads/DSPROJECT (1)/DSPROJECT/AirplaneDatabase1.accdb"
           pst= con.prepareStatement("Select * from FlightInformation where Origin='"+Origin+"' and Destination='"+Dest + "' and Date='"+ jTable1.getValueAt(jTable1.getSelectedRow(), 2)+ "' and Time='"+ jTable1.getValueAt(jTable1.getSelectedRow(),3)+ "' and Airline='"+ jTable1.getValueAt(jTable1.getSelectedRow(),4)+"'");
            rs=pst.executeQuery();
            while(rs.next()){
                line=rs.getInt("FlightID");
                date = rs.getString("Date");
                time = rs.getString("Time");
                airline = rs.getString("Airline");
                            
            }
      }
      
   
   
   public void search() throws ClassNotFoundException, SQLException{
       
   
       Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
     con= DriverManager.getConnection("jdbc:ucanaccess://E:/Data Structures Ms Aleenah/DSPORJECTCODE/DSPROJECT/AirplaneDatabase1.accdb");
         //con= DriverManager.getConnection("jdbc:ucanaccess://C:/Users/Dell/Documents/Downloads/DSPROJECT NEW/DSPROJECT (1)/DSPROJECT/AirplaneDatabase1.accdb");
         
         //Tooba: "jdbc:ucanaccess://C:/Users/Dell/Documents/Downloads/DSPROJECT (1)/DSPROJECT/AirplaneDatabase1.accdb"
           pst= con.prepareStatement("Select * from FlightInformation where Origin='"+Origin+"' and Destination='"+Dest+"'");
            rs=pst.executeQuery();
            int i=0;
            int count=0;
            DefaultTableModel dft = (DefaultTableModel)jTable1.getModel();
             dft.setRowCount(0);
             while(rs.next()){
             records.add(rs.getString("Origin")+" | "+rs.getString("Destination")+" | "+rs.getString("Date")+" | "+rs.getString("Time")+" | "+rs.getString("Duration")+" | "+rs.getString("Airline")+" | "+rs.getString("Currency"));
             
             String O = rs.getString("Origin");
             String D = rs.getString("Destination");
             String Date = rs.getString("Date");
             String T = rs.getString("Time");
             String A = rs.getString("Airline");
             Double C = Double.parseDouble(rs.getString("Currency"));
           
             
             Vector d= new Vector();
             d.add(O);
             d.add(D);
             d.add(Date);
             d.add(T);
             d.add(A);
             d.add(C);
             dft.addRow(d);
          
               count++;
               
            }
               rs.close();
   } 
             
            
         
   
   @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        BookFlightbtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        back = new javax.swing.JButton();
        SortBy = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BookFlightbtn.setBackground(new java.awt.Color(204, 204, 204));
        BookFlightbtn.setFont(new java.awt.Font("Sitka Small", 0, 20)); // NOI18N
        BookFlightbtn.setForeground(new java.awt.Color(162, 118, 141));
        BookFlightbtn.setText("Book Flight");
        BookFlightbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BookFlightbtnActionPerformed(evt);
            }
        });
        jPanel1.add(BookFlightbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 370, 150, 30));

        jTable1.setFont(new java.awt.Font("Sitka Text", 0, 15)); // NOI18N
        jTable1.setForeground(new java.awt.Color(162, 118, 141));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "FROM", "TO", "DATE", "TIME", "AIRLINE", "PRICE"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.setDragEnabled(true);
        jTable1.setGridColor(new java.awt.Color(162, 118, 141));
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, 550, 230));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Sitka Text", 0, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("BOOKING FLIGHT");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 30, -1, -1));

        back.setBackground(new java.awt.Color(204, 204, 204));
        back.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        back.setForeground(new java.awt.Color(162, 118, 141));
        back.setText("←");
        back.setBorder(null);
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        jPanel1.add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 60));

        SortBy.setBackground(new java.awt.Color(204, 204, 204));
        SortBy.setFont(new java.awt.Font("Sitka Text", 0, 12)); // NOI18N
        SortBy.setForeground(new java.awt.Color(162, 118, 141));
        SortBy.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "Price" }));
        SortBy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SortByActionPerformed(evt);
            }
        });
        jPanel1.add(SortBy, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 100, 90, -1));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Sitka Text", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Sort By:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 100, -1, -1));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Sitka Text", 1, 20)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("INTERNATIONAL");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images.jpeg (1).jpg"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 760, 410));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 410));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BookFlightbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BookFlightbtnActionPerformed
if(jTable1.getSelectedRowCount()==0){
           JOptionPane.showMessageDialog(this, "Select a Flight to continue.");
       }
       else if(jTable1.getSelectedRowCount()==1){
    try {
        f2.searchSelected();
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(Flight2.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SQLException ex) {
        Logger.getLogger(Flight2.class.getName()).log(Level.SEVERE, null, ex);
    }
          f3.setEmailPw(email, pw,line,time,date,airline);
           dispose();
           f3.setLocationRelativeTo(null);
           f3.setVisible(true);
           stack.push("f2");
           
       }
       else{
             JOptionPane.showMessageDialog(this, "Select only one Flight to continue.");
       }          
    }//GEN-LAST:event_BookFlightbtnActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        dispose();
         stack.CheckStack(stack.pop().toString());
       
      
    }//GEN-LAST:event_backActionPerformed

    private void SortByActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SortByActionPerformed
        // TODO add your handling code here:
        try{
        double price[]= new double[jTable1.getRowCount()];
        if(SortBy.getSelectedItem().equals("Price")){
          for(int i=0;i<jTable1.getRowCount();i++){
              price[i]= Double.parseDouble(jTable1.getValueAt(i,5).toString());
          }  
        Sort(price,0,price.length-1);
        
         Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
         con= DriverManager.getConnection("jdbc:ucanaccess://E:/Data Structures Ms Aleenah/DSPORJECTCODE/DSPROJECT/AirplaneDatabase1.accdb");
        //E:\Data Structures Ms Aleenah\DSPORJECTCODE\DSPROJECT\DSPROJECT
         //con= DriverManager.getConnection("jdbc:ucanaccess://C:/Users/Dell/Documents/Downloads/DSPROJECT NEW/DSPROJECT (1)/DSPROJECT/AirplaneDatabase1.accdb");
         DefaultTableModel dft = (DefaultTableModel)jTable1.getModel();
             dft.setRowCount(0);
         //Tooba: "jdbc:ucanaccess://C:/Users/Dell/Documents/Downloads/DSPROJECT (1)/DSPROJECT/AirplaneDatabase1.accdb"
         for(int i=0;i<price.length;i++){
         pst= con.prepareStatement("Select * from FlightInformation where Origin='"+Origin+"' and Destination='"+Dest+"'"+" and Currency='"+price[i]+"'");
            rs=pst.executeQuery();
            while(rs.next()){
             String O = rs.getString("Origin");
             String D = rs.getString("Destination");
             String Date = rs.getString("Date");
             String T = rs.getString("Time");
             String A = rs.getString("Airline");
             Double C = Double.parseDouble(rs.getString("Currency"));
             
             Vector d= new Vector();
             d.add(O);
             d.add(D);
             d.add(Date);
             d.add(T);
             d.add(A);
             d.add(C);
             dft.addRow(d);
                
         }
    }
} 
        } catch (ClassNotFoundException ex) {
             Logger.getLogger(Flight2.class.getName()).log(Level.SEVERE, null, ex);
         } catch (SQLException ex) {
             Logger.getLogger(Flight2.class.getName()).log(Level.SEVERE, null, ex);
         }
          
        
    }//GEN-LAST:event_SortByActionPerformed

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
            java.util.logging.Logger.getLogger(Flight2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Flight2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Flight2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Flight2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Flight2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BookFlightbtn;
    private javax.swing.JComboBox<String> SortBy;
    private javax.swing.JButton back;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

    
}
