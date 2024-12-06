package gui;



import client.ClientHandler;
import model.Produit;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class ProductForm extends JFrame {
    private final ClientHandler clientHandler;

    public ProductForm(ClientHandler clientHandler) {
        this.clientHandler = clientHandler;

        setTitle("Ajouter un Produit");
        setSize(400, 300);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        initUI();
    }

    private void initUI() {
        JPanel panel = new JPanel(new GridLayout(5, 2));
        JTextField nameField = new JTextField();
        JTextField categoryField = new JTextField();
        JTextField quantityField = new JTextField();
        JTextField priceField = new JTextField();

        JButton submitButton = new JButton("Ajouter");

        submitButton.addActionListener(e -> {
            Produit produit = new Produit(0, nameField.getText(), categoryField.getText(),
                    Integer.parseInt(quantityField.getText()), Double.parseDouble(priceField.getText()));

            try {
                String response = clientHandler.addProduct(produit);
                JOptionPane.showMessageDialog(this, response);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erreur : " + ex.getMessage());
            }
        });

        panel.add(new JLabel("Nom :"));
        panel.add(nameField);
        panel.add(new JLabel("Catégorie :"));
        panel.add(categoryField);
        panel.add(new JLabel("Quantité :"));
        panel.add(quantityField);
        panel.add(new JLabel("Prix :"));
        panel.add(priceField);
        panel.add(submitButton);

        add(panel);
    }
}

