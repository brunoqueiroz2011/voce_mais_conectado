package flow;

import Singletons.SaveDataMemory;
import Singletons.SystemLoading;
import entities.Courses;
import utils.PrintScreen;

import java.util.Scanner;

public class EmployeeFlow {
    static Scanner scanner = new Scanner(System.in);
    static SystemLoading systemLoading = SystemLoading.getInstance();
    static SaveDataMemory dataMemory = SaveDataMemory.getInstance();
    static int optionOperation;
    static int optionCategory;
    static int optionCourse;

    public static void loadingData() {
        systemLoading.employeerLoading();
    }

    public static Boolean employeeAuthentic() {
        PrintScreen.line("Matrícula: ");
        String login = scanner.next();
        PrintScreen.line("Senha: ");
        String password = scanner.next();
        return systemLoading.employee.authentic(login, password);
    }

    public static void employeeSalutation() {
        PrintScreen.lineBreak("Olá, " + systemLoading.employee.getLogin() +
                ", o que você deseja fazer?");
        PrintScreen.lineBreak("1 - Adicionar cursos");
        PrintScreen.lineBreak("2 - Excluir cursos");
        PrintScreen.lineBreak("3 - Atualizar cursos");
    }

    public static int choiceOperation() {
        PrintScreen.line("Digite sua opção:");
        optionOperation = scanner.nextInt();
        PrintScreen.lineWrap();
        return optionOperation;
    }

    public static void chooseArea() {
        PrintScreen.lineBreak("Escolha uma área:");
        for (int index = 0; index < dataMemory.categoryList.size(); index++) {
            PrintScreen.line(index + " - ");
            PrintScreen.lineBreak(dataMemory.categoryList.get(index).getName());
        }
        PrintScreen.line("Digite sua opção:");
        optionCategory = scanner.nextInt();
        PrintScreen.lineWrap();
    }

    public static void chooseCourse() {
        for (int index = 0; index < dataMemory.categoryList.get(optionCategory).getCoursesList().size(); index++) {
            PrintScreen.line(index + " - ");
            PrintScreen.lineBreak(dataMemory.categoryList.get(optionCategory).getCoursesList().get(index).getCourseName());
        }
        PrintScreen.line("Digite sua opção do curso escolhido:");
        optionCourse = scanner.nextInt();
        PrintScreen.lineWrap();
    }

    public static void createNewCourse() {
        Courses courses = new Courses();
        PrintScreen.line("Nome do Curso: ");
        courses.setCourseName(scanner.next());
        PrintScreen.line("Período/Horário: ");
        courses.setPeriodTime(scanner.next());
        PrintScreen.line("Requisitos: ");
        courses.setRequirements(scanner.next());
        PrintScreen.line("Formas de Pagamento: ");
        courses.setPaymentMethods(scanner.next());
        PrintScreen.line("Descrição do curso: ");
        courses.setDescription(scanner.next());

        PrintScreen.line("Dejesa inserir o novo curso? (S/N):");
        Character option = scanner.next().toLowerCase().charAt(0);
        if (option.equals('s')) {
            PrintScreen.lineBreak(dataMemory.categoryList.toString());
            dataMemory.insertCourse(courses, optionCategory);
            PrintScreen.lineBreak("Curso criado com Sucesso!");
            PrintScreen.lineBreak(dataMemory.categoryList.toString());

        } else {
            PrintScreen.lineBreak("Tudo bem, até a proxima!");
        }
    }

    public static void updateCourse() {
        Courses courses = dataMemory.categoryList.get(optionCategory).getCoursesList().get(optionCourse);
        PrintScreen.line("Nome do Curso: ");
        courses.setCourseName(scanner.next());
        PrintScreen.line("Período/Horário: ");
        courses.setPeriodTime(scanner.next());
        PrintScreen.line("Requisitos: ");
        courses.setRequirements(scanner.next());
        PrintScreen.line("Formas de Pagamento: ");
        courses.setPaymentMethods(scanner.next());
        PrintScreen.line("Descrição do curso: ");
        courses.setDescription(scanner.next());

        dataMemory.updateCourse(courses, optionCourse, optionCategory);
    }

    public static void deleteCourse() {
        dataMemory.deleteCourse(optionCourse, optionCategory);
    }
}
