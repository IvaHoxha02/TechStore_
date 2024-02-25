package model;

import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;

import java.io.Serializable;

public class User implements Serializable {
    private static final long serialVersionUID = -5083759422249745403L;

    @BsonId
    private ObjectId _id;

    @BsonProperty(value = "user")
    private String user;

    @BsonProperty(value = "pass")
    private String pass;

    @BsonProperty(value = "id")
    private final int id;

    @BsonProperty(value = "level")
    private int level; // 1-Admin, 2-Editor, 3-Normal User

    public User() {
        this(x++, "", "", 3);
    }

    public User(int id, String user, String pass, int level) {
        super();

        this.id = id;
        if (x < id) x = id;
        this.user = user;
        this.pass = pass;
        this.level = level;
    }

    public ObjectId get_id() {
        return _id;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public int getid() {
        return this.id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
