package Singletons;

import entities.Category;
import entities.Courses;

import java.util.ArrayList;
import java.util.List;

public class SaveDataMemory {

    public List<Category> categoryList = new ArrayList<>();

    private static SaveDataMemory instance;

    public static SaveDataMemory getInstance() {
        if (instance == null) {
            instance = new SaveDataMemory();
        }
        return instance;
    }

    public void insertCategoryDefault() {
        Category languageCourses = new Category("Cursos de Idiomas", "Curso de lingagem estrangeiras");
        Category technicalCourses = new Category("Cursos de Técnicos", "Curso de Areas de Formação");
        Category personalImageCourses = new Category("Cursos de Imagem Pessoal", "Curso de Forma de se Vestir e Falar");
        Category technologyCourses = new Category("Cursos de Tecnologia", "Curso de Tecnologias de Programação");

        categoryList.clear();
        categoryList.add(languageCourses);
        categoryList.add(technicalCourses);
        categoryList.add(personalImageCourses);
        categoryList.add(technologyCourses);
    }

    public void insertCourse(Courses courses, int idCategory) {
        categoryList.get(idCategory).setCoursesList(courses);
    }

    public void updateCourse(Courses courses, int idCourse, int idCategory) {
        categoryList.get(idCategory).getCoursesList().get(idCourse).setCourseName(courses.getCourseName());
        categoryList.get(idCategory).getCoursesList().get(idCourse).setPeriodTime(courses.getPeriodTime());
        categoryList.get(idCategory).getCoursesList().get(idCourse).setRequirements(courses.getRequirements());
        categoryList.get(idCategory).getCoursesList().get(idCourse).setPaymentMethods(courses.getPaymentMethods());
        categoryList.get(idCategory).getCoursesList().get(idCourse).setDescription(courses.getDescription());
    }

    public void deleteCourse(int idCourse, int idCategory) {
        categoryList.get(idCategory).getCoursesList().remove(idCourse);
    }

}
