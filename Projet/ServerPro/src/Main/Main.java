package Main;

import model.Produit;
public class Main {
    public static void main(String[] args) {
        // Cr�ation d'un produit
        Produit produit = new Produit(1, "Laptop", "�lectronique", 50, 899.99);

        // Afficher les d�tails du produit
        System.out.println(produit);

        // Modifier la quantit� du produit
        produit.setQuantite(45);
        System.out.println("Nouvelle quantit� : " + produit.getQuantite());
    }
}
