package hw2.server;

import hw2.client.Client;

import java.time.LocalTime;
import java.util.HashSet;

public class Server {
    private HashSet<Client> clientList;
    private Boolean serverOn;
    private Repo repo;
    private ServerWindow serverWindow;

    public Server(Repo repo, ServerWindow serverWindow) {
        this.serverOn = false;
        this.clientList = new HashSet<>();
        this.repo = repo;
        this.serverWindow = serverWindow;
    }

    public boolean connectUser(Client user) {
        if (serverOn) {
            String messageFromServer = LocalTime.now().withNano(0) + " " + user.getName() + " connected";
            clientList.forEach(client -> client.answerFromServer(messageFromServer));
            repo.updateLog(messageFromServer);
            clientList.add(user);
            serverWindow.receiveMessage(messageFromServer);
            return true;
        }
        return false;
    }

    public void disconnectUser(Client user) {
        clientList.remove(user);
        String messageFromServer = LocalTime.now().withNano(0) + " " + user.getName() + " disconnected";
        clientList.forEach(client -> client.answerFromServer(messageFromServer));
        repo.updateLog(messageFromServer);
        serverWindow.receiveMessage(messageFromServer);
    }

    public String getLog() {
        return repo.getLog();
    }

    public void sendMessage(String message) {
        clientList.forEach(client -> client.answerFromServer(message));
        repo.updateLog(message);
        serverWindow.receiveMessage(message);
    }

    public void serverStart() {
        if (!serverOn) {
            String messageFromServer = LocalTime.now().withNano(0) + " server started";
            serverOn = true;
            repo.updateLog(messageFromServer);
            serverWindow.receiveMessage(repo.getLog());
            serverWindow.receiveMessage(messageFromServer);
        }
    }

    public void serverStop() {
        if (serverOn) {
            HashSet<Client> clientListCopy = (HashSet<Client>) clientList.clone();
            clientListCopy.forEach(Client::disconnectFromServer);
            String messageFromServer = LocalTime.now().withNano(0) + " server stopped";
            serverOn = false;
            clientList.clear();
            repo.updateLog(messageFromServer);
            serverWindow.receiveMessage(messageFromServer);
        }
    }
}
