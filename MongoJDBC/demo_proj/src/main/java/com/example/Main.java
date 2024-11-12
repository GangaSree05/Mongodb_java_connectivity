package com.example;

import com.mongodb.client.*;
import org.bson.Document;

public class Main {
    public static void main(String[] args) {
        // Create a MongoDB client
        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
        
        // Get the database
        MongoDatabase database = mongoClient.getDatabase("product_catalog");
        
        // Get the collection
        MongoCollection<Document> collection = database.getCollection("pc");
        
        // Create documents to insert
        Document student1 = new Document("name", "A4 sheet")
            .append("catagory", "Stationary")
            .append("price",50);

        Document student2 = new Document("name", "Scale")
            .append("catagory", "stationary")
            .append("price", 10);
        
        // Insert documents
        collection.insertOne(student1);
        collection.insertOne(student2);
        
        System.out.println("Documents inserted successfully!");

        // List the documents
        FindIterable<Document> documents = collection.find();
        for (Document doc : documents) {
            System.out.println(doc.toJson());
        }

        // Close the connection
        mongoClient.close();
    }
}