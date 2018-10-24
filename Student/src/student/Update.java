package student;
import java.awt.Image;
import java.sql.*;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
public class Update extends javax.swing.JFrame {

     String stt;
     Connection con = null;
    Statement st = null;

    public void connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/student?useSSL=false", "root", "incorrect");
            st = con.createStatement();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
  
    public Update(String s) 
    { 
        stt=s;
        initComponents();
        sname.setText(stt);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        supdate = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        sname = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        sid = new javax.swing.JLabel();
        update = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        retrive = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setType(java.awt.Window.Type.POPUP);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        supdate.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select what to update", "ID", "Name", "Branch", "gender", "age", "Fee", "DOB", "Marital_status", "Contact", "Address" }));
        getContentPane().add(supdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 80, 150, -1));

        jLabel1.setText("write new Information");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 50, 157, -1));
        getContentPane().add(sname, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 15, 122, 29));

        jButton1.setText("Apply");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 129, 122, -1));

        jButton2.setText("Cancel");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 130, 150, -1));
        getContentPane().add(sid, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 80, 120, 20));

        update.setColumns(20);
        update.setRows(5);
        getContentPane().add(update, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 80, 250, 70));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/student/-1229066421.jpg"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 0, 580, 250));
        getContentPane().add(retrive, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 0, 210, 250));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
      dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
              try {
            connect();
            String sql = "update pupil set "+supdate.getSelectedItem()+"='"+update.getText()+"' Where ID="+sid.getText();
            int r = st.executeUpdate(sql);
            if(r>0){
                JOptionPane.showMessageDialog(null,"Updated");
                dispose();
            }
            else
                 JOptionPane.showMessageDialog(null,"Error");
            } catch (Exception e) {
             JOptionPane.showMessageDialog(null, e);
            }    
      
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
  try {
            connect();
            String sql = "Select * from pupil where Name='"+stt+"'";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                sid.setText(rs.getString("ID"));
                byte [] img=rs.getBytes("image");
                ImageIcon image=new ImageIcon(img);
                Image im=image.getImage();
                Image scaledImage=im.getScaledInstance(retrive.getWidth(),retrive.getHeight(),Image.SCALE_SMOOTH);
                ImageIcon newImage=new ImageIcon(scaledImage);
                retrive.setIcon(newImage);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowOpened
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
            Update up=new Update(null);
            up.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel retrive;
    private javax.swing.JLabel sid;
    private javax.swing.JLabel sname;
    private javax.swing.JComboBox<String> supdate;
    private javax.swing.JTextArea update;
    // End of variables declaration//GEN-END:variables

}
