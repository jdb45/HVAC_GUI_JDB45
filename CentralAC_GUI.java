import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class CentralAC_GUI extends JFrame{
    private JPanel rootPanel;
    private JButton addToCurrentListButton;
    private JTextField enterAddress;
    private JTextField enterIssue;
    private JTextField enterModel;

    //calling the HVACGUI to be able to check which form the user can work on
    public CentralAC_GUI(HVACGUI hvacForm) {

        //setting the content pane
        setContentPane(rootPanel);

        setPreferredSize(new Dimension(500, 500));
        pack();
        setVisible(true);
        //using the dispose on close to close the form
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //setting the hvac form to false so its not the active form
        hvacForm.setEnabled(false);
        //calling the addToList method
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
                String model = enterModel.getText();
                //date method
                Date date = new Date();
                //creating a quick CentralAC list
                CentralAC acEntry = new CentralAC(address, issue, date, model);
                //adding items to the Arraylist
                HVACGUI.newCentralAC.add(acEntry);
                //adding items to the default list model
                HVACGUI.openService.addElement(acEntry);
                //disposing the form
                CentralAC_GUI.this.dispose();


            }
        });
    }
}
