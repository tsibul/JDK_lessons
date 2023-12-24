package hw2.client;

public interface View {
    void connectedToServer();
    void disconnectedFromServer();
    void receiveMessage(String message);
}