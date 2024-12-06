package client;

import model.Produit;

import java.io.*;
import java.net.Socket;
import java.util.List;

public class ClientHandler {
    private final String serverAddress;
    private final int serverPort;

    public ClientHandler(String serverAddress, int serverPort) {
        this.serverAddress = serverAddress;
        this.serverPort = serverPort;
    }
  
    @SuppressWarnings("unchecked")
	public List<Produit> getProducts() throws IOException, ClassNotFoundException {
        try (Socket socket = new Socket(serverAddress, serverPort);
             ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
             ObjectInputStream in = new ObjectInputStream(socket.getInputStream())) {

            out.writeObject("LISTE");
            return (List<Produit>) in.readObject();
        }
    }
    public Produit getProductById(int ids) throws IOException, ClassNotFoundException {
        try (Socket socket = new Socket(serverAddress, serverPort);
             ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
             ObjectInputStream in = new ObjectInputStream(socket.getInputStream())) {

            out.writeObject("LISTE_PAR_ID");
            out.writeObject(ids);
            return (Produit) in.readObject();
        }
    }
    
    
    
    
   


    public String addProduct(Produit produit) throws IOException, ClassNotFoundException {
        try (Socket socket = new Socket(serverAddress, serverPort);
             ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
             ObjectInputStream in = new ObjectInputStream(socket.getInputStream())) {

            out.writeObject("AJOUTER");
            out.writeObject(produit);
            return (String) in.readObject();
        }
    }
    
    
}
