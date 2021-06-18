
import java.awt.List;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
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
public class Flight3 extends javax.swing.JFrame implements objects {
    File folder=new File("Seats");
    String[] seatArr=new String[25];
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    public String email;
    public String pw;
    public int line;
    public String date;
    public String airline;
    public String time;
    public String name;
    public String price;
    //needs to be changed when more flights added
    String[] arr=new String[200];
    
    
   
    /**
     * Creates new form International2
     */
    public Flight3() {
        initComponents();
    }
    
    
    void readFile() throws IOException{
        try {
            File file = new File(folder+"\\AvailableSeats.txt");
            Scanner reader = new Scanner(file);
            Scanner reader2 = new Scanner(file);
            reader.nextLine();
            
          int j=1;
            while (reader.hasNextLine()) {
               
                String data = reader.nextLine();
                if(j==line){
                seatArr = data.split(" ");
                }
                 j++;
                
            }
            int k=0;
            reader2.nextLine();
             while(reader2.hasNextLine() && k<arr.length){
                   String data=reader2.nextLine();
                   arr[k]=data;
                   k++;
     }
            } catch (FileNotFoundException ex) { 
            try {
                FileWriter fw=new FileWriter(folder+"\\AvailableSeats.txt");
            } catch (IOException ex1) {
                
            }
         } 
    }
   
   public void WriteNil(String availSeat) throws FileNotFoundException, IOException{
     
          RandomAccessFile raf=new RandomAccessFile(folder+"\\AvailableSeats.txt","rw");
          raf.writeBytes("For 200 Flights"+ "\r\n");
          String filePath = "E:\\Data Structures Ms Aleenah\\DSPORJECTCODE\\DSPROJECT\\Seats\\AvailableSeats.txt";
         //tooba path   "C:\\Users\\Dell\\Documents\\Downloads\\DSPROJECT\\DSPROJECT\\Seats\\AvailableSeats.txt";
    
          //Instantiating the Scanner class to read the file
      Scanner sc = new Scanner(new File(filePath));
      sc.nextLine();
      String s=arr[line-1]; //line is accessing the flight number from data base
      s=s.replaceAll(availSeat, "Nil");
      arr[line-1]=s;
      int i=0;
      while(sc.hasNextLine() && i<arr.length){
              raf.writeBytes(arr[i] + "\r\n");
              i++;
          }
   }
    
    public void isAvailable(String availSeat){
        
            
            Sort(seatArr,0,seatArr.length-1);
            int in=binarySearch(seatArr,availSeat);
            if(in!=-1){
                JOptionPane.showMessageDialog(this, "Seat is Available.");
            }
            else {
                JOptionPane.showMessageDialog(this, "Seat is not Available. Please select another seat");
            
        } 
    }
    
    static int binarySearch(String[] arr, String x) { 
        int l = 0, r = arr.length - 1; 
        while (l <= r) { 
            int m = l + (r - l) / 2; 
  
            int result = x.compareTo(arr[m]); 
  
            // Check if x is present at mid 
            if (result == 0) 
                return m; 
  
            // If x greater, ignore left half 
            if (result > 0) 
                l = m + 1; 
  
            // If x is smaller, ignore right half 
            else
                r = m - 1; 
        } 
  
        return -1; 
    } 
    
    public void Sort(String[] arr, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;

            Sort(arr, left, middle);
            Sort(arr, middle + 1, right);
            MergeS(arr, left, middle, right);
           
        }
    }

    public void MergeS( String[] arr, int left, int middle, int right) {
        
        //size of the 2 subarrays:
        int size1 = middle - left + 1; //this will include middle too
        int size2 = right - middle;

        //ceating new subarrays
        String[] L = new String[size1];
        String[] R = new String[size2];

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
            if (L[i].compareTo(R[j])<0 || L[i].compareTo(R[j])==0 ) {
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
   
    public void close(){
       WindowEvent closing = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
       Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closing);
       
   }
     public void setEmailPw(String email,String pw,int line,String time,String date,String airline){
       this.email=email;
       this.pw=pw;
       this.line=line;
       this.time=time;
       this.date=date;
       this.airline=airline;
       details();     
   }

    public void details(){
        
        String CNIC="cnic";
        String Number="num";
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            //con= DriverManager.getConnection("jdbc:ucanaccess://C:/Users/Dell/Documents/Downloads/DSPROJECT/DSPROJECT/AirplaneDatabase1.accdb");
    //Mahum 
              con= DriverManager.getConnection("jdbc:ucanaccess://E:/Data Structures Ms Aleenah/DSPORJECTCODE/DSPROJECT/AirplaneDatabase1.accdb");
    //Noor   //con= DriverManager.getConnection("jdbc:ucanaccess://C:/Users/HP/Downloads/DSPROJECT/AirplaneDatabase1.accdb");
    //Tooba  //con= DriverManager.getConnection("jdbc:ucanaccess://C:/Users/Dell/Documents/Downloads/DSPROJECT NEW/DSPROJECT (1)/DSPROJECT/AirplaneDatabase1.accdb");
            pst= con.prepareStatement("Select * from UserInformation where Email='"+email+"' and Password='"+pw+"'");
            rs=pst.executeQuery();
            while(rs.next()){
             
             name = rs.getString("Name");   
             CNIC=rs.getString("CNIC");
             Number=rs.getString("Number");
       }  
                
             pst.close();
             number.setText(Number);
             Email.setText(email);
             username.setText(name);
             cnic.setText(CNIC);
             destination.setText(f1.Dest);
             origin.setText(f1.Origin);
             int row= f2.jTable1.getSelectedRow();
             FlightDate.setText(date);
            
        }
        catch (ClassNotFoundException ex) {
            Logger.getLogger(CustomerLogin.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this,ex);
        } 
        catch (SQLException ex) {
            Logger.getLogger(CustomerLogin.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this,ex);
        }
        
        
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
        jButton4 = new javax.swing.JButton();
        back = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        destination = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        cnic = new javax.swing.JTextArea();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        username = new javax.swing.JTextArea();
        jScrollPane9 = new javax.swing.JScrollPane();
        origin = new javax.swing.JTextArea();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        Email = new javax.swing.JTextArea();
        jScrollPane7 = new javax.swing.JScrollPane();
        number = new javax.swing.JTextArea();
        jScrollPane11 = new javax.swing.JScrollPane();
        FlightDate = new javax.swing.JTextArea();
        jLabel15 = new javax.swing.JLabel();
        Seat = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton4.setBackground(new java.awt.Color(204, 204, 204));
        jButton4.setFont(new java.awt.Font("Sitka Small", 0, 20)); // NOI18N
        jButton4.setForeground(new java.awt.Color(162, 118, 141));
        jButton4.setText("Book Flight");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 370, 220, 30));

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

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Sitka Small", 0, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("BOOKING DETAILS");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, 350, 60));

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Sitka Text", 1, 20)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Flight Date:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 310, -1, 30));

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Sitka Text", 1, 20)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Name:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 80, -1, -1));

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Sitka Text", 1, 20)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("CNIC:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 120, -1, -1));

        jScrollPane6.setForeground(new java.awt.Color(221, 161, 80));
        jScrollPane6.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane6.setToolTipText("");
        jScrollPane6.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        destination.setColumns(20);
        destination.setFont(new java.awt.Font("Sitka Text", 0, 15)); // NOI18N
        destination.setForeground(new java.awt.Color(162, 118, 141));
        destination.setRows(5);
        jScrollPane6.setViewportView(destination);

        jPanel1.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 260, 130, 30));

        jScrollPane4.setForeground(new java.awt.Color(221, 161, 80));
        jScrollPane4.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane4.setToolTipText("");
        jScrollPane4.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        cnic.setColumns(20);
        cnic.setFont(new java.awt.Font("Sitka Text", 0, 15)); // NOI18N
        cnic.setForeground(new java.awt.Color(162, 118, 141));
        cnic.setRows(5);
        jScrollPane4.setViewportView(cnic);

        jPanel1.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 120, 180, 30));

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Sitka Text", 1, 20)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Email:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 160, -1, 30));

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("Sitka Text", 1, 20)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Mobile Number:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 210, -1, 30));

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setFont(new java.awt.Font("Sitka Text", 1, 20)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Origin:");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 260, -1, 30));

        jScrollPane8.setForeground(new java.awt.Color(221, 161, 80));
        jScrollPane8.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane8.setToolTipText("");
        jScrollPane8.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        username.setColumns(20);
        username.setFont(new java.awt.Font("Sitka Text", 0, 15)); // NOI18N
        username.setForeground(new java.awt.Color(162, 118, 141));
        username.setRows(5);
        jScrollPane8.setViewportView(username);

        jPanel1.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 80, 180, 30));

        jScrollPane9.setForeground(new java.awt.Color(221, 161, 80));
        jScrollPane9.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane9.setToolTipText("");
        jScrollPane9.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        origin.setColumns(20);
        origin.setFont(new java.awt.Font("Sitka Text", 0, 15)); // NOI18N
        origin.setForeground(new java.awt.Color(162, 118, 141));
        origin.setRows(5);
        jScrollPane9.setViewportView(origin);

        jPanel1.add(jScrollPane9, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 260, 130, 30));

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setFont(new java.awt.Font("Sitka Text", 1, 20)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Select Seat:");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 310, -1, 30));

        jScrollPane10.setForeground(new java.awt.Color(221, 161, 80));
        jScrollPane10.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane10.setToolTipText("");
        jScrollPane10.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        Email.setColumns(20);
        Email.setFont(new java.awt.Font("Sitka Text", 0, 15)); // NOI18N
        Email.setForeground(new java.awt.Color(162, 118, 141));
        Email.setRows(5);
        jScrollPane10.setViewportView(Email);

        jPanel1.add(jScrollPane10, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 160, 180, 30));

        jScrollPane7.setForeground(new java.awt.Color(221, 161, 80));
        jScrollPane7.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane7.setToolTipText("");
        jScrollPane7.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        number.setColumns(20);
        number.setFont(new java.awt.Font("Sitka Text", 0, 15)); // NOI18N
        number.setForeground(new java.awt.Color(162, 118, 141));
        number.setRows(5);
        jScrollPane7.setViewportView(number);

        jPanel1.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 210, 180, 30));

        jScrollPane11.setForeground(new java.awt.Color(221, 161, 80));
        jScrollPane11.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane11.setToolTipText("");
        jScrollPane11.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        FlightDate.setColumns(20);
        FlightDate.setFont(new java.awt.Font("Sitka Text", 0, 15)); // NOI18N
        FlightDate.setForeground(new java.awt.Color(162, 118, 141));
        FlightDate.setRows(5);
        jScrollPane11.setViewportView(FlightDate);

        jPanel1.add(jScrollPane11, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 310, 130, 30));

        jLabel15.setBackground(new java.awt.Color(255, 255, 255));
        jLabel15.setFont(new java.awt.Font("Sitka Text", 1, 20)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Destination:");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 260, -1, 30));

        Seat.setFont(new java.awt.Font("Sitka Text", 0, 15)); // NOI18N
        Seat.setForeground(new java.awt.Color(162, 118, 141));
        Seat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "A1", "A2", "A3", "A4", "A5", "B1", "B2", "B3", "B4", "B5", "C1", "C2", "C3", "C4", "C5", "D1", "D2", "D3", "D4", "D5", "E1", "E2", "E3", "E4", "E5" }));
        Seat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SeatActionPerformed(evt);
            }
        });
        jPanel1.add(Seat, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 310, 130, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images.jpeg (1).jpg"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 670, 420));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 650, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 420, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
             stack.push("f3");
             dispose();
             Ticket t=new Ticket();
             t.SetTicket(name, f1.Origin, f1.Dest, time, date, Seat.getSelectedItem().toString(), airline);
             t.setLocationRelativeTo(null);
             t.setVisible(true);
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
         dispose();
         stack.CheckStack(stack.pop().toString());
    }//GEN-LAST:event_backActionPerformed

    private void SeatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SeatActionPerformed
        try {
            readFile();      
            isAvailable(Seat.getSelectedItem().toString());
            
        } catch (IOException ex) {
            Logger.getLogger(Flight3.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_SeatActionPerformed

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
            java.util.logging.Logger.getLogger(Flight3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Flight3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Flight3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Flight3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Flight3().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea Email;
    private javax.swing.JTextArea FlightDate;
    private javax.swing.JComboBox<String> Seat;
    private javax.swing.JButton back;
    private javax.swing.JTextArea cnic;
    private javax.swing.JTextArea destination;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTextArea number;
    private javax.swing.JTextArea origin;
    private javax.swing.JTextArea username;
    // End of variables declaration//GEN-END:variables
}
