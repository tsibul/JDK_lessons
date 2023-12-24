package hw2.server;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TextRepository implements Repo {

    @Override
    public String getLog() {
        String serverLog = "";
        try {
            FileReader reader = new FileReader("./src/hw2/serverlog.txt");
            BufferedReader br = new BufferedReader(reader);
            String line;
            while ((line = br.readLine()) != null) {
                serverLog = serverLog + line + "\n";
            }
            br.close();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        return serverLog;
    }

    @Override
    public void updateLog(String message) {
        try {
            FileWriter writer = new FileWriter("./src/hw2/serverlog.txt", true);
            writer.write(message + "\n");
            writer.close();
//            serverLog.setText("");
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }


    }
}
