package ch.makery.health.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by fbrsw on 30.03.2017.
 */
public class Point {
    private final StringProperty name;
    private final StringProperty description;

    public Point() {
        this(null, null);
    }

    public Point(String name, String description) {
        this.name = new SimpleStringProperty(name);
        this.description = new SimpleStringProperty(description);
    }

    public String getPointName() {
        return name.get();
    }

    public void setPointName(String name) {
        this.name.set(name);
    }

    public StringProperty PointNameProperty() {
        return name;
    }

    public String getPointDescription() {
        return description.get();
    }

    public void setPointDescription(String description) {
        this.description.set(description);
    }

    public StringProperty PointDescriptionProperty() {
        return description;
    }
}
