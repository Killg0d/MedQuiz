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
public class MongoConnect {
    private MongoConnect conn;
	public MongoClient connect()
	{
		MongoClient mongoclient= MongoClients.create("mongodb://localhost:27017");
		System.out.println("Created mongo connection sucessfully");
		return mongoclient;
	}
	public static void main(String[] args) {
		//create a mongodb client
		MongoConnect conn=new MongoConnect();
		conn.connect();
                
	}

}

