import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;

// --- 1. DATA MODEL: Represents a single task ---
class Task implements Serializable {
    private static final long serialVersionUID = 1L; // for version control when saving
    private String description;
    private boolean done;

    public Task(String description) {
        this.description = description;
        this.done = false;
    }

    public String getDescription() { return description; }
    public boolean isDone() { return done; }
    public void setDone(boolean done) { this.done = done; }

    @Override
    public String toString() {
        return description; // what shows up in the JList by default
    }
}

// --- 2. MAIN APPLICATION ---
public class ToDoListApp extends JFrame {
    // UI Components
    private JTextField taskInputField;
    private JButton addButton;
    private JList<Task> taskList;
    private DefaultListModel<Task> listModel; // dynamic data source for JList
    private JButton deleteButton;
    private JButton toggleButton;
    private JButton clearAllButton;

    // Persistence
    private static final String SAVE_FILE = "tasks.dat";

    public ToDoListApp() {
        // --- Window Setup ---
        setTitle("✅ My To‑Do List");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // --- Create the panels ---
        // 1. Input Panel (Top)
        JPanel inputPanel = new JPanel(new BorderLayout(5, 5));
        taskInputField = new JTextField();
        addButton = new JButton("Add Task");
        inputPanel.add(taskInputField, BorderLayout.CENTER);
        inputPanel.add(addButton, BorderLayout.EAST);

        // 2. List Panel (Center) - shows tasks with a custom renderer
        listModel = new DefaultListModel<>();
        taskList = new JList<>(listModel);
        taskList.setCellRenderer(new TaskCellRenderer()); // custom checkbox renderer
        taskList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(taskList);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Your Tasks"));

        // 3. Button Panel (Bottom)
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));
        deleteButton = new JButton("🗑 Delete Selected");
        toggleButton = new JButton("✔ Toggle Done");
        clearAllButton = new JButton("❌ Clear All");
        buttonPanel.add(deleteButton);
        buttonPanel.add(toggleButton);
        buttonPanel.add(clearAllButton);

        // --- Assemble the frame ---
        setLayout(new BorderLayout(10, 10));
        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        // --- Wire up the Actions (Event Listeners) ---

        // Add task: on button click OR pressing Enter in the text field
        addButton.addActionListener(e -> addTask());
        taskInputField.addActionListener(e -> addTask());

        // Delete selected task
        deleteButton.addActionListener(e -> deleteSelectedTask());

        // Toggle done status of selected task
        toggleButton.addActionListener(e -> toggleSelectedTask());

        // Clear all tasks (with confirmation)
        clearAllButton.addActionListener(e -> clearAllTasks());

        // Enable/disable buttons based on whether a task is selected
        taskList.addListSelectionListener((ListSelectionEvent e) -> {
            boolean selected = taskList.getSelectedIndex() != -1;
            deleteButton.setEnabled(selected);
            toggleButton.setEnabled(selected);
        });
        // Initially, no task is selected
        deleteButton.setEnabled(false);
        toggleButton.setEnabled(false);

        // --- Load saved tasks from disk ---
        loadTasks();

        // Add a shutdown hook to save automatically when the app closes
        Runtime.getRuntime().addShutdownHook(new Thread(this::saveTasks));
    }

    // --- CORE LOGIC METHODS ---

    private void addTask() {
        String text = taskInputField.getText().trim();
        if (text.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a task description.", 
                                          "Empty Task", JOptionPane.WARNING_MESSAGE);
            return;
        }
        // Add the new task to the model
        listModel.addElement(new Task(text));
        taskInputField.setText(""); // clear the input field
        taskInputField.requestFocus(); // focus back to typing
        // Auto-select the new task? Not necessary but could be a nice touch.
    }

    private void deleteSelectedTask() {
        int index = taskList.getSelectedIndex();
        if (index != -1) {
            listModel.remove(index);
            // After deletion, select the next item if available
            if (index < listModel.size()) {
                taskList.setSelectedIndex(index);
            } else if (listModel.size() > 0) {
                taskList.setSelectedIndex(listModel.size() - 1);
            }
        }
    }

    private void toggleSelectedTask() {
        int index = taskList.getSelectedIndex();
        if (index != -1) {
            Task task = listModel.get(index);
            task.setDone(!task.isDone()); // flip the flag
            taskList.repaint(); // force the cell renderer to refresh the checkbox
            // (Optional: move completed tasks to the bottom? For simplicity, we keep order)
        }
    }

    private void clearAllTasks() {
        if (listModel.isEmpty()) return;
        int confirm = JOptionPane.showConfirmDialog(this,
                "Delete all tasks permanently?",
                "Confirm Clear All",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE);
        if (confirm == JOptionPane.YES_OPTION) {
            listModel.clear();
        }
    }

    // --- PERSISTENCE (Save / Load) ---

    private void saveTasks() {
        List<Task> tasks = new ArrayList<>();
        for (int i = 0; i < listModel.size(); i++) {
            tasks.add(listModel.get(i));
        }
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(SAVE_FILE))) {
            oos.writeObject(tasks);
        } catch (IOException e) {
            // In a real app, you'd log this; we'll just print to console.
            System.err.println("Error saving tasks: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    private void loadTasks() {
        File file = new File(SAVE_FILE);
        if (!file.exists()) return; // first run, no file yet
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            List<Task> tasks = (List<Task>) ois.readObject();
            // Clear current model (just in case) and add all loaded tasks
            listModel.clear();
            for (Task t : tasks) {
                listModel.addElement(t);
            }
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading tasks: " + e.getMessage());
            // If corrupted, we just start fresh (or could show a dialog)
        }
    }

    // --- CUSTOM RENDERER: Displays a checkbox next to each task ---
    private static class TaskCellRenderer extends JPanel implements ListCellRenderer<Task> {
        private final JCheckBox checkBox;

        public TaskCellRenderer() {
            setLayout(new BorderLayout());
            checkBox = new JCheckBox();
            checkBox.setOpaque(false);
            add(checkBox, BorderLayout.WEST);
            setOpaque(true);
        }

        @Override
        public Component getListCellRendererComponent(JList<? extends Task> list,
                                                      Task task,
                                                      int index,
                                                      boolean isSelected,
                                                      boolean cellHasFocus) {
            // Update the checkbox
            checkBox.setText(task.getDescription());
            checkBox.setSelected(task.isDone());

            // Strikethrough effect if done (optional nice touch)
            if (task.isDone()) {
                checkBox.setFont(checkBox.getFont().deriveFont(Font.ITALIC));
                checkBox.setForeground(Color.GRAY);
            } else {
                checkBox.setFont(checkBox.getFont().deriveFont(Font.PLAIN));
                checkBox.setForeground(Color.BLACK);
            }

            // Highlight selected background
            if (isSelected) {
                setBackground(list.getSelectionBackground());
                setForeground(list.getSelectionForeground());
            } else {
                setBackground(list.getBackground());
                setForeground(list.getForeground());
            }

            return this;
        }
    }

    // --- ENTRY POINT ---
    public static void main(String[] args) {
        // Ensure the UI is created on the Event Dispatch Thread
        SwingUtilities.invokeLater(() -> {
            new ToDoListApp().setVisible(true);
        });
    }
}