import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Logger {
    private static Logger instance;
    private BufferedWriter writer;
    private String fileName;

    // Private singleton constructor
    private Logger() {
        fileName = null;
    }

    // Singleton instance getter
    public static Logger getInstance() {
        if (instance == null) {
            synchronized (Logger.class) {
                if (instance == null) {
                    instance = new Logger();
                }
            }
        }
        return instance;
    }

    // Method to open the file
    private void openFile() {
        try {
            writer = new BufferedWriter(new FileWriter(fileName, true)); // Open in append mode
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to set a new file name
    public void setFileName(String fileName) {
        close();
        this.fileName = fileName;
        openFile();
    }

    // Method to write a log message
    public void write(String message) {
        if (writer != null) {
            try {
                writer.write(message);
                writer.newLine();
                writer.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // Method to close the writer
    public void close() {
        if (writer != null) {
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}