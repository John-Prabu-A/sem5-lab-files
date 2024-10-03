import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
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
        headerLabel.setText("Control in Action Button");
        JButton okButton = new JButton("Ok");
        JButton submitButton = new JButton("Submit");
        JButton cancelButton = new JButton("Cancel");

        okButton.setActionCommand("Ok");
        submitButton.setActionCommand("Submit");
        cancelButton.setActionCommand("Cancel");

        okButton.addActionListener(new ButtonClickListener());
        submitButton.addActionListener(new ButtonClickListener());
        cancelButton.addActionListener(new ButtonClickListener());

        controlPanel.add(okButton);
        controlPanel.add(submitButton);
        controlPanel.add(cancelButton);
        
        controlPanel.setVisible(true);

        
    }

    private class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            if(command.equals("Ok")) {
                statusLabel.setText("Ok Button Clicked");
            } else if(command.equals("Submit")) {
                statusLabel.setText("Submit Button Clicked");
            } else {
                statusLabel.setText("Cancel Button Clicked");
            }
        }
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
        controlPanel.setLayout(new FlowLayout());
        mainFrame.add(headerLabel);
        mainFrame.add(controlPanel);
        mainFrame.add(statusLabel);
        mainFrame.setVisible(true);
    }
}