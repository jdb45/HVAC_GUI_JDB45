import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ResolvedList extends JFrame{
    private JPanel rootPanel;
    private JList listOfResolved;
    //creating a default model for the resolved ticket list
    public static DefaultListModel showResolved = new DefaultListModel<>();

    public ResolvedList(HVACGUI hvacForm) {

        setContentPane(rootPanel);
        setPreferredSize(new Dimension(500, 500));
        pack();
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        hvacForm.setEnabled(false);
        //setting the model for for the resolved list
        listOfResolved.setModel(showResolved);

        hvacForm.setEnabled(true);

    }
}
