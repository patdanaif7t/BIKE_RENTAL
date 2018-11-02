/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bikerental;

import com.google.gson.Gson;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import static com.mongodb.client.model.Filters.eq;
import org.bson.Document;

/**
 *
 * @author anupongpummok
 */
public class InvoiceDao {
    private static MongoCollection<Invoice> invoiceCol;
    
    public InvoiceDao() {
        invoiceCol = Database.getDatabase().getCollection("invoice", Invoice.class);
    }
    
    public boolean insertVoice(Invoice invoice) {
        try {
            invoiceCol.insertOne(invoice);     
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public Invoice findById(String invoiceId) {
        return invoiceCol.find(eq("id", invoiceId)).first();

    }
    
    public FindIterable<Invoice> findAll() {
        return invoiceCol.find();
    }
    
    public boolean switchStatusById(String invoiceId, String status) {
        try {
            if (status.equals("กำลังเช่า")) {
                invoiceCol.updateOne(
                        eq("id", invoiceId), 
                        new Document("$set", 
                                new Document("status", "ว่าง")
                        )
                );

            } else if (status.equals("ว่าง")) {
                invoiceCol.updateOne(
                        eq("id", invoiceId), 
                        new Document("$set", 
                                new Document("status", "กำลังเช่า")
                        )
                );
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean editById(String invoiceId, Invoice newInvoice) {
        Gson gson = new Gson();
        Document invoiceDoc = Document.parse(gson.toJson(newInvoice));
        try {
            invoiceCol.updateOne( eq("id", invoiceId), invoiceDoc);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    

}
