
package bikerental;

import com.mongodb.Block;
import com.mongodb.async.SingleResultCallback;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Updates.*;
import static java.util.Arrays.asList;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

import com.mongodb.*;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import com.mongodb.util.JSON;
import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.bson.types.Code;


public class Database {
    private static MongoClientURI uri;
    private static MongoClient client;
    private static MongoDatabase db;
    private static MongoCollection<Document> collection;

    public static void init(){
        CodecRegistry pojoCodecRegistry = fromRegistries(MongoClient.getDefaultCodecRegistry(),
                                fromProviders(PojoCodecProvider.builder().automatic(true).build()));
        
        uri  = new MongoClientURI("mongodb://admin:12345678za@ds249583.mlab.com:49583/bikerental");
        client = new MongoClient(uri);
        db = client.getDatabase(uri.getDatabase());
        db = db.withCodecRegistry(pojoCodecRegistry);
    }
    
    public static MongoDatabase getDatabase(){
        return db;
    }
    
    public static void setCollection(String col) {
        collection = db.getCollection(col);
    }
    
    public static MongoCollection<Document> getCollection() {
        return collection;
    }
    
    public static boolean insert(Document doc) {
        try {
            collection.insertOne(doc);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public static boolean delete(Document doc) {
        try {
            collection.deleteOne(doc);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public static boolean update(Document oldDoc, Document newDoc) {
        try {
            collection.updateOne(oldDoc, newDoc);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
   
    public static Document find(String key,
            String value) {
        return collection.find(eq(key, value)).first();
    }
    
    public static Document find(String key,
            int value) {
        return collection.find(eq(key, value)).first();
    }
     public static FindIterable<Document> findAll(MongoCollection<Document> col) {
        return collection.find();
    }
    
}
