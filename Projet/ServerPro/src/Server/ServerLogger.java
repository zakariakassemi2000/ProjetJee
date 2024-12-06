package Server;



import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class ServerLogger {
    private static final Logger logger = Logger.getLogger("ServerLogger");

    static {
        try {
            FileHandler fileHandler = new FileHandler("server/logs/server.log", true);
            fileHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(fileHandler);
        } catch (IOException e) {
            System.err.println("Erreur lors de l'initialisation des logs : " + e.getMessage());
        }
    }

    public static void logInfo(String message) {
        logger.info(message);
    }

    public static void logError(String message, Exception e) {
        logger.severe(message + " - " + e.getMessage());
    }
}
