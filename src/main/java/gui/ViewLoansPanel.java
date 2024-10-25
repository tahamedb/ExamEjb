package gui;

import javax.swing.*;
import java.awt.*;

public class ViewLoansPanel extends JPanel {

    private JTable loansTable;

    public ViewLoansPanel() {
        setLayout(new BorderLayout());

        // Placeholder table data and columns
        String[] columnNames = {"Loan ID", "CD Title", "User ID", "Loan Date", "Return Date"};
        Object[][] data = {
                // Placeholder data
                {"1", "Album 1", "User1", "2024-01-01", null},
                {"2", "Album 2", "User2", "2024-01-02", "2024-01-10"}
        };

        loansTable = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(loansTable);
        add(scrollPane, BorderLayout.CENTER);
    }
}
