import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class employmentsystem extends JFrame {

    JTextField tfID, tfName, tfAge, tfDOB, tfNationality, tfContact, tfEmail, tfDept, tfJobTitle;
    JComboBox<String> cbCivilStatus;
    JRadioButton rbMale, rbFemale;
    ButtonGroup genderGroup;
    JTable table;
    DefaultTableModel tableModel;
    String FILE_NAME = "employeessystem.txt";

    public employmentsystem() {
        setTitle("Employee Management System");
        setSize(900, 520);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(0, 0));

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(8, 10, 0, 10));

        JLabel companyLabel = new JLabel("EMS Inc.");
        companyLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        mainPanel.add(companyLabel);
        mainPanel.add(Box.createVerticalStrut(8));

        JPanel formPanel = new JPanel(null);
        formPanel.setPreferredSize(new Dimension(860, 170));
        formPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 170));
        formPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

        int labelH = 14;
        int fieldH = 22;
        int col1x = 0;
        int col2x = 175;
        int col3x = 360;
        int col4x = 555;

        JLabel lbID = new JLabel("Employee ID");
        lbID.setBounds(col1x, 0, 120, labelH);
        formPanel.add(lbID);

        tfID = new JTextField();
        tfID.setBounds(col1x, 16, 150, fieldH);
        formPanel.add(tfID);

        JLabel lbAge = new JLabel("Age");
        lbAge.setBounds(col2x, 0, 60, labelH);
        formPanel.add(lbAge);

        tfAge = new JTextField();
        tfAge.setBounds(col2x, 16, 150, fieldH);
        formPanel.add(tfAge);

        JLabel lbGender = new JLabel("Gender");
        lbGender.setBounds(col3x, 0, 60, labelH);
        formPanel.add(lbGender);

        rbMale = new JRadioButton("Male");
        rbMale.setBounds(col3x, 14, 65, 22);
        rbMale.setSelected(true);
        formPanel.add(rbMale);

        rbFemale = new JRadioButton("Female");
        rbFemale.setBounds(col3x + 66, 14, 75, 22);
        formPanel.add(rbFemale);

        genderGroup = new ButtonGroup();
        genderGroup.add(rbMale);
        genderGroup.add(rbFemale);

        JLabel lbName = new JLabel("Fullname");
        lbName.setBounds(col1x, 46, 100, labelH);
        formPanel.add(lbName);

        tfName = new JTextField();
        tfName.setBounds(col1x, 62, 150, fieldH);
        formPanel.add(tfName);

        JLabel lbCS = new JLabel("Civil Status");
        lbCS.setBounds(col2x, 46, 80, labelH);
        formPanel.add(lbCS);

        cbCivilStatus = new JComboBox<>(new String[]{"Single", "Married", "Widowed", "Separated", "Divorced"});
        cbCivilStatus.setBounds(col2x, 62, 150, fieldH);
        formPanel.add(cbCivilStatus);

        JLabel lbContact = new JLabel("Contact Number");
        lbContact.setBounds(col3x, 46, 120, labelH);
        formPanel.add(lbContact);

        tfContact = new JTextField();
        tfContact.setBounds(col3x, 62, 155, fieldH);
        formPanel.add(tfContact);

        JLabel lbDept = new JLabel("Department");
        lbDept.setBounds(col4x, 46, 100, labelH);
        formPanel.add(lbDept);

        tfDept = new JTextField();
        tfDept.setBounds(col4x, 62, 200, fieldH);
        formPanel.add(tfDept);

        JLabel lbDOB = new JLabel("Date of Birth");
        lbDOB.setBounds(col1x, 92, 100, labelH);
        formPanel.add(lbDOB);

        tfDOB = new JTextField();
        tfDOB.setBounds(col1x, 108, 150, fieldH);
        formPanel.add(tfDOB);

        JLabel lbNat = new JLabel("Nationality");
        lbNat.setBounds(col2x, 92, 80, labelH);
        formPanel.add(lbNat);

        tfNationality = new JTextField();
        tfNationality.setBounds(col2x, 108, 150, fieldH);
        formPanel.add(tfNationality);

        JLabel lbEmail = new JLabel("Email");
        lbEmail.setBounds(col3x, 92, 60, labelH);
        formPanel.add(lbEmail);

        tfEmail = new JTextField();
        tfEmail.setBounds(col3x, 108, 155, fieldH);
        formPanel.add(tfEmail);

        JLabel lbJob = new JLabel("Job Title / Position");
        lbJob.setBounds(col4x, 92, 130, labelH);
        formPanel.add(lbJob);

        tfJobTitle = new JTextField();
        tfJobTitle.setBounds(col4x, 108, 200, fieldH);
        formPanel.add(tfJobTitle);


        JButton btnAdd = new JButton("Add Employee");
        btnAdd.setBounds(col2x, 138, 155, fieldH);
        formPanel.add(btnAdd);

        JButton btnUpdate = new JButton("Update Employee");
        btnUpdate.setBounds(col3x, 138, 155, fieldH);
        formPanel.add(btnUpdate);

        JButton btnDelete = new JButton("Delete Employee");
        btnDelete.setBounds(col4x, 138, 155, fieldH);
        formPanel.add(btnDelete);

        mainPanel.add(formPanel);
        mainPanel.add(Box.createVerticalStrut(6));

        String[] columns = {"Employee ID", "Fullname", "Birth", "Age", "Civil Status",
                            "Nationality", "Gender", "Contact", "Email", "Department",
                            "Job Title"};

        tableModel = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        table = new JTable(tableModel);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table.setRowHeight(28);

        int[] colWidths = {80, 68, 54, 38, 72, 72, 54, 62, 58, 78, 70};
        for (int i = 0; i < colWidths.length; i++) {
            table.getColumnModel().getColumn(i).setPreferredWidth(colWidths[i]);
        }

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setAlignmentX(Component.LEFT_ALIGNMENT);
        mainPanel.add(scrollPane);

        add(mainPanel, BorderLayout.CENTER);

        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String id = tfID.getText().trim();
                String name = tfName.getText().trim();
                String age = tfAge.getText().trim();
                String dob = tfDOB.getText().trim();
                String nationality = tfNationality.getText().trim();
                String contact = tfContact.getText().trim();
                String email = tfEmail.getText().trim();
                String dept = tfDept.getText().trim();
                String jobTitle = tfJobTitle.getText().trim();
                String civilStatus = (String) cbCivilStatus.getSelectedItem();
                String gender = rbMale.isSelected() ? "Male" : "Female";

                if (id.isEmpty() || name.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Employee ID and Fullname are required.");
                    return;
                }

                tableModel.addRow(new Object[]{id, name, dob, age, civilStatus, nationality,
                        gender, contact, email, dept, jobTitle});

                saveAllData();

                tfID.setText(""); tfName.setText(""); tfAge.setText("");
                tfDOB.setText(""); tfNationality.setText(""); tfContact.setText("");
                tfEmail.setText(""); tfDept.setText(""); tfJobTitle.setText("");
                cbCivilStatus.setSelectedIndex(0);
                rbMale.setSelected(true);
            }
        });

        btnUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow == -1) {
                    JOptionPane.showMessageDialog(null, "Please select an employee row to update.");
                    return;
                }
 
                String id = tfID.getText().trim();
                String name = tfName.getText().trim();
                String age = tfAge.getText().trim();
                String dob = tfDOB.getText().trim();
                String nationality = tfNationality.getText().trim();
                String contact = tfContact.getText().trim();
                String email = tfEmail.getText().trim();
                String dept = tfDept.getText().trim();
                String jobTitle = tfJobTitle.getText().trim();
                String civilStatus = (String) cbCivilStatus.getSelectedItem();
                String gender = rbMale.isSelected() ? "Male" : "Female";
 
                if (id.isEmpty() || name.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Employee ID and Fullname are required.");
                    return;
                }
 
                tableModel.setValueAt(id, selectedRow, 0);
                tableModel.setValueAt(name, selectedRow, 1);
                tableModel.setValueAt(dob, selectedRow, 2);
                tableModel.setValueAt(age, selectedRow, 3);
                tableModel.setValueAt(civilStatus, selectedRow, 4);
                tableModel.setValueAt(nationality, selectedRow, 5);
                tableModel.setValueAt(gender, selectedRow, 6);
                tableModel.setValueAt(contact, selectedRow, 7);
                tableModel.setValueAt(email, selectedRow, 8);
                tableModel.setValueAt(dept, selectedRow, 9);
                tableModel.setValueAt(jobTitle, selectedRow, 10);
 
                saveAllData();
 
                tfID.setText(""); tfName.setText(""); tfAge.setText("");
                tfDOB.setText(""); tfNationality.setText(""); tfContact.setText("");
                tfEmail.setText(""); tfDept.setText(""); tfJobTitle.setText("");
                cbCivilStatus.setSelectedIndex(0);
                rbMale.setSelected(true);
 
                JOptionPane.showMessageDialog(null, "Employee updated successfully.");
            }
        });
 
        btnDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow == -1) {
                    JOptionPane.showMessageDialog(null, "Please select an employee row to delete.");
                    return;
                }
                int confirm = JOptionPane.showConfirmDialog(
                    employmentsystem.this,
                    "Are you sure you want to delete this employee?",
                    "Confirm Delete",
                    JOptionPane.YES_NO_OPTION
                );
                if (confirm == JOptionPane.YES_OPTION) {
                    tableModel.removeRow(selectedRow);
                    saveAllData();
                }
            }
        });

        loadData();
        setVisible(true);
    }

    void saveAllData() {
        try {
            FileWriter fw = new FileWriter(FILE_NAME, false);
            for (int i = 0; i < tableModel.getRowCount(); i++) {
                fw.write("Employee ID: " + (tableModel.getValueAt(i, 0) == null ? "" : tableModel.getValueAt(i, 0)) + "\n");
                fw.write("Fullname: " + (tableModel.getValueAt(i, 1) == null ? "" : tableModel.getValueAt(i, 1)) + "\n");
                fw.write("Date of Birth: " + (tableModel.getValueAt(i, 2) == null ? "" : tableModel.getValueAt(i, 2)) + "\n");
                fw.write("Age: " + (tableModel.getValueAt(i, 3) == null ? "" : tableModel.getValueAt(i, 3)) + "\n");
                fw.write("Civil Status: " + (tableModel.getValueAt(i, 4) == null ? "" : tableModel.getValueAt(i, 4)) + "\n");
                fw.write("Nationality: " + (tableModel.getValueAt(i, 5) == null ? "" : tableModel.getValueAt(i, 5)) + "\n");
                fw.write("Gender: " + (tableModel.getValueAt(i, 6) == null ? "" : tableModel.getValueAt(i, 6)) + "\n");
                fw.write("Contact: " + (tableModel.getValueAt(i, 7) == null ? "" : tableModel.getValueAt(i, 7)) + "\n");
                fw.write("Email: " + (tableModel.getValueAt(i, 8) == null ? "" : tableModel.getValueAt(i, 8)) + "\n");
                fw.write("Department: " + (tableModel.getValueAt(i, 9) == null ? "" : tableModel.getValueAt(i, 9)) + "\n");
                fw.write("Job Title: " + (tableModel.getValueAt(i, 10) == null ? "" : tableModel.getValueAt(i, 10)) + "\n");
                fw.write("---\n");
            }
            fw.close();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error saving data.");
        }
    }

    void loadData() {
        try {
            File file = new File(FILE_NAME);
            if (!file.exists()) return;
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) continue;
                String[] parts = line.split("#", -1);
                if (parts.length == 11) {
                    tableModel.addRow(parts);
                }
            }
            br.close();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error loading data.");
        }
    }

    public static void main(String[] args) {
        new employmentsystem();
    }
}