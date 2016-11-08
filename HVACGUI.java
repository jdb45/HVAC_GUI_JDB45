import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class HVACGUI extends JFrame{
    private JPanel rootPanel;
    private JRadioButton ACRadioButton;
    private JList openServiceList;
    private JRadioButton furnaceRadioButton;
    private JButton addButton;
    private JButton resolveButton;
    private JButton quitButton;
    private JButton resolveListOpenButton;

    public boolean AC;
    public boolean furnace;
    //creating lists to store values
    public static ArrayList<Object> newCentralAC = new ArrayList<>();

    public static DefaultListModel openService = new DefaultListModel<>();

    public static Object selectionService;


    public HVACGUI(){
        //seting the headline name
        super("HVAC GUI");
        setContentPane(rootPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(800, 500));
        pack();
        setVisible(true);
        //calling the methods
        resolve();
        acRadioCheck();
        furnaceCheck();
        addButtonCheck();
        openResolved();
        quit();
        //setting the JList model
        openServiceList.setModel(openService);
        //getting the selection from the list
        openServiceList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        getSelection();

    }


    public void resolve() {
        resolveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //opening the resolve GUI if theres something selected
                if(openServiceList.getSelectedValue() == null){
                    JOptionPane.showMessageDialog(rootPanel, "Please select a service request");
                }
                else {
                    ResolveGUI resolve = new ResolveGUI(HVACGUI.this);
                }
            }
        });
    }


    public void acRadioCheck() {
        ACRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //checks if the radio button is selected. it makes the furnace button disabled. Re-enables it when unchecked
                if(ACRadioButton.isSelected()) {
                    AC = ACRadioButton.isSelected();
                    furnaceRadioButton.setEnabled(false);
                    furnace = false;
                }
                else{
                    furnaceRadioButton.setEnabled(true);
                    furnace = false;
                }

            }
        });
    }
    public void furnaceCheck() {
        furnaceRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //checks if the furnace button is selected. it makes the AC button disabled. Re-enables it when unchecked
                if(furnaceRadioButton.isSelected()) {
                    furnace = furnaceRadioButton.isSelected();
                    ACRadioButton.setEnabled(false);
                    AC = false;
                }
                else {
                    ACRadioButton.setEnabled(true);
                    AC = false;
                }


            }
        });
    }

    public void addButtonCheck() {
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(AC) {
                    //if the AC button is checked, it will open the AC GUI form
                    CentralAC_GUI newAC = new CentralAC_GUI(HVACGUI.this);
                    ACRadioButton.setSelected(false);
                    AC = false;
                    furnaceRadioButton.setEnabled(true);

                }
                //if the furnace button is checked, it will open the furnace GUI form
                if(furnace) {

                    Furnace_GUI newFurnace = new Furnace_GUI(HVACGUI.this);
                    furnaceRadioButton.setSelected(false);
                    furnace = false;
                    ACRadioButton.setEnabled(true);

                }

            }
        });
    }


    public void openResolved() {
        resolveListOpenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //opens the resolved service list
                ResolvedList openResolvedList = new ResolvedList(HVACGUI.this);

            }
        });
    }

    public void getSelection() {
        openServiceList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                //getting the selection form what the user selects
                selectionService = openServiceList.getSelectedValue();

            }
        });
    }

    public void quit(){
        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (JOptionPane.OK_OPTION == JOptionPane.showConfirmDialog(HVACGUI.this, "Are you sure you want to exit?", "Exit", JOptionPane.OK_CANCEL_OPTION)){
                    System.exit(0);
                }
            }
        });
    }
}


