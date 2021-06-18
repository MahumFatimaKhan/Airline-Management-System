
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Acer
 */


public class Ticket extends javax.swing.JFrame implements objects{
public String name;
public String Origin;
public String Destination;
public String time;
public String Date;
public String Seat;
public String Airline;
    /**
     * Creates new form Flight2
     */
    public Ticket() {
        initComponents();
    }
public void SetTicket(String name,String Origin,String Destination,String time,String Date,String Seat,String Airline){
    this.name=name;
    this.Origin=Origin;
    this.Destination=Destination;
    this.time=time;
    this.Date=Date;
    this.Seat=Seat;
    this.Airline=Airline;
    display();
    
}

public void display(){
    tname.setText(name);
    tOrigin.setText(Origin);
    tDestination.setText(Destination);
    tTime.setText(time);
    tSeat.setText(Seat);
    tAirline.setText(Airline);
    tDate.setText(Date);
    int gate=(int) (Math.random()*10);
    String g="P" + gate;
    tGate.setText(g);
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
        jLabel3 = new javax.swing.JLabel();
        back = new javax.swing.JButton();
        tOrigin = new javax.swing.JLabel();
        tname = new javax.swing.JLabel();
        tAirline = new javax.swing.JLabel();
        tDate = new javax.swing.JLabel();
        tSeat = new javax.swing.JLabel();
        tDestination = new javax.swing.JLabel();
        tGate = new javax.swing.JLabel();
        tTime = new javax.swing.JLabel();
        Logout = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Sitka Text", 1, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 20, -1, -1));

        back.setBackground(new java.awt.Color(0, 0, 0));
        back.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        back.setForeground(new java.awt.Color(255, 255, 255));
        back.setText("←");
        back.setBorder(null);
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        jPanel1.add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 60));

        tOrigin.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        tOrigin.setText("Name");
        jPanel1.add(tOrigin, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 170, 210, 50));

        tname.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        tname.setText("Name");
        jPanel1.add(tname, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 120, 210, 30));

        tAirline.setFont(new java.awt.Font("Sitka Text", 0, 20)); // NOI18N
        tAirline.setText("Name");
        jPanel1.add(tAirline, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 120, 160, 30));

        tDate.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        tDate.setText("Name");
        jPanel1.add(tDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 280, 210, 40));

        tSeat.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        tSeat.setText("Name");
        jPanel1.add(tSeat, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 210, 210, 30));

        tDestination.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        tDestination.setText("Name");
        jPanel1.add(tDestination, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 210, 210, 40));

        tGate.setFont(new java.awt.Font("Sitka Text", 0, 20)); // NOI18N
        tGate.setText("Name");
        jPanel1.add(tGate, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 110, 130, 40));

        tTime.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        tTime.setText("Name");
        jPanel1.add(tTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 290, 160, 30));

        Logout.setBackground(new java.awt.Color(0, 0, 0));
        Logout.setFont(new java.awt.Font("Sitka Small", 0, 18)); // NOI18N
        Logout.setForeground(new java.awt.Color(255, 255, 255));
        Logout.setText("Logout");
        Logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutActionPerformed(evt);
            }
        });
        jPanel1.add(Logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 0, 100, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/TicketProject.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 740, 370));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        dispose();
        stack.CheckStack(stack.pop().toString());
    }//GEN-LAST:event_backActionPerformed

    private void LogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutActionPerformed
    try {
        dispose();
        f3.WriteNil(Seat);
        AdminCustomer ac=new AdminCustomer();
        ac.setLocationRelativeTo(null);
        ac.setVisible(true);        // TODO add your handling code here:
    } catch (IOException ex) {
        Logger.getLogger(Ticket.class.getName()).log(Level.SEVERE, null, ex);
    }
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
            java.util.logging.Logger.getLogger(Ticket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ticket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ticket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ticket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ticket().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Logout;
    private javax.swing.JButton back;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel tAirline;
    private javax.swing.JLabel tDate;
    private javax.swing.JLabel tDestination;
    private javax.swing.JLabel tGate;
    private javax.swing.JLabel tOrigin;
    private javax.swing.JLabel tSeat;
    private javax.swing.JLabel tTime;
    private javax.swing.JLabel tname;
    // End of variables declaration//GEN-END:variables
}
