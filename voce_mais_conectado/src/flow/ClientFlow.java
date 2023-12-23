package flow;

import Singletons.SaveDataMemory;
import Singletons.SystemLoading;
import utils.PrintScreen;

import java.util.Scanner;

public class ClientFlow{

    static Scanner scanner = new Scanner(System.in);
    static SystemLoading systemLoading = SystemLoading.getInstance();
    static SaveDataMemory dataMemory = SaveDataMemory.getInstance();
    static int optionCategory;
    static int optionCourse;

    public static void loadingData(){
        systemLoading.clientLoading();
    }

    public static void ChooseArea() {
        PrintScreen.lineBreak("Escolha uma área:");
        for (int index = 0; index < dataMemory.categoryList.size(); index++) {
            PrintScreen.line(index + " - ");
            PrintScreen.lineBreak(dataMemory.categoryList.get(index).getName());
        }
        PrintScreen.line("Digite sua opção:");
        optionCategory = scanner.nextInt();
        PrintScreen.lineWrap();
    }

    public static void ChooseCourse() {
        for (int index = 0; index < dataMemory.categoryList.get(optionCategory).getCoursesList().size(); index++) {
            PrintScreen.line(index + " - ");
            PrintScreen.lineBreak(dataMemory.categoryList.get(optionCategory).getCoursesList().get(index).getCourseName());
        }
        PrintScreen.line("Digite sua opção do curso escolhido:");
        optionCourse = scanner.nextInt();
        PrintScreen.lineWrap();
    }

    public static void viewInfoChosenCourse() {
        for (int index = 0; index < dataMemory.categoryList.get(optionCategory).getCoursesList().size(); index++) {
            if (index == optionCourse) {
                PrintScreen.lineBreak(dataMemory.categoryList.get(optionCategory).getCoursesList().get(index).toString());
            }
        }
        PrintScreen.lineWrap();
    }

    public static Boolean interestBuy() {
        PrintScreen.line("Você tem interesse em comprar? (S/N):");
        Character interest = scanner.next().toLowerCase().charAt(0);
        PrintScreen.lineWrap();
        return interest.equals('s');
    }

    public static Boolean isRegistered() {
        PrintScreen.line("Você já é cadastrado? (S/N):");
        Character isRegistered = scanner.next().toLowerCase().charAt(0);
        PrintScreen.lineWrap();
        return isRegistered.equals('s');
    }

    public static Boolean clientAuthentic() {
        PrintScreen.line("Login: ");
        String login = scanner.next();
        PrintScreen.line("Senha: ");
        String password = scanner.next();
        systemLoading.client.setIsLogin(systemLoading.client.authentic(login, password));
        return systemLoading.client.authentic(login, password);
    }

    public static Boolean clientRegistered() {
        PrintScreen.line("Login: ");
        String login = scanner.next();
        PrintScreen.line("E-mail: ");
        String email = scanner.next();
        PrintScreen.line("Senha: ");
        String password = scanner.next();

        systemLoading.client.setLogin(login);
        systemLoading.client.setEmail(email);
        systemLoading.client.setPassword(password);
        systemLoading.client.setIsLogin(
                systemLoading.client.authentic(login, password));
        return systemLoading.client.authentic(login, password);
    }

    public static Boolean isLogin() {
        return systemLoading.client.isLogin();
    }

    public static void clientSalutation() {
        PrintScreen.lineBreak("Olá, " + systemLoading.client.getLogin() +
                " , antes de concluir a compra confira as informações:");
    }


}
