package hw1.client;

import hw1.server.ServerLogObserver;
import hw1.server.ServerWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.util.Objects;

public class ClientGui extends JFrame implements ServerLogObserver{
    private static final int WIDTH = 400;
    private static final int HEIGHT = 300;

    private final JTextArea log = new JTextArea();

    private final JPanel panelTop = new JPanel(new GridLayout(2, 3));
    private final JTextField tfIPAddress = new JTextField("127.0.0.1");
    private final JTextField tfPort = new JTextField("8189");
    private final JTextField tfLogin = new JTextField("login");
    private final JPasswordField tfPassword = new JPasswordField("123456");
    private final JButton btnLogin = new JButton("Login");

    private final JPanel panelBottom = new JPanel(new BorderLayout());
    private final JTextField tfMessage = new JTextField();
    private final JButton btnSend = new JButton("Send");

    @Override
    public void updateServerLog(String logUpdate) {
        if(!Objects.equals(logUpdate.split(" ")[1], tfLogin.getText())){
            log.append(logUpdate + "\n");
        }
    }

    public ClientGui(ServerWindow serverWindow) {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(WIDTH, HEIGHT);
        setTitle("Chat Client");

        panelTop.add(tfIPAddress);
        panelTop.add(tfPort);
        panelTop.add(tfLogin);
        panelTop.add(tfPassword);
        panelTop.add(btnLogin);
        add(panelTop, BorderLayout.NORTH);

        panelBottom.add(tfMessage, BorderLayout.CENTER);
        panelBottom.add(btnSend, BorderLayout.EAST);
        add(panelBottom, BorderLayout.SOUTH);

        log.setEditable(false);
        JScrollPane scrollLog = new JScrollPane(log);
        add(scrollLog);

        setVisible(true);
        btnSend.setVisible(false);

        btnLogin.addActionListener(e -> {
            if (serverWindow.isServerWorking()) {
                panelTop.setVisible(false);
                btnSend.setVisible(true);
                serverWindow.setMessage(LocalTime.now().withNano(0) + " " + tfLogin.getText() + " connected");
                serverWindow.updateServerLog(LocalTime.now().withNano(0) + " " + tfLogin.getText() + " connected");
                serverWindow.addObserver(ClientGui.this);
                log.append(LocalTime.now().withNano(0) + " you have connected successfully \n");
            } else {
                log.append(LocalTime.now().withNano(0) + " server down \n");
            }
        });

        btnSend.addActionListener(e -> {
            if (serverWindow.isServerWorking()) {
                String newMessage = LocalTime.now().withNano(0) + " " + tfLogin.getText() + " says: " +
                        tfMessage.getText();
                serverWindow.setMessage(newMessage);
                serverWindow.updateServerLog(newMessage);
                log.append(newMessage + "\n");
            } else {
                log.append(LocalTime.now().withNano(0) + " server down \n");
                panelTop.setVisible(true);
                btnSend.setVisible(false);
            }
        });
    }
}



