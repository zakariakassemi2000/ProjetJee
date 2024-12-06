package Server;

	import DAO.ProduitDAOImpl;
	import model.Produit;

	import java.io.*;
	import java.net.Socket;
	import java.util.List;

	public class RequestHandler implements Runnable {
	    private final Socket clientSocket;
	    private final ProduitDAOImpl produitDAO;

	    public RequestHandler(Socket clientSocket) {
	        this.clientSocket = clientSocket;
	        this.produitDAO = new ProduitDAOImpl(); // DAO pour interagir avec la base de données
	    }

	    @Override
	    public void run() {
	        try (ObjectInputStream input = new ObjectInputStream(clientSocket.getInputStream());
	             ObjectOutputStream output = new ObjectOutputStream(clientSocket.getOutputStream())) {

	            // Lecture de la requête client
	            String action = (String) input.readObject();
	            System.out.println("Action demandée : " + action);

	            switch (action) {
	                case "AJOUTER":
	                    Produit nouveauProduit = (Produit) input.readObject();
	                    produitDAO.ajouterProduit(nouveauProduit);
	                    output.writeObject("Produit ajouté avec succès !");
	                    break;

	                case "MODIFIER":
	                    Produit produitModifie = (Produit) input.readObject();
	                    produitDAO.mettreAJourProduit(produitModifie);
	                    output.writeObject("Produit modifié avec succès !");
	                    break;

	                case "SUPPRIMER":
	                    int id = input.readInt();
	                    produitDAO.supprimerProduit(id);
	                    output.writeObject("Produit supprimé avec succès !");
	                    break;

	                case "LISTE":
	                    List<Produit> produits = produitDAO.getTousProduits();
	                    output.writeObject(produits); // Envoi de la liste au client
	                    break;

	                case "LISTE_PAR_ID":
	                    try {
	                        // Receive a list of IDs from the client
	                        @SuppressWarnings("unchecked")
							List<Integer> id1 = (List<Integer>) input.readObject();

	                        // Fetch products by their IDs
	                        List<Produit> produitsParId = (List<Produit>) produitDAO.getProduitById(id1);

	                        // Send the list of products back to the client
	                        output.writeObject(produitsParId);
	                    } catch (Exception e) {
	                        output.writeObject("Erreur lors de la récupération des produits par ID : " + e.getMessage());
	                    }
	                    break;

	                    
	                default:
	                    output.writeObject("Action inconnue !");
	                    break;
	            }
	        } catch (IOException | ClassNotFoundException e) {
	            System.err.println("Erreur lors du traitement de la requête : " + e.getMessage());
	        } finally {
	            try {
	                clientSocket.close();
	            } catch (IOException e) {
	                System.err.println("Erreur lors de la fermeture du socket client : " + e.getMessage());
	            }
	        }
	    }
	}
