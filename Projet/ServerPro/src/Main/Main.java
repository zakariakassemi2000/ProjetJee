package Main;

import model.Produit;
public class Main {
    public static void main(String[] args) {
        // Création d'un produit
        Produit produit = new Produit(1, "Laptop", "Électronique", 50, 899.99);

        // Afficher les détails du produit
        System.out.println(produit);

        // Modifier la quantité du produit
        produit.setQuantite(45);
        System.out.println("Nouvelle quantité : " + produit.getQuantite());
    }
}
