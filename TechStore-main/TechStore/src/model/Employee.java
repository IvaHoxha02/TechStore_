package model;

import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.codecs.pojo.annotations.BsonIgnoreIfNull;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;

import java.io.Serializable;

public class Employee implements Serializable {
    private static final long serialVersionUID = -5083759422249745403L;

    @BsonId
    private ObjectId _id;

    @BsonProperty(value = "employeeName")
    private String employeeName;

    @BsonProperty(value = "employeeSurname")
    private String employeeSurname;

    @BsonProperty(value = "employeeSalary")
    @BsonIgnoreIfNull
    private Double employeeSalary;

    public Employee() {
        this("", "", 0.0);
    }

    public Employee(String name, String surname, double salary) {
        super();
        this.employeeName = name;
        this.employeeSurname = surname;
        this.employeeSalary = salary;
    }

    public ObjectId get_id() {
        return _id;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeSurname() {
        return employeeSurname;
    }

    public void setEmployeeSurname(String employeeSurname) {
        this.employeeSurname = employeeSurname;
    }

    public Double getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(Double employeeSalary) {
        this.employeeSalary = employeeSalary;
    }
}
