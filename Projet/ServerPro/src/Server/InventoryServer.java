package Server;



import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class InventoryServer {
    private static final int PORT = 145; // Port pour le serveur socket

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Serveur démarré sur le port " + PORT);

            // Attente des connexions client
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Connexion acceptée : " + clientSocket.getInetAddress());

                // Démarrer un thread pour gérer la requête client
                new Thread(new RequestHandler(clientSocket)).start();
            }
        } catch (IOException e) {
            System.err.println("Erreur lors du démarrage du serveur : " + e.getMessage());
        }
    }
}
