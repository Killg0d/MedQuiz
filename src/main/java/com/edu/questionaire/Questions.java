package com.edu.questionaire;
import java.awt.Image;
import java.util.List;
import javax.swing.ButtonModel;
import javax.swing.ImageIcon;
/**
 * JFrame for displaying and handling quiz questions.
 * Author: Tarun
 */
public class Questions extends javax.swing.JFrame {
    // Image for the JFrame icon
    Image img = (new ImageIcon(getClass().getResource("/resources/icons/med_icon225x225.jpeg"))).getImage();
    // List to hold the questions
    List<Question> qlist = new QuestionManager().getQuestions();
    // Index of the current question being displayed
    int currIndex = 0;
    // Array to store user answers
    Integer ans[] = new Integer[5];
    // Array to store correct options
    Integer copt[] = new Integer[5];
    // Static variable to store marks
    private static int marks = 0;
    // Constructor
    public Questions() {
        initComponents();
        showQuestion();
    }
    // Method to display the current question
    private void showQuestion() {

        Question qt = qlist.get(currIndex);
        String qn = " " + (currIndex + 1) + ")" + qt.getQuestion();
        q.setText(qn);
        opa.setText("Option A: " + qt.getOpa());
        opb.setText("Option B: " + qt.getOpb());
        opc.setText("Option C: " + qt.getOpc());
        Qpanel.add(q);
        Qpanel.add(opa);
        Qpanel.add(opb);
        Qpanel.add(opc);
        copt[currIndex] = qt.getCop();
        radiogrp.clearSelection();
        nextBtn.setEnabled(false);
        if (currIndex == 4) {
            nextBtn.setText("Submit");
        }
    }
    // Method to enable the Next button
    private void enableNext() {
        nextBtn.setEnabled(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        radiogrp = new javax.swing.ButtonGroup();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        Qpanel = new javax.swing.JPanel();
        q = new javax.swing.JLabel();
        opa = new javax.swing.JRadioButton();
        opb = new javax.swing.JRadioButton();
        opc = new javax.swing.JRadioButton();
        nextBtn = new javax.swing.JButton();
        image = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setIconImage(img);

        jLayeredPane1.setBackground(new java.awt.Color(255, 255, 255));
        jLayeredPane1.setOpaque(true);

        Qpanel.setBackground(new java.awt.Color(204, 204, 255));
        Qpanel.setToolTipText("");
        Qpanel.setLayout(null);

        q.setBackground(new java.awt.Color(0, 153, 153));
        q.setForeground(new java.awt.Color(255, 255, 255));
        q.setText("Label");
        q.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        q.setMaximumSize(new java.awt.Dimension(100, 42));
        q.setOpaque(true);
        Qpanel.add(q);
        q.setBounds(40, 20, 960, 16);
        q.getAccessibleContext().setAccessibleName("q");

        radiogrp.add(opa);
        opa.setActionCommand("0");
        opa.setLabel("opa");
        opa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opaActionPerformed(evt);
            }
        });
        Qpanel.add(opa);
        opa.setBounds(70, 40, 960, 21);

        radiogrp.add(opb);
        opb.setText("jRadioButton2");
        opb.setActionCommand("1");
        opb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opbActionPerformed(evt);
            }
        });
        Qpanel.add(opb);
        opb.setBounds(70, 70, 960, 21);
        opb.getAccessibleContext().setAccessibleName("opb");

        radiogrp.add(opc);
        opc.setText("jRadioButton3");
        opc.setActionCommand("2");
        opc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcActionPerformed(evt);
            }
        });
        Qpanel.add(opc);
        opc.setBounds(70, 100, 960, 21);
        opc.getAccessibleContext().setAccessibleName("opc");

        nextBtn.setText("Next");
        nextBtn.setEnabled(false);
        nextBtn.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        nextBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextBtnActionPerformed(evt);
            }
        });
        Qpanel.add(nextBtn);
        nextBtn.setBounds(40, 140, 72, 23);

        jLayeredPane1.add(Qpanel);
        Qpanel.setBounds(0, 250, 1040, 260);

        image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/medical_bg1200x500.jpg"))); // NOI18N
        image.setIconTextGap(0);
        jLayeredPane1.add(image);
        image.setBounds(0, 0, 1040, 250);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1038, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 509, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void opaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opaActionPerformed
        enableNext();
    }//GEN-LAST:event_opaActionPerformed

    private void opbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opbActionPerformed
        enableNext();
    }//GEN-LAST:event_opbActionPerformed

    private void opcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcActionPerformed
        enableNext();
    }//GEN-LAST:event_opcActionPerformed
    // Method to calculate marks
    private void calculateMarks() {
        for (int i = 0; i < 5; i++) {
            if (copt[i].equals(ans[i])) {
                marks++;
            }
        }
    }
    // Getter for marks
    public static int getMarks() {
        return marks;
    }
    
    // Event handler for Next button
    private void nextBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextBtnActionPerformed
        System.out.println("Index:" + currIndex);
        ButtonModel selectedModel = radiogrp.getSelection();
        Integer selectedText = Integer.valueOf(selectedModel.getActionCommand());
        ans[currIndex] = selectedText;
        if (currIndex == 4) {
            for (Integer s : ans) {
                System.out.println("Ans:" + s);
            }
            for (Integer c : copt) {
                System.out.println("C:" + c);
            }
            calculateMarks();
            System.out.println("Marks:" + marks);
            showGrade();
        }
        if (currIndex < 4) {
            currIndex++;
            showQuestion();
        }
    }//GEN-LAST:event_nextBtnActionPerformed
    // Method to display grade
    private void showGrade() {
        setVisible(false);
        Result.main(new String[]{});
    }

    // Main method to run the application
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Questions().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Qpanel;
    private javax.swing.JLabel image;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JButton nextBtn;
    private javax.swing.JRadioButton opa;
    private javax.swing.JRadioButton opb;
    private javax.swing.JRadioButton opc;
    private javax.swing.JLabel q;
    private javax.swing.ButtonGroup radiogrp;
    // End of variables declaration//GEN-END:variables
}
