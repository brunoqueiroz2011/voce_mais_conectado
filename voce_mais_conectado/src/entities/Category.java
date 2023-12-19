package entities;

import java.util.List;

public class Category {

    String name;
    String description;
    List<Courses> coursesList;

    public Category(String name, String description, List<Courses> coursesList) {
        this.name = name;
        this.description = description;
        this.coursesList = coursesList;
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

    public void setCoursesList(List<Courses> coursesList) {
        this.coursesList = coursesList;
    }
}
