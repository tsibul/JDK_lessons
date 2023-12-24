package hw2;

import hw2.client.ClientGui;
import hw2.server.ServerWindow;
import hw2.server.TextRepository;

public class Main {
    public static void main(String[] args) {
        TextRepository repo = new TextRepository();
        ServerWindow serverWindow = new ServerWindow(repo);
        ClientGui clientGui1 = new ClientGui(serverWindow);
        ClientGui clientGui2 = new ClientGui(serverWindow);
    }
}