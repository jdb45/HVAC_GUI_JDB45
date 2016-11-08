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

    public static ArrayList<Object> newCentralAC = new ArrayList<>();

    //public static ArrayList<Object> newFurnace = new ArrayList<>();

    public static DefaultListModel openTickets = new DefaultListModel<>();

    public static Object guszilla;


    public HVACGUI(){
        super("HVAC GUI");
        setContentPane(rootPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(800, 500));
        pack();
        setVisible(true);
        resolve();
        acRadioCheck();
        furnaceCheck();
        addButtonCheck();
        openResolved();
        quit();

        openServiceList.setModel(openTickets);

        openServiceList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        getSelection();

    }


    public void resolve() {
        resolveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                ResolveGUI resolve = new ResolveGUI(HVACGUI.this);

            }
        });
    }


    public void acRadioCheck() {
        ACRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

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

                if (AC) {

                    CentralAC_GUI newAC = new CentralAC_GUI(HVACGUI.this);
                    ACRadioButton.setSelected(false);
                    AC = false;
                    furnaceRadioButton.setEnabled(true);

                }

                if (furnace) {

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

                ResolvedList openResolvedList = new ResolvedList(HVACGUI.this);

            }
        });
    }

    public void getSelection() {
        openServiceList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {

                guszilla = openServiceList.getSelectedValue();

            }
        });
    }

    public void quit(){
        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }





}


