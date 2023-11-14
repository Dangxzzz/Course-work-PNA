package com.example.kp_psp.Client;

import com.example.kp_psp.ClientUIApp.ClientUIApp;

import static javafx.application.Application.launch;

public class ClientApp {

    public static void main(String[] args) {
        ClientController clientController = new ClientController();
        clientController.startClient();

        // Добавьте код для запуска JavaFX интерфейса пользователя
        launch(ClientUIApp.class, args);
    }
}
