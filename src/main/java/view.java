/* Window four: View
- Displays the user's data which is read from a file.  
- view window includes:
image of the program, background color, 2jButtons, jMenu (+ jMenuBar + 
jMenuItem) to exit the program.  
*/
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class view extends JFrame {

    private JButton jButton1;
    private JButton jButton2;
    private JLabel jLabel5;
    private JPanel jPanel1;
    private JScrollPane jScrollPane2;
    private JTable jTable2;
    private JLabel jLabel1;
    private JMenu jMenu1;
    private JMenuBar jMenuBar1;
    private JMenuItem jMenuItem1;
    
    
    /**
     * Creates new form view
     */
    public view() {
        Components();
    }


    private void Components() {

        jPanel1 = new JPanel();
        jLabel5 = new JLabel();
        jScrollPane2 = new JScrollPane();
        jTable2 = new JTable();
        jButton1 = new JButton();
        jButton2 = new JButton();
        jLabel1 = new JLabel();
        jMenuBar1 = new JMenuBar();
        jMenu1 = new JMenu();
        jMenuItem1 = new JMenuItem();
        


        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new Color(250, 242, 224));
        jPanel1.setLayout(null);


        jLabel1.setIcon(new ImageIcon("/Users/joud/Downloads/aaaass.png"));
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 480, 370);
        
        jTable2.setModel(new DefaultTableModel(
            ));
        jScrollPane2.setViewportView(jTable2);

        
        jButton1.setText("View Your Subscriptions Here :");
        jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                try {
                    jButton1ActionPerformed(evt);
                } catch (IOException ex) {
                    Logger.getLogger(view.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        jButton2.setText("Back to main menu");
        jButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(620, 320, 164, 29);

        
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


        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel5, GroupLayout.PREFERRED_SIZE, 460, GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(143, 143, 143)
                        .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 209, GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                .addGap(35, 35, 35))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5, GroupLayout.PREFERRED_SIZE, 380, GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(80, Short.MAX_VALUE))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, 950, GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, 372, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }                      

    private void jButton1ActionPerformed(ActionEvent evt) throws IOException {                                         
        
        try {
            File file= new File("SubsTracker.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));
            String firstLine = br.readLine().trim();
            String[] columnsName = firstLine.split("");
            DefaultTableModel model = (DefaultTableModel)jTable2.getModel();
            model.setColumnIdentifiers(columnsName);
            Object[] tableLines = br.lines().toArray();
            for(int i = 0; i < tableLines.length; i++){
                
                String line = tableLines[i].toString().trim();
                String[] dataRow = line.split("/t");
                model.addRow(dataRow);
            }

            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(view.class.getName()).log(Level.SEVERE, null, ex);
        }
    }               
    

    
    private void jButton2ActionPerformed(ActionEvent evt) {                                         
        main m = new main();
        m.show();
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
                new view().setVisible(true);
            }
        });
    }

}
