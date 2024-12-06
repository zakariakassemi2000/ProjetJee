package Server;



import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class InventoryServer {
    private static final int PORT = 145; // Port pour le serveur socket

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Serveur d�marr� sur le port " + PORT);

            // Attente des connexions client
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Connexion accept�e : " + clientSocket.getInetAddress());

                // D�marrer un thread pour g�rer la requ�te client
                new Thread(new RequestHandler(clientSocket)).start();
            }
        } catch (IOException e) {
            System.err.println("Erreur lors du d�marrage du serveur : " + e.getMessage());
        }
    }
}
