package model;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;

public class AccessUsers {
    private static final String COLLECTION_NAME = "userCollection";

    private MongoClient mongoClient;
    private MongoDatabase database;
    private MongoCollection<Document> userCollection;

    public AccessUsers(MongoClient mongoClient, String databaseName) {
        this.mongoClient = mongoClient;
        this.database = mongoClient.getDatabase(databaseName);
        this.userCollection = database.getCollection(COLLECTION_NAME);
    }

    public User checkUser(String user, String pass) {
        Document query = new Document("user", user).append("pass", pass);
        Document userDocument = userCollection.find(query).first();
        return userDocument != null ? convertMongoDocToUser(userDocument) : null;
    }

    public void addUser(User user) {
        // Convert User object to MongoDB document
        Document userDocument = user.toDocument();

        // Insert document into MongoDB collection
        userCollection.insertOne(userDocument);
    }

    public String readS() {
        ArrayList<User> users = getUsers();
        StringBuilder read = new StringBuilder();
        for (User user : users) {
            read.append("\n-------------User ").append(user.getid())
                    .append("--------------------\n").append(user.toString())
                    .append("\n>---------------------------<\n");
        }
        return read.toString();
    }

    public ArrayList<User> getUsers() {
        // Implement code to retrieve users from MongoDB
        return convertMongoDocsToUsers(userCollection.find());
    }

    public void rm(int id) {
        // Implement code to remove user from MongoDB based on ID
        userCollection.deleteOne(new Document("id", id));
    }

    public int getPosition(User u) {
        ArrayList<User> users = getUsers();
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).toString().equals(u.toString())) {
                return i;
            }
        }
        return -1;
    }

    public void editUser(int pos, User u) {
        User existingUser = getUsers().get(pos);
        if (existingUser != null) {
            Document userDocument = u.toDocument();

            userCollection.updateOne(
                    new Document("id", existingUser.getid()),
                    new Document("$set", userDocument)
            );
        } else {
            System.out.println("User not found");
        }
    }

    // Helper method to convert MongoDB documents to User objects
    private ArrayList<User> convertMongoDocsToUsers(Iterable<Document> documents) {
        ArrayList<User> users = new ArrayList<>();
        for (Document doc : documents) {
            users.add(convertMongoDocToUser(doc));
        }
        return users;
    }

    // Helper method to convert a single MongoDB document to User object
    private User convertMongoDocToUser(Document document) {
        return new User(
                document.getInteger("id"),
                document.getString("user"),
                document.getString("pass"),
                document.getInteger("level")
        );
    }

    private void readF() {
        ArrayList<User> users = convertMongoDocsToUsers(userCollection.find());
        for (User user : users) {
            System.out.println("Data: " + user.toString());
        }
    }


    private void writeF(ArrayList<User> users) {
        // Implement code to write users to MongoDB collection
        for (User user : users) {
            Document userDocument = user.toDocument();
            userCollection.insertOne(userDocument);
        }
    }

    public void closeFile() {
        // Close MongoDB-related resources if needed
        mongoClient.close();
    }
}
