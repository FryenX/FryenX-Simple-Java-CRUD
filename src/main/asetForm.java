/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package main;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import Config.constant;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import java.io.*;
import java.io.FileFilter;

/**
 *
 * @author FryenX
 */
public final class asetForm extends javax.swing.JFrame {

    /**
     * Creates new form asetForm
     */
    public asetForm() {
        initComponents();
        Fetch();
        LoadProductNo();
    }

    private final Connection conn = (Connection) new constant().connect();
    PreparedStatement pst;
    ResultSet rs;

    public void LoadProductNo() {
        try {
            pst = conn.prepareStatement("SELECT id_aset FROM tbl_aset");
            rs = pst.executeQuery();
            txtAsetID.removeAllItems();
            while (rs.next()) {
                txtAsetID.addItem(rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(asetForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void Fetch() {
        try {
            int q;
            pst = conn.prepareStatement("SELECT * FROM tbl_aset");
            rs = pst.executeQuery();
            ResultSetMetaData rss = rs.getMetaData();
            q = rss.getColumnCount();

            DefaultTableModel df = (DefaultTableModel) jTable.getModel();
            df.setRowCount(0);
            while (rs.next()) {
                Vector v2 = new Vector();
                for (int a = 1; a <= q; a++) {
                    v2.add(rs.getString("id_aset"));
                    v2.add(rs.getString("nama_aset"));
                    v2.add(rs.getString("deskripsi_aset"));
                    v2.add(rs.getString("jenis_aset"));
                    v2.add(rs.getString("status"));
                    v2.add(rs.getString("lokasi"));
                }
                df.addRow(v2);
            }
        } catch (SQLException ex) {
            Logger.getLogger(asetForm.class.getName()).log(Level.SEVERE, null, ex);
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtAsetID = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        txtStatus = new javax.swing.JComboBox<>();
        txtAname = new javax.swing.JTextField();
        txtType = new javax.swing.JTextField();
        txtLocation = new javax.swing.JTextField();
        txtAdd = new javax.swing.JButton();
        txtUpdate = new javax.swing.JButton();
        txtDelete = new javax.swing.JButton();
        txtCsv = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescription = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        txtSearchID = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Poppins Black", 1, 18)); // NOI18N
        jLabel1.setText("UTS PBO");

        jLabel2.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel2.setText("Deskripsi");

        jLabel3.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel3.setText("ID Aset");

        jLabel4.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel4.setText("Status");

        jLabel5.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel5.setText("Jenis");

        jLabel6.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel6.setText("Lokasi");

        txtAsetID.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        txtAsetID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAsetIDActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel7.setText("Aset");

        txtStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Baik", "Rusak" }));

        txtAdd.setText("ADD");
        txtAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAddActionPerformed(evt);
            }
        });

        txtUpdate.setText("UPDATE");
        txtUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUpdateActionPerformed(evt);
            }
        });

        txtDelete.setText("DELETE");
        txtDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDeleteActionPerformed(evt);
            }
        });

        txtCsv.setText("EXPORT TO CSV");
        txtCsv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCsvActionPerformed(evt);
            }
        });

        txtDescription.setColumns(20);
        txtDescription.setRows(5);
        jScrollPane1.setViewportView(txtDescription);

        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID Aset", "Nama", "Deskripsi", "Jenis", "Status", "Lokasi"
            }
        ));
        jScrollPane2.setViewportView(jTable);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 616, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        txtSearchID.setText("Search Aset");
        txtSearchID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchIDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addComponent(txtAdd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtUpdate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtDelete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtCsv)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 27, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(47, 47, 47)
                                                .addComponent(jLabel5))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jLabel6)))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(txtStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                            .addComponent(txtType)
                                            .addComponent(txtLocation)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGap(17, 17, 17)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(jLabel2)
                                                    .addComponent(jLabel7))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(txtAname)
                                                    .addComponent(jScrollPane1))))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtAsetID, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtSearchID))))
                .addGap(29, 29, 29))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtAsetID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txtAname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSearchID))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(txtStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAdd)
                    .addComponent(txtUpdate)
                    .addComponent(txtDelete)
                    .addComponent(txtCsv))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAddActionPerformed
        try {
            String aname = txtAname.getText();
            String description = txtDescription.getText();
            String type = txtType.getText();
            String status = txtStatus.getSelectedItem().toString();
            String location = txtLocation.getText();

            pst = conn.prepareStatement("INSERT INTO tbl_aset (nama_aset, deskripsi_aset, jenis_aset, status, lokasi) VALUES (?,?,?,?,?)");
            pst.setString(1, aname);
            pst.setString(2, description);
            pst.setString(3, type);
            pst.setString(4, status);
            pst.setString(5, location);

            int k = pst.executeUpdate();

            if (k == 1) {
                JOptionPane.showMessageDialog(this, "Aset Sukes Ditambahkan!");
                txtAname.setText("");
                txtDescription.setText("");
                txtType.setText("");
                txtStatus.setSelectedItem("Baik");
                txtLocation.setText("");
                Fetch();
                LoadProductNo();
            } else {
                JOptionPane.showMessageDialog(this, "Aset Gagal Ditambahkan!");
            }

        } catch (SQLException ex) {
            Logger.getLogger(asetForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtAddActionPerformed

    private void txtUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUpdateActionPerformed
        try {
            String aname = txtAname.getText();
            String description = txtDescription.getText();
            String type = txtType.getText();
            String status = txtStatus.getSelectedItem().toString();
            String location = txtLocation.getText();
            String asetId = txtAsetID.getSelectedItem().toString();

            pst = conn.prepareStatement("UPDATE tbl_aset SET nama_aset=?, deskripsi_aset=?,jenis_aset=?,status=?,lokasi=? WHERE id_aset = ?");

            pst.setString(1, aname);
            pst.setString(2, description);
            pst.setString(3, type);
            pst.setString(4, status);
            pst.setString(5, location);
            pst.setString(6, asetId);

            int k = pst.executeUpdate();

            if (k == 1) {
                JOptionPane.showMessageDialog(this, "Aset Sukes Diupdate!");
                txtAname.setText("");
                txtDescription.setText("");
                txtType.setText("");
                txtStatus.setSelectedItem("Baik");
                txtLocation.setText("");
                txtAname.requestFocus();
                Fetch();
                LoadProductNo();
            } else {
                JOptionPane.showMessageDialog(this, "Aset Gagal Diupdate!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(asetForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtUpdateActionPerformed

    private void txtDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDeleteActionPerformed
        try {
            String asetId = txtAsetID.getSelectedItem().toString();

            pst = conn.prepareStatement("DELETE FROM tbl_aset WHERE id_aset = ?");
            pst.setString(1, asetId);

            int k = pst.executeUpdate();
            if (k == 1) {
                JOptionPane.showMessageDialog(this, "Aset Sukes Dihapus!");
                txtAname.setText("");
                txtDescription.setText("");
                txtType.setText("");
                txtStatus.setSelectedItem("Baik");
                txtLocation.setText("");
                txtAname.requestFocus();
                Fetch();
                LoadProductNo();
            } else {
                JOptionPane.showMessageDialog(this, "Aset Gagal Dihapus!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(asetForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtDeleteActionPerformed

    private void txtCsvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCsvActionPerformed
        String filename = "E:\\ExportedJava.csv";
        
        try {
            FileWriter fw = new FileWriter(filename);
            try {
                pst = conn.prepareStatement("SELECT * FROM tbl_aset");
            } catch (SQLException ex) {
                Logger.getLogger(asetForm.class.getName()).log(Level.SEVERE, null, ex);
            }
            rs = pst.executeQuery();
            
            while(rs.next()){
                fw.append(rs.getString(1));
                fw.append(',');
                fw.append(rs.getString(2));
                fw.append(',');
                fw.append(rs.getString(3));
                fw.append(',');
                fw.append(rs.getString(4));
                fw.append(',');
                fw.append(rs.getString(5));
                fw.append(',');
                fw.append(rs.getString(6));
                fw.append('\n');
            }
            JOptionPane.showMessageDialog(this, "Aset berhasil di export ke CSV");
            fw.flush();
            fw.close();
        } catch (IOException | SQLException ex) {
            Logger.getLogger(asetForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtCsvActionPerformed

    private void txtAsetIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAsetIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAsetIDActionPerformed

    private void txtSearchIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchIDActionPerformed
        try {
            String asetId = txtAsetID.getSelectedItem().toString();

            pst = conn.prepareStatement("SELECT * FROM tbl_aset WHERE id_aset = ?");
            pst.setString(1, asetId);
            rs = pst.executeQuery();

            if (rs.next() == true) {
                txtAname.setText(rs.getString(2));
                txtDescription.setText(rs.getString(3));
                txtType.setText(rs.getString(4));
                txtStatus.setSelectedItem(rs.getString(5));
                txtLocation.setText(rs.getString(6));
            } else {
                JOptionPane.showMessageDialog(this, "Aset Gagal Ditemukan!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(asetForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtSearchIDActionPerformed

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
            java.util.logging.Logger.getLogger(asetForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(asetForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(asetForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(asetForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new asetForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable;
    private javax.swing.JButton txtAdd;
    private javax.swing.JTextField txtAname;
    private javax.swing.JComboBox<String> txtAsetID;
    private javax.swing.JButton txtCsv;
    private javax.swing.JButton txtDelete;
    private javax.swing.JTextArea txtDescription;
    private javax.swing.JTextField txtLocation;
    private javax.swing.JButton txtSearchID;
    private javax.swing.JComboBox<String> txtStatus;
    private javax.swing.JTextField txtType;
    private javax.swing.JButton txtUpdate;
    // End of variables declaration//GEN-END:variables
}
