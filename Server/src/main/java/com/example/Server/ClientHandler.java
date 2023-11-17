package com.example.Server;

import com.example.DataBaseManager.DatabaseManager;
import com.example.Product.Product;
import com.example.RequestResponse.Request;
import com.example.RequestResponse.Response;
import com.example.RequestResponse.ResponseStatus;
import com.example.User.Role;
import com.example.User.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.*;

public class ClientHandler extends Thread {
    private Socket clientSocket;
    private ObjectInputStream input;
    private ObjectOutputStream output;
    private DatabaseManager databaseManager;

    public ClientHandler(Socket clientSocket, DatabaseManager databaseManager) {
        this.clientSocket = clientSocket;
        this.databaseManager = databaseManager;  // Add this line
        try {
            this.input = new ObjectInputStream(clientSocket.getInputStream());
            this.output = new ObjectOutputStream(clientSocket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        try {
            while (true) {
                // Читаем запрос от клиента
                Request request = (Request) input.readObject();

                // Обрабатываем запрос
                handleRequest(request);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void handleRequest(Request request) {
        switch (request.getType()) {
            case LOGIN:
                handleLoginRequest(request);
                break;
            case REGISTER:
                handleRegisterRequest(request);
                break;
            case ADMIN:
                handleAdminRequest(request);
                break;
            case SUPERADMIN:
                handleAdminRequest(request);
                break;
            // Добавьте обработку других типов запросов по мере необходимости
            default:
                // Обработка неизвестного типа запроса
                Response unknownTypeResponse = new Response(ResponseStatus.FAILURE, Collections.emptyMap());
                sendResponse(unknownTypeResponse);
        }
    }

    private void handleAdminRequest(Request request) {
        String action = request.getData().get("action");

        switch (action) {
            case "viewProducts":
                handleViewProductsRequest();
                break;
            case "addProduct":
                handleAddProductRequest(request);
                break;
            case "editProduct":
                handleEditProductRequest(request);
                break;
            case "deleteProduct":
                handleDeleteProductRequest(request);
                break;
            default:
                // Обработка неизвестного действия
                Response unknownActionResponse = new Response(ResponseStatus.FAILURE, Collections.emptyMap());
                sendResponse(unknownActionResponse);
        }
    }

    private void handleViewProductsRequest() {
        List<Product> allProducts = databaseManager.getAllProducts();
        Response response = new Response(ResponseStatus.SUCCESS, createProductListDataMap(allProducts));
        sendResponse(response);
    }

    private void handleAddProductRequest(Request request) {
        String productName = request.getData().get("productName");
        int stockQuantity = Integer.parseInt(request.getData().get("stockQuantity"));
        int supplierId = Integer.parseInt(request.getData().get("supplierId"));

        // Получение максимального productId из базы данных
        int maxProductId = databaseManager.getMaxProductId();

        // Добавление нового продукта в базу данных
        databaseManager.addProduct(new Product(maxProductId + 1, productName, stockQuantity, supplierId));

        // Отправка ответа о успешном добавлении продукта
        Response response = new Response(ResponseStatus.SUCCESS, Collections.emptyMap());
        sendResponse(response);
    }

    private void handleEditProductRequest(Request request) {
        int productId = Integer.parseInt(request.getData().get("productId"));
        String productName = request.getData().get("productName");
        int stockQuantity = Integer.parseInt(request.getData().get("stockQuantity"));
        int supplierId = Integer.parseInt(request.getData().get("supplierId"));

        // Редактирование продукта в базе данных
        databaseManager.editProduct(productId, new Product(productName, stockQuantity, supplierId));

        // Отправка ответа о успешном редактировании продукта
        Response response = new Response(ResponseStatus.SUCCESS, Collections.emptyMap());
        sendResponse(response);
    }

    private void handleDeleteProductRequest(Request request) {
        int productId = Integer.parseInt(request.getData().get("productId"));

        // Удаление продукта из базы данных
        databaseManager.deleteProduct(productId);

        // Отправка ответа о успешном удалении продукта
        Response response = new Response(ResponseStatus.SUCCESS, Collections.emptyMap());
        sendResponse(response);
    }

    private List<Map<String, String>> createProductListDataMap(List<Product> products) {
        List<Map<String, String>> productList = new ArrayList<>();

        for (Product product : products) {
            productList.add(createProductDataMap(product));
        }

        return productList;
    }

    private Map<String, String> createProductDataMap(Product product) {
        Map<String, String> productData = new HashMap<>();
        productData.put("productId", String.valueOf(product.getProductID()));
        productData.put("productName", product.getProductName());
        productData.put("stockQuantity", String.valueOf(product.getStockQuantity()));
        productData.put("supplierId", String.valueOf(product.getSupplierID()));
        return productData;
    }

    private void handleSuperAdminRequest(Request request) {
        String action = request.getData().get("action");

        switch (action) {
            case "viewUsers":
                handleViewUsersRequest();
                break;
            case "blockUser":
                handleBlockUserRequest(request);
                break;
            case "unblockUser":
                handleUnblockUserRequest(request);
                break;
            case "deleteUser":
                handleDeleteUserRequest(request);
                break;
            default:
                // Обработка неизвестного действия
                Response unknownActionResponse = new Response(ResponseStatus.FAILURE, Collections.emptyMap());
                sendResponse(unknownActionResponse);
        }
    }

    private void handleViewUsersRequest() {
        List<User> allUsers = databaseManager.getAllUsers();
        Response response = new Response(ResponseStatus.SUCCESS, createUserListDataMap(allUsers));
        sendResponse(response);
    }

    private void handleBlockUserRequest(Request request) {
        int userId = Integer.parseInt(request.getData().get("userId"));

        // Блокировка пользователя в базе данных
        databaseManager.blockUser(userId);

        // Отправка ответа о успешной блокировке
        Response response = new Response(ResponseStatus.SUCCESS, Collections.emptyMap());
        sendResponse(response);
    }

    private void handleUnblockUserRequest(Request request) {
        int userId = Integer.parseInt(request.getData().get("userId"));

        // Разблокировка пользователя в базе данных
        databaseManager.unblockUser(userId);

        // Отправка ответа о успешной разблокировке
        Response response = new Response(ResponseStatus.SUCCESS, Collections.emptyMap());
        sendResponse(response);
    }

    private void handleDeleteUserRequest(Request request) {
        int userId = Integer.parseInt(request.getData().get("userId"));

        // Удаление пользователя из базы данных
        databaseManager.deleteUser(userId);

        // Отправка ответа о успешном удалении
        Response response = new Response(ResponseStatus.SUCCESS, Collections.emptyMap());
        sendResponse(response);
    }

    private List<Map<String, String>> createUserListDataMap(List<User> users) {
        List<Map<String, String>> userList = new ArrayList<>();

        for (User user : users) {
            userList.add(createUserDataMap(user));
        }

        return userList;
    }

    private void sendResponse(Response response) {
        try {
            // Отправляем ответ клиенту
            output.writeObject(response);
            output.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void handleRegisterRequest(Request request) {
        String username = request.getData().get("username");
        String password = request.getData().get("password");

        // Проверим, не существует ли уже пользователь с таким именем
        if (databaseManager.getUserByUsername(username) != null) {
            // Отправим ответ с сообщением о неудачной регистрации (пользователь уже существует)
            Response response = new Response(ResponseStatus.FAILURE, Collections.singletonMap("message", "User already exists"));
            sendResponse(response);
            return;
        }

        // Создаем нового пользователя
        User newUser = new User(username, password, Role.USER, false);

        // Сохраняем пользователя в базе данных
        databaseManager.addUser(newUser);

        // Отправляем ответ о успешной регистрации
        Response response = new Response(ResponseStatus.SUCCESS, Collections.emptyMap());
        sendResponse(response);
    }
    private void handleLoginRequest(Request request) {
        String username = request.getData().get("username");
        String password = request.getData().get("password");


        User user = databaseManager.getUserByUsername(username);

        Response response;

        if (user != null && user.getPassword().equals(password) && !user.isBlocked()) {
            response = new Response(ResponseStatus.SUCCESS, createUserDataMap(user));
        } else {
            response = new Response(ResponseStatus.FAILURE, Collections.emptyMap());
        }

        sendResponse(response);
    }

    private Map<String, String> createUserDataMap(User user) {
        Map<String, String> userData = new HashMap<>();
        userData.put("userID", String.valueOf(user.getUserID()));
        userData.put("username", user.getUsername());
        userData.put("role", user.getRole().getRoleName());
        userData.put("isAdmin", String.valueOf(user.isAdmin()));
        return userData;
    }
}
