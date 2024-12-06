package DAO;



import model.Produit;

import java.util.List;

public class TestProduitDAO {
    public static void main(String[] args) {
        ProduitDAO produitDAO = new ProduitDAOImpl();

        // Ajouter un produit
        Produit nouveauProduit = new Produit(0, "Produit D", "Cat�gorie 3", 30, 12.49);
        produitDAO.ajouterProduit(nouveauProduit);
        System.out.println("Produit ajout�.");

        // R�cup�rer un produit par ID
        Produit produit = produitDAO.getProduitById(1);
        if (produit != null) {
            System.out.println("Produit r�cup�r� : " + produit);
        }

        // Mettre � jour un produit
        produit.setQuantite(300);
        produitDAO.mettreAJourProduit(produit);
        System.out.println("Produit mis � jour.");

        // R�cup�rer tous les produits
        List<Produit> produits = produitDAO.getTousProduits();
        System.out.println("Liste des produits :");
        produits.forEach(System.out::println);

        // Supprimer un produit
        produitDAO.supprimerProduit(2);
        System.out.println("Produit supprim�.");
    }
}
