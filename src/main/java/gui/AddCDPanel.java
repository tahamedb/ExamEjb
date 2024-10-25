package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddCDPanel extends JPanel {

    private JTextField titleField, artistField, genreField;
    private JButton addButton;

    public AddCDPanel(AdminFrame parent) {
        setLayout(new GridLayout(5, 2));

        // Fields for CD details
        add(new JLabel("Title:"));
        titleField = new JTextField();
        add(titleField);

        add(new JLabel("Artist:"));
        artistField = new JTextField();
        add(artistField);

        add(new JLabel("Genre:"));
        genreField = new JTextField();
        add(genreField);

        addButton = new JButton("Add CD");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Placeholder action to simulate adding a CD
                String title = titleField.getText();
                String artist = artistField.getText();
                String genre = genreField.getText();

                // TODO: Implement EJB, I dont have enough time
                JOptionPane.showMessageDialog(parent, "CD Added: " + title);
                clearFields();
            }
        });
        add(addButton);
    }

    private void clearFields() {
        titleField.setText("");
        artistField.setText("");
        genreField.setText("");
    }
}
