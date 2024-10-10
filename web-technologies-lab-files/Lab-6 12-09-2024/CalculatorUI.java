import javax.swing.*;
import java.awt.*;

public class CalculatorUI {
    public static void main(String[] args) {
        // Create the main frame
        JFrame frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 550);

        // Create the display panel
        JPanel displayPanel = new JPanel();
        displayPanel.setLayout(new BorderLayout());

        // Display labels for the result and expression
        JLabel expressionLabel = new JLabel("", SwingConstants.RIGHT);
        JLabel resultLabel = new JLabel("", SwingConstants.RIGHT);

        expressionLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        resultLabel.setFont(new Font("Arial", Font.BOLD, 36));

        displayPanel.add(expressionLabel, BorderLayout.NORTH);
        displayPanel.add(resultLabel, BorderLayout.CENTER);

        // Create the button panel with GridBagLayout
        JPanel buttonPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(5, 5, 5, 5);

        // Create buttons with GridBagLayout constraints
        String[] buttonLabels = {
                "CE", "+/-", "%", "/",
                "7", "8", "9", "*",
                "4", "5", "6", "-",
                "1", "2", "3", "+",
                "0", ".", "="
        };

        JButton[] buttons = new JButton[buttonLabels.length];

        // Button index tracker
        int index = 0;

        // Adding buttons to the grid with constraints
        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 4; col++) {
                if (row == 3 && col == 3) {
                    // Add the "+" button spanning two rows
                    gbc.gridx = col;
                    gbc.gridy = row;
                    gbc.gridheight = 2;
                    buttons[index] = new JButton(buttonLabels[index]);
                    buttons[index].setFont(new Font("Arial", Font.PLAIN, 24));
                    buttons[index].setBackground(new Color(76, 201, 244));
                    buttons[index].setForeground(Color.WHITE);
                    buttonPanel.add(buttons[index], gbc);
                    index++;
                } else if (!(row == 4 && col == 3)) {
                    // Add all other buttons except for the second "=" button slot
                    gbc.gridx = col;
                    gbc.gridy = row;
                    gbc.gridheight = 1;
                    if (index < buttonLabels.length) {  // Ensure index is within bounds
                        buttons[index] = new JButton(buttonLabels[index]);
                        buttons[index].setFont(new Font("Arial", Font.PLAIN, 24));
                        if (buttonLabels[index].equals("=")) {
                            buttons[index].setBackground(new Color(76, 201, 244));
                            buttons[index].setForeground(Color.WHITE);
                        } else if ("+-*/".contains(buttonLabels[index])) {
                            buttons[index].setBackground(new Color(224, 224, 224)); // Light gray for operators
                        } else {
                            buttons[index].setBackground(new Color(245, 245, 245)); // White background for number buttons
                        }
                        buttonPanel.add(buttons[index], gbc);
                        index++;
                    }
                }
            }
        }

        // Add the bottom "=" button in the last row, at the last column
        gbc.gridx = 3;
        gbc.gridy = 4;
        gbc.gridheight = 1;
        buttons[index - 1] = new JButton(buttonLabels[index - 1]);
        buttons[index - 1].setFont(new Font("Arial", Font.PLAIN, 24));
        buttons[index - 1].setBackground(new Color(76, 201, 244));
        buttons[index - 1].setForeground(Color.WHITE);
        buttonPanel.add(buttons[index - 1], gbc);

        // Add panels to the frame
        frame.setLayout(new BorderLayout(10, 10));
        frame.add(displayPanel, BorderLayout.NORTH);
        frame.add(buttonPanel, BorderLayout.CENTER);

        // Set the frame to be visible
        frame.setVisible(true);
    }
}
