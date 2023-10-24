/* Window three: Add
- Displays the add page to the substracker program and takes input from the user
to add to the file/fourth window.  
- add window includes:
image of the program, background color, text with different sizes & fonts, 
3 labels & text fileds, 3 jRadioButtons, 2jButtons jMenu (+ jMenuBar + 
jMenuItem) to exit the program.  
*/

import java.io.FileWriter;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class add extends JFrame {

    /**
     * Creates new form add
     */
    public add() {
        initComponents(); 
    }


    private void initComponents() {

        buttonGroup1 = new ButtonGroup();
        jPanel1 = new JPanel();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        jTextField1 = new JTextField();
        jLabel4 = new JLabel();
        jTextField2 = new JTextField();
        jLabel5 = new JLabel();
        jTextField3 = new JTextField();
        jLabel6 = new JLabel();
        jButton1 = new JButton();
        jButton2 = new JButton();
        jRadioButton1 = new JRadioButton();
        jRadioButton2 = new JRadioButton();
        jRadioButton3 = new JRadioButton();
        jMenuBar1 = new JMenuBar();
        jMenu1 = new JMenu();
        jMenuItem1 = new JMenuItem();


        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new Color(250, 242, 224));
        jPanel1.setLayout(null);

        jLabel1.setIcon(new ImageIcon("/Users/joud/Downloads/aaaass.png")); 
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 480, 370);

        jLabel2.setFont(new Font("Arial Black", 1, 20)); 
        jLabel2.setText("Add your subscriptions here:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(480, 30, 320, 40);

        jLabel3.setText("Company name:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(500, 120, 110, 16);

       
        jPanel1.add(jTextField1);
        jTextField1.setBounds(620, 120, 170, 26);

        jLabel4.setText("Amount of money:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(500, 150, 130, 16);


        jPanel1.add(jTextField2);
        jTextField2.setBounds(620, 150, 170, 26);

        jLabel5.setText("Your subscription will be:");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(500, 240, 170, 10);


        jPanel1.add(jTextField3);
        jTextField3.setBounds(620, 180, 170, 26);

        jLabel6.setText("Starting date:");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(500, 180, 110, 16);

        jButton1.setText("Add subscription");
        jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(620, 290, 160, 29);

        jButton2.setText("Back to main menu");
        jButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(620, 320, 164, 29);

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("Weekly");
           jRadioButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                try {
                    jRadioButton1ActionPerformed(evt);
                } catch (Exception ex) {
                    Logger.getLogger(add.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        jPanel1.add(jRadioButton1);
        jRadioButton1.setBounds(510, 280, 76, 23);

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("Monthly");
           jRadioButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                try {
                    jRadioButton2ActionPerformed(evt);
                } catch (Exception ex) {
                    Logger.getLogger(add.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        jPanel1.add(jRadioButton2);
        jRadioButton2.setBounds(510, 310, 83, 23);

        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setText("Yearly");
           jRadioButton3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                try {
                    jRadioButton3ActionPerformed(evt);
                } catch (Exception ex) {
                    Logger.getLogger(add.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        jPanel1.add(jRadioButton3);
        jRadioButton3.setBounds(510, 340, 70, 23);

        
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
            .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, 816, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, 392, Short.MAX_VALUE)
        );

        pack();
    }                      


    private void jButton1ActionPerformed(ActionEvent evt) {                                         
        String CoName = jTextField1.getText();
        String amount = jTextField2.getText();
        String date = jTextField3.getText();
        String Chosen = null;
        
        if(jRadioButton1.isSelected()){
           Chosen = "weekly";
        }
        else if(jRadioButton2.isSelected()){
           Chosen = "monthly";
        }        
        else if(jRadioButton3.isSelected()){
           Chosen = "yearly";
        }
                 
        try{
            FileWriter Writer = new FileWriter("substracker.txt", true);
            Writer.write("\nCompany name: "+CoName+"\tAmount of money: "+amount+"\t  Date: "+date+"\tSubscription type: "+Chosen);
            Writer.write(System.getProperty("line.separator"));
            Writer.close();
            JOptionPane.showMessageDialog(null, "Success");
            setVisible(false);
            new add().setVisible(true);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "error");
        }
    }                                        
    //display main window when "back to main menu" button is clicked
    private void jButton2ActionPerformed(ActionEvent evt) {                                         
        main m = new main();
        m.show();
        dispose();
    }                                        

    private void jMenuItem1ActionPerformed(ActionEvent evt) {                                           
        System.exit(0);
    }                          
      private void jRadioButton1ActionPerformed(ActionEvent evt) throws Exception {                                              

        inputValidation();
    }                                             

    private void jRadioButton2ActionPerformed(ActionEvent evt) throws Exception {                                              

        inputValidation();
    }                                             

    private void jRadioButton3ActionPerformed(ActionEvent evt) throws Exception {                                              

        inputValidation();
    }        
 private boolean CompanyName() {

        return jTextField1.getText().matches("([a-zA-Z]+|[a-zA-Z]+\\s[a-zA-Z]+)");
    }

    private boolean amount() {
       

       return jTextField2.getText().matches("[0-9]{2}.[0-9]{2}");

    }

    private boolean date() {

        return jTextField3.getText().matches(("[0-9]{2}[/]{1}[0-9]{2}[/]{1}[0-9]{4}"));
    }

   
     private void inputValidation() throws Exception {

        //First: check that all fields are valid
        if (!CompanyName()) {
            //only letters
            JOptionPane.showMessageDialog(null, "Invalid Name !", "Error", JOptionPane.ERROR_MESSAGE);
            throw new Exception();
        }
       if (!amount()) {
            //only numbers
            JOptionPane.showMessageDialog(null, "Invalid amount of money !", "Error", JOptionPane.ERROR_MESSAGE);
            throw new Exception();
        }
        
        if (!date()) {
            //correct date form
            JOptionPane.showMessageDialog(null, "Invalid date !", "Error", JOptionPane.ERROR_MESSAGE);
            throw new Exception();
        }
               
}
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new add().setVisible(true);
            }
        });
    }

    private ButtonGroup buttonGroup1;
    private JButton jButton1;
    private JButton jButton2;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JPanel jPanel1;
    private JRadioButton jRadioButton1;
    private JRadioButton jRadioButton2;
    private JRadioButton jRadioButton3;
    private JTextField jTextField1;
    private JTextField jTextField2;
    private JTextField jTextField3;
    private JMenu jMenu1;
    private JMenuBar jMenuBar1;
    private JMenuItem jMenuItem1;
}