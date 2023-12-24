package hw2.client;


import hw2.server.Server;

import java.time.LocalTime;

public class Client {

    private View view;
    private String name;
    private Server server;
    private boolean connected;

    public String getName() {
        return name;
    }

    public Client(View view, Server server) {
        this.view = view;
        this.server = server;
    }

    public void sendMessage(String message) {
        if (connected) {
            if (!message.isEmpty()) {
                server.sendMessage(LocalTime.now().withNano(0) + " " + name + ": " + message);
            }
        } else {
            showOnWindow(LocalTime.now().withNano(0) + " server disconnected");
        }
    }

    public boolean connectToServer(String name) {
        this.name = name;
        if (server.connectUser(this)) {
            showOnWindow(LocalTime.now().withNano(0) + " you've successfully connected!");
            connected = true;
            String log = server.getLog();
            if (log != null) {
                showOnWindow(log);
            }
            return true;
        } else {
            showOnWindow(LocalTime.now().withNano(0) + "server disconnected");
            return false;
        }
    }

    public void disconnectFromServer() {
        if (connected) {
            connected = false;
            server.disconnectUser(this);
            view.disconnectedFromServer();
            showOnWindow(LocalTime.now().withNano(0) + " You were disconnected from server");
        }
    }

    public void answerFromServer(String messageFromServer) {
        showOnWindow(messageFromServer);
    }

    private void showOnWindow(String text) {
        view.receiveMessage(text + "\n");
    }


}
