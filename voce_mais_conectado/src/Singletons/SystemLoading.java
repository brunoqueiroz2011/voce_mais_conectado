package Singletons;

import entities.Category;
import entities.Client;
import entities.Courses;
import entities.Employee;

import java.util.ArrayList;
import java.util.List;

public class SystemLoading {

    private static SystemLoading instance;
    public List<Courses> coursesList = new ArrayList<>();
    public List<Category> categoryList = new ArrayList<>();
    public Client client = new Client();
    public Employee employee = new Employee();

    public static SystemLoading getInstance() {
        if (instance == null) {
            instance = new SystemLoading();
        }
        return instance;
    }

    public void coursesLoading() {
        Courses englishCourse = new Courses("Curso Ingles", "10 horas", "Saber Portugues", "Credito/Débito", "Você vai aprender Ingles!!!");
        coursesList.clear();
        coursesList.add(englishCourse);
    }

    public void categoryLoading() {
        Category languageCourses = new Category("Cursos de Idiomas", "Curso de lingagem estrangeiras", coursesList);
        Category technicalCourses = new Category("Cursos de Técnicos", "Curso de Areas de Formação", coursesList);
        Category personalImageCourses = new Category("Cursos de Imagem Pessoal", "Curso de Forma de se Vestir e Falar", coursesList);
        Category technologyCourses = new Category("Cursos de Tecnologia", "Curso de Tecnologias de Programação", coursesList);

        categoryList.clear();
        categoryList.add(languageCourses);
        categoryList.add(technicalCourses);
        categoryList.add(personalImageCourses);
        categoryList.add(technologyCourses);
    }

    public void clientLoading(){
        client.setLogin("admin");
        client.setEmail("admin@gmail.com");
        client.setPassword("1234");
        client.setIsLogin(false);
    }

    public void employeerLoading(){
        employee.setLogin("admin");
        employee.setPassword("1234");
    }
}
