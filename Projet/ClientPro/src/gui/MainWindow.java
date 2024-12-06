package gui;

import client.ClientHandler;
import model.Produit;

import javax.swing.*;
import java.awt.*;
import java.util.List;

@SuppressWarnings("serial")
public class MainWindow extends JFrame {
    private final ClientHandler clientHandler;

    public MainWindow() {
        this.clientHandler = new ClientHandler("localhost", 145);

        setTitle("Système de Gestion d'Inventaire");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        initUI();
    }

    private void initUI() {
        // Panel principal
        JPanel panel = new JPanel(new BorderLayout());

        // Titre de l'application
        JLabel titleLabel = new JLabel("Système de Gestion d'Inventaire", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(new Color(0, 102, 204));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));

        // Boutons d'action
        JPanel buttonPanel = new JPanel(new FlowLayout());

        JButton fetchProductsButton = new JButton("Afficher les produits");
        fetchProductsButton.addActionListener(e -> displayProducts());

        JButton addProductButton = new JButton("Ajouter un produit");
        addProductButton.addActionListener(e -> addProduct());

        JButton getProductByIdButton = new JButton("Afficher produit par numéro");
        getProductByIdButton.addActionListener(e -> getProductById());

        // Ajout des boutons au panel
        buttonPanel.add(fetchProductsButton);
        buttonPanel.add(addProductButton);
        buttonPanel.add(getProductByIdButton);

        // Ajout des composants au panel principal
        panel.add(titleLabel, BorderLayout.NORTH);
        panel.add(buttonPanel, BorderLayout.CENTER);

        // Ajout du panel principal à la fenêtre
        add(panel);
    }

    private void displayProducts() {
        try {
            List<Produit> produits = clientHandler.getProducts();
            if (produits.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Aucun produit disponible.", "Produits", JOptionPane.INFORMATION_MESSAGE);
            } else {
                StringBuilder productList = new StringBuilder("<html>Liste des produits :<br>");
                for (Produit produit : produits) {
                    productList.append(produit).append("<br>");
                }
                productList.append("</html>");
                JOptionPane.showMessageDialog(this, productList.toString(), "Produits", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erreur lors de la récupération des produits : " + ex.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void addProduct() {
        JTextField idField = new JTextField();
        JTextField nameField = new JTextField();
        JTextField categoryField = new JTextField();
        JTextField quantityField = new JTextField();
        JTextField priceField = new JTextField();

        Object[] message = {
            "ID :", idField,
            "Nom :", nameField,
            "Catégorie :", categoryField,
            "Quantité :", quantityField,
            "Prix :", priceField
        };

        int option = JOptionPane.showConfirmDialog(this, message, "Ajouter un produit", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            try {
                int id = Integer.parseInt(idField.getText());
                String name = nameField.getText().trim();
                String category = categoryField.getText().trim();
                int quantity = Integer.parseInt(quantityField.getText());
                double price = Double.parseDouble(priceField.getText());

                if (name.isEmpty() || category.isEmpty()) {
                    throw new IllegalArgumentException("Les champs nom et catégorie ne peuvent pas être vides.");
                }

                Produit produit = new Produit(id, name, category, quantity, price);
                clientHandler.addProduct(produit);
                JOptionPane.showMessageDialog(this, "Produit ajouté avec succès.", "Succès", JOptionPane.INFORMATION_MESSAGE);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Veuillez entrer des valeurs valides pour les champs numériques.", "Erreur", JOptionPane.ERROR_MESSAGE);
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erreur lors de l'ajout du produit : " + ex.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void getProductById() {
        String inputId = JOptionPane.showInputDialog(this, "Entrez l'ID du produit :", "Rechercher un produit", JOptionPane.QUESTION_MESSAGE);
        if (inputId != null) {
            try {
                int id = Integer.parseInt(inputId);
                Produit produit = clientHandler.getProductById(id);
                if (produit != null) {
                    JOptionPane.showMessageDialog(this, produit.toString(), "Produit trouvé", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "Aucun produit trouvé avec l'ID " + id, "Produit introuvable", JOptionPane.WARNING_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Veuillez entrer un ID valide.", "Erreur", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erreur lors de la récupération du produit : " + ex.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
