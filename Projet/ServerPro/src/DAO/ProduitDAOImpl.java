package DAO;

import model.Produit;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DatabaseUtil;
import util.Logger;

public class ProduitDAOImpl implements ProduitDAO {
    @Override
    public void ajouterProduit(Produit produit) {
        String query = "INSERT INTO produit (nom, categorie, quantite, prix) VALUES (?, ?, ?, ?)";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, produit.getNom());
            ps.setString(2, produit.getCategorie());
            ps.setInt(3, produit.getQuantite());
            ps.setDouble(4, produit.getPrix());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            Logger.logError("Erreur lors de l'ajout du produit : " + produit, e);
        }
    }

    @Override
    public Produit getProduitById(int id) {
        String query = "SELECT * FROM produit WHERE id = ?";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Produit(
                        rs.getInt("id"),
                        rs.getString("nom"),
                        rs.getString("categorie"),
                        rs.getInt("quantite"),
                        rs.getDouble("prix")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
            Logger.logError("Erreur lors de Lister Les produits  : ", e);
        }
        return null;
    }

    @Override
    public List<Produit> getTousProduits() {
        List<Produit> produits = new ArrayList<>();
        String query = "SELECT * FROM produit";
        try (Connection connection = DatabaseUtil.getConnection();
             Statement st = connection.createStatement();
             ResultSet rs = st.executeQuery(query)) {
            while (rs.next()) {
                produits.add(new Produit(
                        rs.getInt("id"),
                        rs.getString("nom"),
                        rs.getString("categorie"),
                        rs.getInt("quantite"),
                        rs.getDouble("prix")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            Logger.logError("Erreur lors de lister Les Produits : " , e);
        }
        return produits;
    }

    @Override
    public void mettreAJourProduit(Produit produit) {
        String query = "UPDATE produit SET nom = ?, categorie = ?, quantite = ?, prix = ? WHERE id = ?";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, produit.getNom());
            ps.setString(2, produit.getCategorie());
            ps.setInt(3, produit.getQuantite());
            ps.setDouble(4, produit.getPrix());
            ps.setInt(5, produit.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            Logger.logError("Erreur lors de la mise a jour  : " + produit, e);
        }
    }

    @Override
    public void supprimerProduit(int id) {
        String query = "DELETE FROM produit WHERE id = ?";
        try (Connection connection =DatabaseUtil.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            Logger.logError("Erreur lors de la supression des produis : " ,e);
        }
    }

	
	public List<Produit> getProduitById(List<Integer> ids) {
	    List<Produit> produits = new ArrayList<>();

	    if (ids == null || ids.isEmpty()) {
	        return produits; // Return an empty list if no IDs are provided
	    }

	    // Construct a dynamic SQL query with placeholders for the IDs
	    StringBuilder queryBuilder = new StringBuilder("SELECT * FROM produit WHERE id IN (");
	    queryBuilder.append("?,".repeat(ids.size()));
	    queryBuilder.setLength(queryBuilder.length() - 1); // Remove the last comma
	    queryBuilder.append(")");

	    String query = queryBuilder.toString();

	    try (Connection connection = DatabaseUtil.getConnection();
	         PreparedStatement ps = connection.prepareStatement(query)) {

	        // Set the IDs in the query
	        for (int i = 0; i < ids.size(); i++) {
	            ps.setInt(i + 1, ids.get(i));
	        }

	        ResultSet rs = ps.executeQuery();

	        // Fetch products from the result set
	        while (rs.next()) {
	            produits.add(new Produit(
	                    rs.getInt("id"),
	                    rs.getString("nom"),
	                    rs.getString("categorie"),
	                    rs.getInt("quantite"),
	                    rs.getDouble("prix")
	            ));
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        Logger.logError("Erreur lors de la récupération des produits par ID : ", e);
	    }

	    return produits;
	}

	
}
