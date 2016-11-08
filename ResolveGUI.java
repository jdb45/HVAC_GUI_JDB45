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

    public void close(){
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                String entry = reasonResolved.getText();
                double charge = Double.parseDouble(totalFee.getText());
                Date date = new Date();

                Object userSelect = HVACGUI.guszilla;

                HVACGUI.newCentralAC.remove(userSelect);
                HVACGUI.openTickets.removeElement(userSelect);

                ResolvedList.showResolved.addElement(userSelect + " Resolution: " +
                        entry + " Date: " + date + " Total Charged: $" + charge + "\n");

                ResolveGUI.this.dispose();

            }

        });

       }
    }

