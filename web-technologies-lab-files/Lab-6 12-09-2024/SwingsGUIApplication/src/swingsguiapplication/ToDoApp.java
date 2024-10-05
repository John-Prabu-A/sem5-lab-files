package swingsguiapplication;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToDoApp extends JFrame {
    private DefaultListModel<String> listModel;
    private JList<String> todoList;
    private JTextField taskInput;
    private JButton addButton;
    private JButton removeButton;

    public ToDoApp() {
        // Set up the frame
        setTitle("To-Do List Application");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Initialize components
        listModel = new DefaultListModel<>();
        todoList = new JList<>(listModel);
        taskInput = new JTextField(20);
        addButton = new JButton("Add Task");
        removeButton = new JButton("Remove Task");

        // Set up the top panel for input
        JPanel inputPanel = new JPanel();
        inputPanel.add(taskInput);
        inputPanel.add(addButton);
        inputPanel.add(removeButton);

        // Add components to the frame
        add(new JScrollPane(todoList), BorderLayout.CENTER);
        add(inputPanel, BorderLayout.SOUTH);

        // Add action listeners
        addButton.addActionListener(new AddTaskListener());
        removeButton.addActionListener(new RemoveTaskListener());
    }

    private class AddTaskListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String task = taskInput.getText().trim();
            if (!task.isEmpty()) {
                listModel.addElement(task);
                taskInput.setText(""); // Clear input field
            } else {
                JOptionPane.showMessageDialog(ToDoApp.this, "Please enter a task.", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    private class RemoveTaskListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int selectedIndex = todoList.getSelectedIndex();
            if (selectedIndex != -1) {
                listModel.remove(selectedIndex);
            } else {
                JOptionPane.showMessageDialog(ToDoApp.this, "Please select a task to remove.", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ToDoApp app = new ToDoApp();
            app.setVisible(true);
        });
    }
}
