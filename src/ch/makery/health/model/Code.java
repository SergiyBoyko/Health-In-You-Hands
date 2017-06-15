package ch.makery.health.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by fbrsw on 28.03.2017.
 */
public class Code {
    private final StringProperty name;
    private final StringProperty code;
//    private List<Point> code;
    private final StringProperty picture;

    public Code() {
        this(null, null, null);
    }

    public Code(String name, String code, String picture) {
        this.name = new SimpleStringProperty(name);
        this.code = new SimpleStringProperty(code);
        this.picture = new SimpleStringProperty(picture);
    }

//    public Code(String name, ArrayList<Point> code, String picture) {
//        this.name = new SimpleStringProperty(name);
//        this.code = code;
////        this.code = new ArrayList<>(code);
//        this.picture = new SimpleStringProperty(picture);
//    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public StringProperty NameProperty() {
        return name;
    }

    public String getCode() {
        return code.get();
    }

    public void setCode(String code) {
        this.code.set(code);
    }

    public StringProperty CodeProperty() {
        return code;
    }

    public String getPicture() {
        return picture.get();
    }

    public void setPicture(String picture) {
        this.picture.set(picture);
    }

    public StringProperty PictireProperty() {
        return picture;
    }
}
