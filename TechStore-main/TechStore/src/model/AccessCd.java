package model;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;

public class AccessCd {
    private static final String COLLECTION_NAME = "cdCollection";

    private MongoClient mongoClient;
    private MongoDatabase database;
    private MongoCollection<Document> cdCollection;

    public AccessCd(MongoClient mongoClient, String databaseName) {
        this.mongoClient = mongoClient;
        this.database = mongoClient.getDatabase(databaseName);
        this.cdCollection = database.getCollection(COLLECTION_NAME);
    }

    public ArrayList<CD> getCd() {
        // Implement code to retrieve CDs from MongoDB
        return convertMongoDocsToCDs(cdCollection.find());
    }

    public void addCd(CD cd) {
        // Convert CD object to MongoDB document
        Document cdDocument = cd.toDocument();

        // Insert document into MongoDB collection
        cdCollection.insertOne(cdDocument);
    }

    public void rm(int id) {
        // Implement code to remove CD from MongoDB based on ID
        cdCollection.deleteOne(new Document("cdId", id));
    }

    public void editCdQuant(int quant, CD c) {
        // Implement code to edit CD quantity in MongoDB
        cdCollection.updateOne(
                new Document("cdId", c.getCdId()),
                new Document("$set", new Document("cdQuantity", quant))
        );
    }

    // Helper method to convert MongoDB documents to CD objects
    private ArrayList<CD> convertMongoDocsToCDs(Iterable<Document> documents) {
        ArrayList<CD> cds = new ArrayList<>();
        for (Document doc : documents) {
            cds.add(convertMongoDocToCD(doc));
        }
        return cds;
    }

    // Helper method to convert a single MongoDB document to CD object
    private CD convertMongoDocToCD(Document document) {
        return new CD(
                document.getString("cdName"),
                document.getString("cdCategory"),
                document.getDouble("cdPrice"),
                document.getInteger("cdYear"),
                document.getInteger("cdQuantity"),
                document.getLong("cdUPC"),
                document.getString("cdAuthor"),
                document.getInteger("cdId")
        );
    }

     private void readF() {
         ArrayList<CD> cds = convertMongoDocsToCDs(cdCollection.find());
         for (CD cd : cds) {
             System.out.println("Data: " + cd.toString());
         }
     }

    private void writeF(ArrayList<CD> cds) {
        // Implement code to write CDs to MongoDB collection
        for (CD cd : cds) {
            Document cdDocument = cd.toDocument();
            cdCollection.insertOne(cdDocument);
        }
    }

    public void closeFile() {
        // Close MongoDB-related resources if needed
        mongoClient.close();
    }
}
