package com.ding.mongo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.bson.Document;
import org.junit.Test;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoTest {
@Test
public void MongoCollectionTest(){
		   try{   
		       // 连接到 mongodb 服务
		       MongoClient mongoClient = new MongoClient( "192.168.157.133" , 27017 );
		       
		       // 连接到数据库
		       MongoDatabase mongo = mongoClient.getDatabase("col");  
		       System.out.println("Connect to database successfully");
		       MongoCollection<Document> collection = mongo.getCollection("test");
		        System.out.println("集合 选择成功");
         
		        
		      }catch(Exception e){
		        System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		     }
}

@Test
public void  insertTest(){
	
	  try{   
	       // 连接到 mongodb 服务
	       MongoClient mongoClient = new MongoClient( "192.168.157.133" , 27017 );
	       
	       // 连接到数据库
	       MongoDatabase mongo = mongoClient.getDatabase("col");  
	       System.out.println("Connect to database successfully");
	       MongoCollection<Document> collection = mongo.getCollection("test");
	       //  System.out.println("集合 test 选择成功");
	         //插入文档  
	         /** 
	         * 1. 创建文档 org.bson.Document 参数为key-value的格式 
	         * 2. 创建文档集合List<Document> 
	         * 3. 将文档集合插入数据库集合中 mongoCollection.insertMany(List<Document>) 插入单个文档可以用 mongoCollection.insertOne(Document) 
	         * */
	         Document document = new Document("title", "MongoDB").  
	         append("description", "database").  
	         append("likes", 100).  
	         append("by", "Fly");  
	         List<Document> documents = new ArrayList<Document>();  
	         documents.add(document);  
	         collection.insertMany(documents);  
	         System.out.println("文档插入成功");  
     
	        
	      }catch(Exception e){
	        System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	     }
	
	
}
@Test
public void find(){
	  try{   
	       // 连接到 mongodb 服务
	       MongoClient mongoClient = new MongoClient( "192.168.157.133" , 27017 );
	       
	       // 连接到数据库
	       MongoDatabase mongo = mongoClient.getDatabase("col");  
	       System.out.println("Connect to database successfully");
	       MongoCollection<Document> collection = mongo.getCollection("test");
	        FindIterable<Document> result=   collection.find();
	         Iterator<Document> it=result.iterator();
	         Document doc=null;
	        while(it.hasNext()){
	         doc=it.next();
	         System.out.println(doc.toJson());       		        	
	        }
	         
	        
	      }catch(Exception e){
	        System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	     }
	
}

	

	
	
}
