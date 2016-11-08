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


    public Furnace_GUI(HVACGUI hvacForm) {

        setContentPane(rootPanel);
        setPreferredSize(new Dimension(500, 500));
        pack();
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        selectType.addItem("Forced Air");
        selectType.addItem("Boiler/Radiators");
        selectType.addItem("Gravity Feed (the older 'octopus' style)");
        hvacForm.setEnabled(false);
        addToList();
        hvacForm.setEnabled(true);
    }


    public void addToList() {
        addToCurrentListButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String address = enterAddress.getText();
                String issue = enterAddress.getText();
                String type = (String) selectType.getSelectedItem();

                Date date = new Date();

                Furnace furnaceEntry = new Furnace(address, issue, date, type);

                HVACGUI.newCentralAC.add(furnaceEntry);
                HVACGUI.openTickets.addElement(furnaceEntry);

                Furnace_GUI.this.dispose();


            }
        });
    }
}
