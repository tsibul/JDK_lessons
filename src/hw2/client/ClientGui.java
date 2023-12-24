package hw2.client;

import hw2.server.ServerWindow;

import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import java.awt.*;
import java.awt.event.*;

public class ClientGui extends JFrame implements View {
    private static final int WIDTH = 400;
    private static final int HEIGHT = 300;

    private Client client;


    private final JTextArea log = new JTextArea();
    JPanel panelTop, panelBottom;
    JTextField tfIPAddress;
    JTextField tfPort, tfLogin, tfMessage;
    JPasswordField tfPassword;
    JButton btnLogin, btnSend, btnDisconnect;

    public ClientGui(ServerWindow serverWindow) {
        setting(serverWindow);
        createPanel();
        setVisible(true);
    }

    private void createPanel() {
        add(createPanelTop(), BorderLayout.NORTH);
        add(createPanelBottom(), BorderLayout.SOUTH);
        add(createLogPanel());
        this.btnDisconnect.setVisible(false);
        this.btnSend.setVisible(false);
    }

    public void sendMessage(){
        client.sendMessage(tfMessage.getText());
        tfMessage.setText("");
    }

    private void setting(ServerWindow server) {
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setTitle("Chat client");
        setLocation(server.getX() + 450, server.getY());
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        client = new Client( this, server.getConnection());
    }

    private Component createLogPanel() {
        log.setEditable(false);
        return new JScrollPane(log);
    }

    private Component createPanelTop() {
     this.panelTop = new JPanel(new GridLayout(2, 3));
     this.tfIPAddress = new JTextField("127.0.0.1");
     this.tfPort = new JTextField("8189");
     this.tfLogin = new JTextField("login");
     this.tfPassword = new JPasswordField("123456");
     this.btnLogin = new JButton("Login");
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                connectedToServer();
            }
        });
        panelTop.add(tfIPAddress);
        panelTop.add(tfPort);
        panelTop.add(tfLogin);
        panelTop.add(tfPassword);
        panelTop.add(btnLogin);
        return panelTop;
    }

    private Component createPanelBottom() {
        this.panelBottom = new JPanel(new BorderLayout());
        this.tfMessage = new JTextField();
        tfMessage.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyChar() == '\n') {
                    sendMessage();
                }
            }
        });
        this.btnSend = new JButton("Send");
        btnSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage();
                tfMessage.setText("");
            }
        });
        this.btnDisconnect = new JButton("Disconnect");
        btnDisconnect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                disconnectedFromServer();
            }
        });
        this.btnDisconnect.setBackground(ColorUIResource.red);
        panelBottom.add(tfMessage, BorderLayout.CENTER);
        panelBottom.add(btnSend, BorderLayout.EAST);
        panelBottom.add(btnDisconnect, BorderLayout.WEST);
        return panelBottom;
    }

    @Override
    protected void processWindowEvent(WindowEvent e) {
        super.processWindowEvent(e);
        if (e.getID() == WindowEvent.WINDOW_CLOSING){
            disconnectedFromServer();
        }
    }


    @Override
    public void connectedToServer() {
        if (client.connectToServer(tfLogin.getText())){
            panelTop.setVisible(false);
            btnDisconnect.setVisible(true);
            btnSend.setVisible(true);
        }
    }

    @Override
    public void disconnectedFromServer() {
        panelTop.setVisible(true);
        btnDisconnect.setVisible(false);
        btnSend.setVisible(false);
        client.disconnectFromServer();
        log.setText("");
    }

    @Override
    public void receiveMessage(String message)
    {
        log.append(message);
    }
}



