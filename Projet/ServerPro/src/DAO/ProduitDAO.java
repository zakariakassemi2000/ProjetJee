package DAO;

import model.Produit;
import java.util.List;

public interface ProduitDAO {
    void ajouterProduit(Produit produit);
    Produit getProduitById(int id);
    List<Produit> getTousProduits();
    void mettreAJourProduit(Produit produit);
    void supprimerProduit(int id);
	List<Produit> getProduitById(List<Integer> ids);
}
