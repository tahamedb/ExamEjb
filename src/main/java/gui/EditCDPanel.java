package gui;

import javax.swing.*;
import java.awt.*;

public class EditCDPanel extends JPanel {

    private JTextField titleField, artistField, genreField;
    private JButton updateButton, searchButton;
    private JTextField searchField;

    public EditCDPanel(AdminFrame parent) {
        setLayout(new GridLayout(6, 2));

        add(new JLabel("CD ID:"));
        searchField = new JTextField();
        add(searchField);

        searchButton = new JButton("Search");
        add(searchButton);

        add(new JLabel("Title:"));
        titleField = new JTextField();
        add(titleField);

        add(new JLabel("Artist:"));
        artistField = new JTextField();
        add(artistField);

        add(new JLabel("Genre:"));
        genreField = new JTextField();
        add(genreField);

        updateButton = new JButton("Update CD");
        add(updateButton);

        // Placeholder for search and update functionality
        searchButton.addActionListener(e -> {
            String cdId = searchField.getText();
            // TODO: Fetch Details  I dont have enough time
            JOptionPane.showMessageDialog(parent, "CD details loaded for ID: " + cdId);
        });

        updateButton.addActionListener(e -> {
            String title = titleField.getText();
            String artist = artistField.getText();
            String genre = genreField.getText();
            // TODO: update CD, (no time)
            JOptionPane.showMessageDialog(parent, "CD Updated: " + title);
        });
    }
}
