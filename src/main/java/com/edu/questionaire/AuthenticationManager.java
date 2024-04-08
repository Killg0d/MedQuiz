
package com.edu.questionaire;


import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.UpdateResult;
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

    public boolean UpdateScore(int marks) {
        try{
            String username = LoginDetails.username, password = LoginDetails.password;
        
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
        }
        catch(NullPointerException e)
        {
            System.out.println("String is empty");
            return false;
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
