import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SwingBasics {
    private JFrame mainFrame;
    private JLabel headerLabel;
    private JLabel statusLabel;
    private JPanel controlPanel;

    public SwingBasics() {
        prepareGUI();
    }

    public static void main(String args[]) {
        SwingBasics swingBasics = new SwingBasics();
        swingBasics.showEventDemo();
    }

    private void showEventDemo() {

    }

    private void prepareGUI() {
        mainFrame = new JFrame("Java Swing Example");
        mainFrame.setSize(400,400);
        mainFrame.setLayout(new GridLayout(3,1));

        headerLabel = new JLabel("", JLabel.CENTER);
        statusLabel = new JLabel("", JLabel.CENTER);
        statusLabel.setSize(350,100);

        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }    
        });

        controlPanel = new JPanel();
    
    }
}