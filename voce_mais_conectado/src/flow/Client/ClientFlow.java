package flow.Client;

import Singletons.SystemLoading;
import entities.Client;
import entities.User;
import utils.PrintScreen;

import java.util.Scanner;

public class ClientFlow {

    static SystemLoading systemLoading = SystemLoading.getInstance();

    public static void ChooseArea(){
        PrintScreen.lineBreak("Escolha uma área:");
        for (int index = 0; index < systemLoading.categoryList.size(); index++) {
            PrintScreen.line(index + " - ");
            PrintScreen.lineBreak(systemLoading.categoryList.get(index).getName());
        }
        PrintScreen.line("Digite sua opção:");
    }

    public static void ChooseCourse(int optionCategory){
        for (int index = 0; index < systemLoading.categoryList.get(optionCategory).getCoursesList().size(); index++) {
            PrintScreen.line(index + " - ");
            PrintScreen.lineBreak(systemLoading.categoryList.get(optionCategory).getCoursesList().get(index).getCourseName());
        }
        PrintScreen.line("Digite sua opção do curso escolhido:");
    }

    public static void viewInfoChosenCourse(int optionCategory, int optionCourse){
        for (int index = 0; index < systemLoading.categoryList.get(optionCategory).getCoursesList().size(); index++) {
            if (index == optionCourse) {
                PrintScreen.lineBreak(systemLoading.categoryList.get(optionCategory).getCoursesList().get(index).toString());
            }
        }
    }
}
