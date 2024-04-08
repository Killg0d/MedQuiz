/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edu.questionaire;

/**
 *
 * @author Tarun
 */
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class AuthenticationManager {

    private final MongoCollection<Document> usersCollection;

    public AuthenticationManager() {
        String uri = "mongodb://localhost:27017";
        try {
            MongoClient mongoClient = MongoClients.create(uri);
            MongoDatabase database = mongoClient.getDatabase("MedMCQA");
            usersCollection = database.getCollection("Accounts");
        } catch (Exception e) {
            throw new RuntimeException("Failed to initialize MongoDB connection: " + e.getMessage());
        }
    }

    public boolean authenticateUser(String username, String password) {
        Document query = new Document("username", username)
                            .append("password", password);
        Document user = usersCollection.find(query).first();
        return user != null;
    }

    public static void main(String[] args) {
        AuthenticationManager authManager = new AuthenticationManager();
        String username = "username@1";
        String password = "password@1";
        if (authManager.authenticateUser(username, password)) {
            System.out.println("User authentication successful.");
        } else {
            System.out.println("Invalid username or password.");
        }
    }
}
