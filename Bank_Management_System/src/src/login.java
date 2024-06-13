import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author selvaganesh
 */
public class login extends javax.swing.JFrame {

    /**
     * Creates new form login
     */
    public login() {
        initComponents();
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_username = new javax.swing.JTextField();
        txt_password = new javax.swing.JPasswordField();
        login = new javax.swing.JButton();
        reset = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("BANKING SYSTEM");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(130, 30, 220, 20);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel2.setText("username:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(30, 120, 70, 20);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel3.setText("password:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(30, 200, 70, 20);
        jPanel1.add(txt_username);
        txt_username.setBounds(120, 120, 230, 30);
        jPanel1.add(txt_password);
        txt_password.setBounds(120, 200, 230, 30);

        login.setText("LOGIN");
        login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginActionPerformed(evt);
            }
        });
        jPanel1.add(login);
        login.setBounds(120, 290, 80, 23);

        reset.setText("RESET");
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetActionPerformed(evt);
            }
        });
        jPanel1.add(reset);
        reset.setBounds(273, 290, 80, 23);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginActionPerformed
        // TODO add your handling code here
      
                  String s1=txt_username.getText();
                  String s2=new String(txt_password.getPassword());
                    try
                    {
                       Class.forName("com.mysql.jdbc.Driver");
                       Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","root");
                       Statement stmt=con.createStatement();
                       String query="select * from login where userid='"+s1+"' and passwd='"+s2+"'";
                        ResultSet rs=stmt.executeQuery(query);
                        if(rs.next())
                       {
                           JOptionPane.showMessageDialog(null,"username and password matched");
                           userlogin u=new userlogin();
                           u.setVisible(true);
                           this.dispose();
                          }
                      
                       else
                       {
                       JOptionPane.showMessageDialog(null,"username and password not match");
                       System.exit(0);
                       }
                    }
                catch(Exception ex)
                      {
                          JOptionPane.showMessageDialog(null,"login failed");
                      }
                
    }//GEN-LAST:event_loginActionPerformed

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed
        // TODO add your handling code here:
        txt_username.setText("");
        txt_password.setText("");
    }//GEN-LAST:event_resetActionPerformed

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
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login().setVisible(true);
            }
        });
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton login;
    private javax.swing.JButton reset;
    private javax.swing.JPasswordField txt_password;
    private javax.swing.JTextField txt_username;
    // End of variables declaration//GEN-END:variables
}