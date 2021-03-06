/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caware;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author 12p10
 */
public class InfoPanel extends javax.swing.JPanel {

    private String edu;
    private String name;
    private String age;
    private String mf;
    private DBHandler dbHandler;
    private String[] responses;
    private JInternalFrame parentFrame;
    private JInternalFrame nextFrame;

    /**
     * Creates new form InfoPanel
     */
    public InfoPanel() {

        initComponents();
        responses = new String[4];

    }

    public void setParent(JInternalFrame parent_Frame) {

        parentFrame = parent_Frame;

    }

    public void setNextFrame(JInternalFrame next_Frame) {

        nextFrame = next_Frame;

    }

    public void setDB(DBHandler db) {

        dbHandler = db;
        System.out.println("db set");
    }

    private void populateArray() {

        responses[0] = age;
        responses[1] = mf;
        responses[2] = edu;
        responses[3] = name;

    }

    private void fetchDetails() {

        name = txtName.getText();
        age = txtAge.getText();

        if (rbMale.isSelected()) {
            mf = "male";
        } else if (rbFemale.isSelected()) {
            mf = "female";
        }

        switch (cbEducation.getSelectedIndex()) {

            case 1:
                edu = "No Formal Education";
                break;

            case 2:
                edu = "Primary";
                break;

            case 3:
                edu = "Middle";
                break;

            case 4:
                edu = "Secondary";
                break;

            case 5:
                edu = "Higher Secondary";
                break;

            case 6:
                edu = "Graduation";
                break;

        }

    }

    private boolean isValidated() {

        name = txtName.getText();
        age = txtAge.getText();

        if (name.equals("")) {
            return false;
        }
        if (age.equals("")) {
            return false;
        }
        if (!(rbMale.isSelected() || rbFemale.isSelected())) {
            return false;
        }
        if (cbEducation.getSelectedIndex() < 1) {
            return false;
        }

        return true;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        btnNext = new javax.swing.JButton();
        rbFemale = new javax.swing.JRadioButton();
        rbMale = new javax.swing.JRadioButton();
        lblName = new javax.swing.JLabel();
        lblAge = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        cbEducation = new javax.swing.JComboBox();
        txtAge = new javax.swing.JTextField();

        setBackground(new java.awt.Color(204, 204, 204));
        setMinimumSize(new java.awt.Dimension(100, 200));

        btnNext.setBackground(new java.awt.Color(0, 102, 51));
        btnNext.setFont(new java.awt.Font("Segoe UI Semibold", 0, 11)); // NOI18N
        btnNext.setForeground(new java.awt.Color(255, 255, 255));
        btnNext.setText("Next");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        rbFemale.setFont(new java.awt.Font("Segoe UI Semibold", 0, 11)); // NOI18N
        rbFemale.setText("Female");

        rbMale.setFont(new java.awt.Font("Segoe UI Semibold", 0, 11)); // NOI18N
        rbMale.setText("Male");

        lblName.setFont(new java.awt.Font("Segoe UI Semibold", 0, 11)); // NOI18N
        lblName.setText("Name");

        lblAge.setFont(new java.awt.Font("Segoe UI Semibold", 0, 11)); // NOI18N
        lblAge.setText("Age");

        txtName.setFont(new java.awt.Font("Segoe UI Semibold", 0, 11)); // NOI18N

        cbEducation.setFont(new java.awt.Font("Segoe UI Semibold", 0, 11)); // NOI18N
        cbEducation.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--Educational Status--", "No Formal Education", "Primary", "Middle", "Secondary", "Higher Secondary", "Graduation" }));
        cbEducation.setName(""); // NOI18N

        txtAge.setFont(new java.awt.Font("Segoe UI Semibold", 0, 11)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(rbMale)
                                .addGap(18, 18, 18)
                                .addComponent(rbFemale))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(68, 68, 68)
                                .addComponent(btnNext))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblName)
                                    .addComponent(lblAge))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtName, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                                    .addComponent(txtAge))))
                        .addGap(0, 12, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(cbEducation, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblName)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAge)
                    .addComponent(txtAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbMale)
                    .addComponent(rbFemale))
                .addGap(18, 18, 18)
                .addComponent(cbEducation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addComponent(btnNext)
                .addContainerGap(26, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed

        if (!isValidated()) {
            JOptionPane.showMessageDialog(null,
                    "You have not entered the information correctly. Please try again!");
        } else {
            fetchDetails();
            populateArray();
            dbHandler.addInfoResponse(responses);
            nextFrame.setVisible(true);
            parentFrame.doDefaultCloseAction();
        }
    }//GEN-LAST:event_btnNextActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNext;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox cbEducation;
    private javax.swing.JLabel lblAge;
    private javax.swing.JLabel lblName;
    private javax.swing.JRadioButton rbFemale;
    private javax.swing.JRadioButton rbMale;
    private javax.swing.JTextField txtAge;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables
}
