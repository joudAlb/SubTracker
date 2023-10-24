/* Window two: Options
- Displays the options page to the substracker program and contains multiple 
jRadioButtons to switch to the third/fourth window.  
- options window includes:
image of the program, background color, text with different sizes & fonts, 
2 jRadioButtons, jMenu (+ jMenuBar + jMenuItem) to exit the program.  
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class options extends javax.swing.JFrame {
    private ButtonGroup buttonGroup1;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JMenu jMenu1;
    private JMenuBar jMenuBar1;
    private JMenuItem jMenuItem1;
    private JPanel jPanel1;
    private JRadioButton jRadioButton1;
    private JRadioButton jRadioButton2;
    
    /**
     * Creates new form NewJFrame
     */
    public options() {
        Components();
    }

    private void Components() {

        buttonGroup1 = new ButtonGroup();
        jPanel1 = new JPanel();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jRadioButton1 = new JRadioButton();
        jRadioButton2 = new JRadioButton();
        jMenuBar1 = new JMenuBar();
        jMenu1 = new JMenu();
        jMenuItem1 = new JMenuItem();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBackground(new Color(250, 242, 224));

        jPanel1.setBackground(new Color(250, 242, 224));
        jPanel1.setLayout(null);

        jLabel1.setIcon(new ImageIcon("/Users/joud/Downloads/aaaass.png")); 
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 470, 370);

        jLabel2.setFont(new Font("Arial Black", 1, 24)); 
        jLabel2.setText("Options Menu:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(550, 60, 210, 40);

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setFont(new Font("Arial", 0, 18)); 
        jRadioButton1.setText("Add new subscription");
        jRadioButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });       
        jPanel1.add(jRadioButton1);
        jRadioButton1.setBounds(530, 160, 220, 30);

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setFont(new Font("Arial", 0, 18)); 
        jRadioButton2.setText("View my bills");
        jRadioButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });        
        jPanel1.add(jRadioButton2);
        jRadioButton2.setBounds(530, 200, 160, 30);

        jMenu1.setText("File");

        jMenuItem1.setText("Exit program");
        jMenuItem1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, 808, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, 372, Short.MAX_VALUE)
        );

        pack();
    }                       

    private void jRadioButton1ActionPerformed(ActionEvent evt) {                                              
            add op = new add();
            op.show();
            dispose();
        
    }  
    
        private void jRadioButton2ActionPerformed(ActionEvent evt) {                                              
            view op = new view();
            op.show();
            dispose();
    }                                             


    private void jMenuItem1ActionPerformed(ActionEvent evt) {                                           
            System.exit(0);
    }                                          

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        /* Create and display the form */
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new options().setVisible(true);
            }
        });
    }
}
