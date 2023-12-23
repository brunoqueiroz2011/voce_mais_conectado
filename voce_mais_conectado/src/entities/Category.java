package entities;

import java.util.ArrayList;
import java.util.List;

public class Category {

    String name;
    String description;
    List<Courses> coursesList = new ArrayList<>();;

    public Category(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Courses> getCoursesList() {
        return coursesList;
    }

    public void setCoursesList(Courses course) {
        this.coursesList.add(course);
    }
}
