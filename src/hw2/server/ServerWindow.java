package hw2.server;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;




public class ServerWindow extends JFrame {
    private static final int POS_X = 500;
    private static final int POS_Y = 550;
    private static final int WIDTH = 400;
    private static final int HEIGHT = 300;

    private final JButton btnStart = new JButton("Start");
    private final JButton btnStop = new JButton("stop");

    private final JTextArea serverLog = new JTextArea();
    private Server server;



    public ServerWindow(Repo repo) {

        this.server = new Server(repo, this);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(POS_X, POS_Y, WIDTH, HEIGHT);
        setResizable(false);
        setTitle("Chat server");
        setAlwaysOnTop(true);
        setLayout(new BorderLayout());

        serverLog.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(serverLog);
        scrollPane.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        JPanel btnPanel = createButtonPanel();
        btnPanel.setPreferredSize(new Dimension(WIDTH, 30));

        add(scrollPane, BorderLayout.CENTER);
        add(btnPanel, BorderLayout.SOUTH);

        pack();
        setVisible(true);
        btnStop.addActionListener(e -> {
            server.serverStop();
        });
        btnStart.addActionListener(e -> {
            serverLog.setText("");
            server.serverStart();
        });
    }
    private JPanel createButtonPanel(){
        JPanel buttonPanel = new JPanel(new GridLayout(1, 2));
        buttonPanel.add(btnStart);
        buttonPanel.add(btnStop);
        return buttonPanel;
    }

    public Server getConnection() {
        return server;
    }

    public void receiveMessage (String message){
        serverLog.append(message + "\n");
    }
}
