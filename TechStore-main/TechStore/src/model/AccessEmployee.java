package model;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;

public class AccessEmployee {
    private static final String COLLECTION_NAME = "employeeCollection";

    private MongoClient mongoClient;
    private MongoDatabase database;
    private MongoCollection<Document> employeeCollection;

    public AccessEmployee(MongoClient mongoClient, String databaseName) {
        this.mongoClient = mongoClient;
        this.database = mongoClient.getDatabase(databaseName);
        this.employeeCollection = database.getCollection(COLLECTION_NAME);
    }

    public ArrayList<Employee> getEmp() {
        // Implement code to retrieve employees from MongoDB
        return convertMongoDocsToEmployees(employeeCollection.find());
    }

    public void editEmployee(int pos, Employee u) {
        // Implement code to edit employee in MongoDB
        Employee existingEmployee = getEmp().get(pos);
        if (existingEmployee != null) {
            Document empDocument = new Document("employeeName", u.getEmployeeName())
                    .append("employeeSurname", u.getEmployeeSurname())
                    .append("employeeSalary", u.getEmployeeSalary());

            employeeCollection.updateOne(
                    new Document("employeeName", existingEmployee.getEmployeeName())
                            .append("employeeSurname", existingEmployee.getEmployeeSurname())
                            .append("employeeSalary", existingEmployee.getEmployeeSalary()),
                    new Document("$set", empDocument)
            );
        } else {
            System.out.println("Employee not found");
        }
    }

    public void addEmp(Employee emp) {
        // Convert Employee object to MongoDB document
        Document empDocument = new Document("employeeName", emp.getEmployeeName())
                .append("employeeSurname", emp.getEmployeeSurname())
                .append("employeeSalary", emp.getEmployeeSalary());

        // Insert document into MongoDB collection
        employeeCollection.insertOne(empDocument);
    }

    // Helper method to convert MongoDB documents to Employee objects
    private ArrayList<Employee> convertMongoDocsToEmployees(Iterable<Document> documents) {
        ArrayList<Employee> employees = new ArrayList<>();
        for (Document doc : documents) {
            employees.add(convertMongoDocToEmployee(doc));
        }
        return employees;
    }

    // Helper method to convert a single MongoDB document to Employee object
    private Employee convertMongoDocToEmployee(Document document) {
        return new Employee(
                document.getString("employeeName"),
                document.getString("employeeSurname"),
                document.getDouble("employeeSalary")
        );
    }

    private void readF() {
        // Implement code to read employees from MongoDB collection
        ArrayList<Employee> employees = getEmp();
        for (Employee emp : employees) {
            System.out.println("Data: " + emp.toString());
        }
    }

    private void writeF(ArrayList<Employee> employees) {
        // Implement code to write employees to MongoDB collection
        for (Employee emp : employees) {
            Document empDocument = new Document("employeeName", emp.getEmployeeName())
                    .append("employeeSurname", emp.getEmployeeSurname())
                    .append("employeeSalary", emp.getEmployeeSalary());

            employeeCollection.insertOne(empDocument);
        }
    }

    public void closeFile() {
        // Close MongoDB-related resources if needed
        mongoClient.close();
    }
}
