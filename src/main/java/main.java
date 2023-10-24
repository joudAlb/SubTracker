/* Window one: Main
- Displays a welcome page to the substracker program and contains a start button
to switch to the next window.  
- main window includes:
image of the program, background color, text with different sizes & fonts, 
jButton, jMenu (+ jMenuBar + jMenuItem) to either exit program or display 
information about the program.  
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class main extends JFrame {

    private JButton jButton1;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JMenu jMenu3;
    private JMenu jMenu4;
    private JMenu jMenu7;
    private JMenuBar jMenuBar1;
    private JMenuItem jMenuItem1;
    private JMenuItem jMenuItem6;
    private JPanel jPanel1;
    
    
    public main() {
        Components();
    }
                        
    private void Components() {

        jPanel1 = new JPanel();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        jButton1 = new JButton();
        jLabel4 = new JLabel();
        jMenuBar1 = new JMenuBar();
        jMenu3 = new JMenu();
        jMenuItem1 = new JMenuItem();
        jMenu4 = new JMenu();
        jMenu7 = new JMenu();
        jMenuItem6 = new JMenuItem();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBackground(new Color(250, 242, 224));

        jPanel1.setBackground(new Color(250, 242, 224));
        jPanel1.setLayout(null);

        jLabel1.setIcon(new ImageIcon("/Users/joud/Downloads/aaaass.png"));
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 480, 370);

        jLabel2.setFont(new Font("Lucida Grande", 0, 24));
        jLabel2.setText("WELCOME TO");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(550, 60, 159, 30);

        jLabel3.setFont(new Font("Arial Black", 1, 36)); 
        jLabel3.setText("SUBS TRACKER!");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(470, 110, 328, 52);

        jButton1.setText("Start Program");
        jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
            });
        
        jPanel1.add(jButton1);
        jButton1.setBounds(560, 260, 129, 40);

        jLabel4.setText("organize all of your subscriptions at one place");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(490, 160, 292, 16);

        jMenu3.setText("File");

        jMenuItem1.setText("Exit program");
        jMenuItem1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        
        jMenu3.add(jMenuItem1);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("About");

        jMenu7.setText("About Us");

        jMenuItem6.setText("This program helps you keep track of your subscriptions, bills & due dates");

        
        jMenu7.add(jMenuItem6);

        jMenu4.add(jMenu7);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
            .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, 808, Short.MAX_VALUE))

        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, 372, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }                  

        private void jButton1ActionPerformed(ActionEvent evt) {                                         
            options op = new options();
            op.show();
            dispose();
        }
        
    public static void main(String args[]) {

        EventQueue.invokeLater(
                new Runnable() {
                    public void run() {
                        new main().setVisible(true);
            }
        });
    }
    
    private void jMenuItem1ActionPerformed(ActionEvent evt) {                                           
        System.exit(0);
    }
                                              
}
