package com.example.Server;

import com.example.DataBaseManager.DatabaseManager;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {
    private DatabaseManager database;
    private List<ClientHandler> clients;
    private ServerSocket serverSocket;

    public Server() {
        database = new DatabaseManager();
        clients = new ArrayList<>();
        start();
    }

    public void start() {
        // Реализация запуска сервера
    }

    public void stop() {
        // Реализация остановки сервера
    }

    private void acceptConnections() {
        // Реализация принятия подключений
    }

    private void handleClient(Socket clientSocket) {
        // Реализация обработки клиента
    }
}
