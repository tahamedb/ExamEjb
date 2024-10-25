package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminFrame extends JFrame {

    private CardLayout cardLayout;
    private JPanel contentPanel;

    public AdminFrame() {
        setTitle("CD Library - Admin Panel");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        cardLayout = new CardLayout();
        contentPanel = new JPanel(cardLayout);

        // Add panels
        contentPanel.add(new AddCDPanel(this), "AddCD");
        contentPanel.add(new EditCDPanel(this), "EditCD");
        contentPanel.add(new ViewLoansPanel(), "ViewLoans");

        // Create Menu
        JMenuBar menuBar = new JMenuBar();
        JMenu manageMenu = new JMenu("Manage");
        JMenuItem addCDItem = new JMenuItem("Add CD");
        JMenuItem editCDItem = new JMenuItem("Edit CD");
        JMenuItem viewLoansItem = new JMenuItem("View Loans");

        addCDItem.addActionListener(e -> cardLayout.show(contentPanel, "AddCD"));
        editCDItem.addActionListener(e -> cardLayout.show(contentPanel, "EditCD"));
        viewLoansItem.addActionListener(e -> cardLayout.show(contentPanel, "ViewLoans"));

        manageMenu.add(addCDItem);
        manageMenu.add(editCDItem);
        manageMenu.add(viewLoansItem);
        menuBar.add(manageMenu);
        setJMenuBar(menuBar);

        // Add content panel
        add(contentPanel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AdminFrame adminFrame = new AdminFrame();
            adminFrame.setVisible(true);
        });
    }
}
