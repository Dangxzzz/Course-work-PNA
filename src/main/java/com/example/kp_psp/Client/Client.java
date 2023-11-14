package com.example.kp_psp.Client;

import com.example.kp_psp.RequestResponse.Request;
import com.example.kp_psp.RequestResponse.Response;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client {
    private ObjectInputStream input;
    private ObjectOutputStream output;
    private Socket socket;

    public Client() {
        // Реализация конструктора клиента
    }

    public void start() {
        // Реализация метода запуска клиента
    }

    public void stop() {
        // Реализация метода остановки клиента
    }

    public void sendRequest(Request request) {
        // Реализация метода отправки запроса на сервер
    }

    public Response receiveResponse() {
        // Реализация метода приема ответа от сервера
        return null;
    }

    public void displayResponse(Response response) {
        // Реализация метода отображения ответа пользователю
    }
}
