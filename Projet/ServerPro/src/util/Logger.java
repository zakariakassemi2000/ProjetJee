package util;


import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {
    private static final String LOG_FILE = "application.log";
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static void log(String message) {
        try (FileWriter fw = new FileWriter(LOG_FILE, true);
             PrintWriter pw = new PrintWriter(fw)) {
            String timestamp = LocalDateTime.now().format(DATE_FORMATTER);
            pw.println(timestamp + " - " + message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void logError(String message, Throwable throwable) {
        try (FileWriter fw = new FileWriter(LOG_FILE, true);
             PrintWriter pw = new PrintWriter(fw)) {
            String timestamp = LocalDateTime.now().format(DATE_FORMATTER);
            pw.println(timestamp + " - ERROR - " + message);
            throwable.printStackTrace(pw);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
