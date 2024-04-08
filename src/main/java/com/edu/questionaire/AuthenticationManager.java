package com.edu.questionaire;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;

public class AuthenticationManager {

    private final MongoCollection<Document> usersCollection;

    // Constructor to initialize MongoDB connection and get the users collection
    public AuthenticationManager() {
        String uri = "mongodb://localhost:27017";
        try {
            // Creating MongoDB client
            MongoClient mongoClient = MongoClients.create(uri);
            // Accessing the MedMCQA database
            MongoDatabase database = mongoClient.getDatabase("MedMCQA");
            // Getting the "Accounts" collection from the database
            usersCollection = database.getCollection("Accounts");
        } catch (Exception e) {
            // If there's an error, throw a runtime exception
            throw new RuntimeException("Failed to initialize MongoDB connection: " + e.getMessage());
        }
    }

    // Method to update the score of a user in the database
    public boolean UpdateScore(int marks) {
        try {
            // Get username and password from LoginDetails class
            String username = LoginDetails.username, password = LoginDetails.password;

            // Check if username or password is empty
            if (username.isEmpty() || password.isEmpty()) {
                System.out.println("Cannot Update Empty String Error");
                return false;
            } else {
                // Create a filter for username and password
                Document filter = new Document();
                filter.append("username", username);
                filter.append("password", password);

                // Create an update to set the new value of the score field
                Document update = new Document("$set", new Document("score", marks));

                // Update the document that matches the filter
                UpdateResult result = usersCollection.updateOne(filter, update);

                // Check if the update was successful
                return result.getModifiedCount() > 0;
            }
        } catch (NullPointerException e) {
            System.out.println("String is empty");
            return false;
        }
    }

    // Method to authenticate user based on username and password
    public boolean authenticateUser(String username, String password) {
        // Create a query document to find the user in the collection
        Document query = new Document("username", username)
                .append("password", password);
        // Find the user document based on the query
        Document user = usersCollection.find(query).first();
        // Return true if user exists, false otherwise
        return user != null;
    }

    // Main method for testing authentication
    public static void main(String[] args) {
        // Create an instance of AuthenticationManager
        AuthenticationManager authManager = new AuthenticationManager();
        // Test username and password
        String username = "username@1";
        String password = "password@1";
        // Authenticate the user and print result
        if (authManager.authenticateUser(username, password)) {
            System.out.println("User authentication successful.");
        } else {
            System.out.println("Invalid username or password.");
        }
    }
}
