/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edu.questionaire;

import static com.mongodb.MongoClientSettings.getDefaultCodecRegistry;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;
import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;


import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Aggregates;


import com.mongodb.client.model.Sorts;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuickStart {
    
    public List<Question> getQuestions()
    {
        List<Question> questionList = new ArrayList<>();
        CodecProvider pojoCodecProvider = PojoCodecProvider.builder().automatic(true).build();
        CodecRegistry pojoCodecRegistry = fromRegistries(getDefaultCodecRegistry(), fromProviders(pojoCodecProvider));
        // Replace the placeholder with your MongoDB deployment's connection string
        String uri = "mongodb://localhost:27017";

        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("MedMCQA").withCodecRegistry(pojoCodecRegistry);
            MongoCollection<Question> collection = database.getCollection("train", Question.class);

            // Sample 5 random documents and sort them by _id
            try (MongoCursor<Question> cursor = collection.aggregate(
                    Arrays.asList(Aggregates.sample(5),
                            Aggregates.sort(Sorts.ascending("_id"))))
                    .iterator()) {
                while (cursor.hasNext()) {
                    questionList.add(cursor.next());
                }
                System.out.println(questionList);
            }
        } catch (Exception e) {
            System.out.println("An error occurred while retrieving questions: " + e.getMessage());
        }

        return questionList;
         
    }
    public static void main( String[] args ) {
        new QuickStart().getQuestions();
    }
}