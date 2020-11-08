import java.awt.*;
import javax.swing.*;
public class startScreen extends javax.swing.JFrame {

    public startScreen() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        instruct = new javax.swing.JLabel();
        goal = new javax.swing.JLabel();
        match = new javax.swing.JLabel();
        points = new javax.swing.JLabel();
        notMatched = new javax.swing.JLabel();
        health = new javax.swing.JLabel();
        gameOver = new javax.swing.JLabel();
        btnPlay = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        imageBack = new javax.swing.JLabel();
        ImageIcon back = new ImageIcon("p.png");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(null);

        title.setFont(new java.awt.Font("Helvetica Neue", 0, 36)); // NOI18N
        title.setForeground(new java.awt.Color(255, 255, 255));
        title.setText("Homebase Defence");
        jPanel1.add(title);
        title.setBounds(210, 0, 350, 70);

        instruct.setFont(new java.awt.Font("Helvetica Neue", 0, 26)); // NOI18N
        instruct.setForeground(new java.awt.Color(255, 255, 255));
        instruct.setText("How to Play?");
        jPanel1.add(instruct);
        instruct.setBounds(20, 70, 160, 30);

        goal.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        goal.setForeground(new java.awt.Color(255, 255, 255));
        goal.setText("* The goal of the game is to destroy as many asteroids as possible to defend your Homebase!");
        jPanel1.add(goal);
        goal.setBounds(20, 120, 670, 20);

        match.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        match.setForeground(new java.awt.Color(255, 255, 255));
        match.setText("* Match the pattern at the bottom of the screen to destory an asteroid.");
        jPanel1.add(match);
        match.setBounds(20, 130, 670, 60);

        points.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        points.setForeground(new java.awt.Color(255, 255, 255));
        points.setText("* Each broken asteroid is worth 5 points. In the next round, each asteroid destroyed is worth 5 more points.");
        jPanel1.add(points);
        points.setBounds(20, 160, 700, 60);

        notMatched.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        notMatched.setForeground(new java.awt.Color(255, 255, 255));
        notMatched.setText("* If you fail to match the pattern, asteroids move one step closer to your Homebase.");
        jPanel1.add(notMatched);
        notMatched.setBounds(20, 190, 670, 60);

        health.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        health.setForeground(new java.awt.Color(255, 255, 255));
        health.setText("* Each time an asteroid hits your Homebase, you will lose health.");
        jPanel1.add(health);
        health.setBounds(20, 220, 670, 60);

        gameOver.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        gameOver.setForeground(new java.awt.Color(255, 255, 255));
        gameOver.setText("* If you have no health remaining, the game is over.");
        jPanel1.add(gameOver);
        gameOver.setBounds(20, 250, 670, 60);

        btnPlay.setText("Play Game");
        jPanel1.add(btnPlay);
        btnPlay.setBounds(480, 330, 97, 29);

        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        jPanel1.add(btnExit);
        btnExit.setBounds(580, 330, 97, 29);

        imageBack.setIcon(back); // NOI18N
        jPanel1.add(imageBack);
        imageBack.setBounds(0, -10, 720, 400);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 738, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 377, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>                        

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {                                        
        System.exit(0);
    }    
    private void btnPlayActionPerformed(java.awt.event.ActionEvent evt) {                                        
        HomebaseDefence play = new HomebaseDefence();
    }                                    

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
            java.util.logging.Logger.getLogger(startScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(startScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(startScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(startScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new startScreen().setVisible(true);
            }
        });
    }
                  
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnPlay;
    private javax.swing.JLabel gameOver;
    private javax.swing.JLabel goal;
    private javax.swing.JLabel health;
    private javax.swing.JLabel imageBack;
    private javax.swing.JLabel instruct;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel match;
    private javax.swing.JLabel notMatched;
    private javax.swing.JLabel points;
    private javax.swing.JLabel title;
    // End of variables declaration                   
}

