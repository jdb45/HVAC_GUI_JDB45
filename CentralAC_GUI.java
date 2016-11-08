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


    public CentralAC_GUI(HVACGUI hvacForm) {

        setContentPane(rootPanel);
        setPreferredSize(new Dimension(500, 500));
        pack();
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
                String model = enterModel.getText();
                Date date = new Date();

                CentralAC acEntry = new CentralAC(address, issue, date, model);

                HVACGUI.newCentralAC.add(acEntry);
                HVACGUI.openTickets.addElement(acEntry);

                CentralAC_GUI.this.dispose();


            }
        });
    }
}
