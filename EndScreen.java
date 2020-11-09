import java.awt.*;
import javax.swing.*;
public class EndScreen extends JFrame {
    static String result;
    static int userscore;
    public EndScreen() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    public static void GameWon(int score){
        String name,names;
        name = JOptionPane.showInputDialog("You have beaten the high score! Please enter your name: ");
        names = name;
        GameScreen gameScreen = new GameScreen();
        gameScreen.HighScore(names);
        result = "Congratulations! You beat the high score!";
        userscore = score;
    }
    public static void GameLost(int score){
        result = "Oh, no! You weren't able to beat the high score. Keep trying!";
        userscore = score;
        }
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        lblYourScore = new javax.swing.JLabel();
        txtMessage = new javax.swing.JTextField();
        txtYourScore = new javax.swing.JTextField();
        btnExit = new javax.swing.JButton();
        btnPlayAgain = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(null);

        jLabel3.setFont(new java.awt.Font("Helvetica Neue", 0, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("GAME OVER");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(150, 10, 210, 50);

        lblYourScore.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        lblYourScore.setForeground(new java.awt.Color(255, 255, 255));
        lblYourScore.setText("Your Score:");
        jPanel1.add(lblYourScore);
        lblYourScore.setBounds(110, 90, 110, 50);

        txtMessage.setText(String.valueOf(result));
        txtMessage.setEditable(false);
        jPanel1.add(txtMessage);
        txtMessage.setBounds(40, 170, 420, 26);

        txtYourScore.setText(String.valueOf(userscore));
        txtYourScore.setEditable(false);
        jPanel1.add(txtYourScore);
        txtYourScore.setBounds(190, 100, 120, 26);

        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        jPanel1.add(btnExit);
        btnExit.setBounds(310, 230, 75, 29);

        btnPlayAgain.setText("Play Again");
        btnPlayAgain.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlayAgainActionPerformed(evt);
            }
        });
        jPanel1.add(btnPlayAgain);
        btnPlayAgain.setBounds(100, 230, 97, 29);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("./Assets/Images/background.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0,0, 500, 370);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)
        );
        
        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPlayAgainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlayAgainActionPerformed
        // TODO add your handling code here:
        GameScreen gameScreen = new GameScreen();
        gameScreen.main(new String[0]);
        dispose();
    }//GEN-LAST:event_btnPlayAgainActionPerformed
    

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btnExitActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String[]args) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new EndScreen();
                frame.setResizable(false);
                frame.setSize(500,300);
                frame.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnPlayAgain;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblYourScore;
    private javax.swing.JTextField txtMessage;
    private javax.swing.JTextField txtYourScore;
    // End of variables declaration//GEN-END:variables
}
