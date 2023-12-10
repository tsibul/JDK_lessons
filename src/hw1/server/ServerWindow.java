package hw1.server;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    private String message;
    private boolean isServerWorking;

    private List<ServerLogObserver> observers = new ArrayList<>();

    public void addObserver(ServerLogObserver observer) {
        observers.add(observer);
    }

    public String getMessage() {
        return message;
    }
    public boolean isServerWorking() {
        return isServerWorking;
    }

    public void setMessage(String message) {
        this.message = message;
        serverLog.append(message + "\n");
        }

    public void updateServerLog(String logUpdate) {
        for (ServerLogObserver observer : observers) {
            observer.updateServerLog(logUpdate);
        }
    }
    public ServerWindow(){

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
        isServerWorking = false;
        btnStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isServerWorking) {
                    serverLog.append(LocalTime.now().withNano(0) + " Server stopped \n");
                    observers.clear();
                }
                isServerWorking = false;
            }
        });
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!isServerWorking){
                serverLog.append(LocalTime.now().withNano(0) + " Server started \n");
                }
                isServerWorking = true;
            }
        });
    }

    private JPanel createButtonPanel(){
        JPanel buttonPanel = new JPanel(new GridLayout(1, 2));
        buttonPanel.add(btnStart);
        buttonPanel.add(btnStop);
        return buttonPanel;
    }


}
