package ui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

abstract class BaseManagementForm extends JFrame {

    JTextField[]      fields;
    DefaultTableModel tableModel;
    JTable            table;
    String[]          headers;

    BaseManagementForm(String title, String[] labels, String[] headers) {
        super(title);

        this.headers = headers;

        setSize(900, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel mainPanel = new JPanel(new BorderLayout(20, 20));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        setContentPane(mainPanel);

        // Form (labels + text fields)
        JPanel form = new JPanel(new GridLayout(labels.length + 1, 2, 10, 10));
        fields = new JTextField[labels.length];
        for (int i = 0; i < labels.length; i++) {
            form.add(new JLabel(labels[i]));
            fields[i] = new JTextField();
            form.add(fields[i]);
        }

        // Buttons
        JPanel buttons = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        JButton btnAdd    = new JButton("Add");
        JButton btnUpdate = new JButton("Update");
        JButton btnDelete = new JButton("Delete");
        JButton btnClear  = new JButton("Clear");
        buttons.add(btnAdd);
        buttons.add(btnUpdate);
        buttons.add(btnDelete);
        buttons.add(btnClear);
        form.add(buttons);

        mainPanel.add(form, BorderLayout.NORTH);

        // Table
        tableModel = new DefaultTableModel(headers, 0) {
            @Override public boolean isCellEditable(int r, int c) { return false; }
        };
        table = new JTable(tableModel);
        mainPanel.add(new JScrollPane(table), BorderLayout.CENTER);

        // Button actions
        btnAdd   .addActionListener(e -> addRecord());
        btnUpdate.addActionListener(e -> updateRecord());
        btnDelete.addActionListener(e -> deleteRecord());
        btnClear .addActionListener(e -> clearFields());

        // Row click → populate fields
        table.getSelectionModel().addListSelectionListener(e -> {
            int row = table.getSelectedRow();
            if (row >= 0) {
                for (int i = 0; i < fields.length; i++) {
                    fields[i].setText(tableModel.getValueAt(row, i).toString());
                }
            }
        });

        // NOTE: loadData() is NOT called here.
        // Each subclass calls it at the end of its own constructor,
        // AFTER its manager field has been assigned — fixing the NullPointerException.
    }

    // Abstract methods subclasses must implement
    protected abstract Object       buildObject();
    protected abstract List<Object[]> loadRows();
    protected abstract void         callAdd(Object obj);
    protected abstract void         callUpdate(int index, Object obj);
    protected abstract void         callDelete(int index);

    // Concrete CRUD wiring
    void loadData() {
        tableModel.setRowCount(0);
        for (Object[] row : loadRows()) {
            tableModel.addRow(row);
        }
    }

    void addRecord() {
        Object obj = buildObject();
        if (obj == null) return;
        callAdd(obj);
        loadData();
        clearFields();
    }

    void updateRecord() {
        int row = table.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Please select a row to update.");
            return;
        }
        Object obj = buildObject();
        if (obj == null) return;
        callUpdate(row, obj);
        loadData();
    }

    void deleteRecord() {
        int row = table.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Please select a row to delete.");
            return;
        }
        callDelete(row);
        loadData();
        clearFields();
    }

    void clearFields() {
        for (JTextField f : fields) f.setText("");
        table.clearSelection();
    }

    // Called by each subclass at the end of its constructor
    void init() {
        loadData();
        setVisible(true);
    }
}
