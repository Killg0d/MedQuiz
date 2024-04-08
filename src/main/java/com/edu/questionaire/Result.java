
package com.edu.questionaire;

public class Result extends javax.swing.JFrame {

    
    // Creates new form Result
     
    private void displayscore() {
        score.setText("Score:" + Questions.getMarks() + "/5");
        System.out.println(Questions.getMarks());
        saveScore();
    }

    public void saveScore() {
        AuthenticationManager mgr = new AuthenticationManager();
        if (mgr.UpdateScore(Questions.getMarks())) {
            System.out.println("Sucessful");
        }
        else
        {
            System.out.println("Unsucessful");
        }
    }

    public Result() {
        initComponents();
        displayscore();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        score = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(new Questions().img);

        jLayeredPane1.setBackground(new java.awt.Color(255, 255, 255));
        jLayeredPane1.setOpaque(true);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setText("Your Answers have been Submitted!");
        jLayeredPane1.add(jLabel1);
        jLabel1.setBounds(40, 210, 850, 146);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/edu/resources/tick_mark.jpg"))); // NOI18N
        jLayeredPane1.add(jLabel2);
        jLabel2.setBounds(10, 10, 360, 260);

        score.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        score.setText("Score");
        jLayeredPane1.add(score);
        score.setBounds(440, 100, 320, 70);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 922, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 443, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Result().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLabel score;
    // End of variables declaration//GEN-END:variables
}
