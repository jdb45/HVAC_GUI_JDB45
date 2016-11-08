import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class ResolveGUI extends JFrame {


    private JPanel rootPanel;
    private JTextField reasonResolved;
    private JTextField totalFee;
    private JButton closeButton;

  public ResolveGUI(HVACGUI hvacForm) {

        setContentPane(rootPanel);
        setPreferredSize(new Dimension(300, 300));
        pack();
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        hvacForm.setEnabled(false);
        close();
        hvacForm.setEnabled(true);

  }
    //creating a close method
    public void close(){
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    //getting the variables from the user input
                    String entry = reasonResolved.getText();
                    //parsing the total fee to a double
                    double charge = Double.parseDouble(totalFee.getText());
                    Date date = new Date();
                    //creating the object to store the selection from the list
                    Object userSelect = HVACGUI.selectionService;
                    //removing the selected item from the arraylist
                    HVACGUI.newCentralAC.remove(userSelect);
                    //removing the element from the defaul list model
                    HVACGUI.openService.removeElement(userSelect);
                    //adding the format for the resolved list to be displayed
                    ResolvedList.showResolved.addElement(userSelect + " Resolution: " +
                            entry + " Date: " + date + " Total Charged: $" + charge + "\n");

                    ResolveGUI.this.dispose();

                }catch (NumberFormatException ne){
                    JOptionPane.showMessageDialog(rootPanel, "Please enter a number in the Total Fee");
                }
            }

        });

       }
    }

