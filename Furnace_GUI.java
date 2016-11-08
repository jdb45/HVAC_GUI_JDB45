import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Furnace_GUI extends JFrame {
    private JPanel rootPanel;
    private JButton addToCurrentListButton;
    private JComboBox selectType;
    private JTextField enterIssie;
    private JTextField enterAddress;

    //calling the HVACGUI to be able to check which form the user can work on
    public Furnace_GUI(HVACGUI hvacForm) {

        setContentPane(rootPanel);
        setPreferredSize(new Dimension(500, 500));
        pack();
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //adding items to the combo box
        selectType.addItem("Forced Air");
        selectType.addItem("Boiler/Radiators");
        selectType.addItem("Gravity Feed (the older 'octopus' style)");
        //setting the hvac form to false so its not the active form
        hvacForm.setEnabled(false);
        addToList();
        //making the hvac gui form active
        hvacForm.setEnabled(true);
    }

    //add tickets to the list
    public void addToList() {
        addToCurrentListButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //getting the variables from the user input
                String address = enterAddress.getText();
                String issue = enterAddress.getText();
                //getting the input from the combo box
                String type = (String) selectType.getSelectedItem();

                Date date = new Date();
                //adding items to the Arraylist
                Furnace furnaceEntry = new Furnace(address, issue, date, type);
                //adding items to the Arraylist
                HVACGUI.newCentralAC.add(furnaceEntry);
                //adding items to the default list model
                HVACGUI.openService.addElement(furnaceEntry);
                //disposing the form
                Furnace_GUI.this.dispose();


            }
        });
    }
}
