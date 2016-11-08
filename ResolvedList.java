import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ResolvedList extends JFrame{
    private JPanel rootPanel;
    private JList listOfResolved;

    public static DefaultListModel showResolved = new DefaultListModel<>();

    public ResolvedList(HVACGUI hvacForm) {

        setContentPane(rootPanel);
        setPreferredSize(new Dimension(500, 500));
        pack();
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        hvacForm.setEnabled(false);
        listOfResolved.setModel(showResolved);

        hvacForm.setEnabled(true);

    }
}
