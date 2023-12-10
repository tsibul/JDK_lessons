package hw1;

import hw1.client.ClientGui;
import hw1.server.ServerWindow;

public class Main {
    public static void main(String[] args) {
        ServerWindow serverWindow = new ServerWindow();
        new ClientGui(serverWindow);
        new ClientGui(serverWindow);
    }
}