package model;

import org.bson.Document;

import java.io.Serializable;

public class CD implements Serializable {
    private static final long serialVersionUID = -5083759422249745403L;
    private String cdName;
    private int cdYear;
    private int cdId;
    public static int x = 0;
    private int cdQuantity;
    private double cdPrice;
    private String cdCategory;
    private String cdAuthor;
    private long cdUPC;

    public CD() {
        this("", "", 0, 0, 0, 0, "", x++);
    }

    public CD(String cdName, String cdCategory, double cdPrice, int Year, int cdQuantity, long cdUPC, String cdAuthor, int id) {
        super();
        this.cdId = id;
        this.cdAuthor = cdAuthor;
        this.cdName = cdName;
        this.cdCategory = cdCategory;
        this.cdPrice = cdPrice;
        this.cdYear = Year;
        this.cdQuantity = cdQuantity;
        this.cdUPC = cdUPC;
    }

    // Getters and setters for existing fields

    public Document toDocument() {
        return new Document("cdName", cdName)
                .append("cdCategory", cdCategory)
                .append("cdPrice", cdPrice)
                .append("cdYear", cdYear)
                .append("cdQuantity", cdQuantity)
                .append("cdUPC", cdUPC)
                .append("cdAuthor", cdAuthor)
                .append("cdId", cdId);
    }

    @Override
    public String toString() {
        return "CD{" +
                "cdName='" + cdName + '\'' +
                ", cdYear=" + cdYear +
                ", cdId=" + cdId +
                ", cdQuantity=" + cdQuantity +
                ", cdPrice=" + cdPrice +
                ", cdCategory='" + cdCategory + '\'' +
                ", cdAuthor='" + cdAuthor + '\'' +
                ", cdUPC=" + cdUPC +
                '}';
    }
}
