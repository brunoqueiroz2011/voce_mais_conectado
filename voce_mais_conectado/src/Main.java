import Singletons.SystemLoading;
import flow.Client.ClientFlow;
import utils.PrintScreen;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SystemLoading systemLoading = SystemLoading.getInstance();
        systemLoading.coursesLoading();
        systemLoading.categoryLoading();
        systemLoading.clientLoading();

        while (true) {
            PrintScreen.lineBreak("Olá, seja bem-vindo ao Você+Conectado!");
            PrintScreen.lineBreak("Por favor, identifique-se, você é um cliente ou funcionário?");
            PrintScreen.lineBreak("c -> Cliente");
            PrintScreen.lineBreak("f -> Funcionario");
            PrintScreen.lineBreak("s -> Sair");
            PrintScreen.line("Digite sua opção:");
            Character identification = scanner.next().toLowerCase().charAt(0);

            if (identification.equals('c')) {

                while (true) {
                    ClientFlow.ChooseArea();
                    int optionCategory = scanner.nextInt();
                    PrintScreen.lineWrap();

                    ClientFlow.ChooseCourse(optionCategory);
                    int optionCourse = scanner.nextInt();
                    PrintScreen.lineWrap();

                    ClientFlow.viewInfoChosenCourse(optionCategory, optionCourse);
                    PrintScreen.lineWrap();

                    PrintScreen.line("Você tem interesse em comprar? (S/N):");
                    Character interest = scanner.next().toLowerCase().charAt(0);
                    PrintScreen.lineWrap();

                    if (interest.equals('s')) {
                        PrintScreen.line("Você já é cadastrado? (S/N):");
                        Character isRegistered = scanner.next().toLowerCase().charAt(0);
                        PrintScreen.lineWrap();

                        if (isRegistered.equals('s')) {
                            PrintScreen.line("Login: ");
                            String login = scanner.next();
                            PrintScreen.line("Senha: ");
                            String password = scanner.next();

                            if (systemLoading.client.authentic(login, password)) {
                                systemLoading.client.setIsLogin(true);
                                PrintScreen.lineBreak("Login realizado com sucesso!");
                            }else{
                                PrintScreen.lineBreak("Houve um problema ao logar!");
                            }

                        } else {
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

                            PrintScreen.lineBreak("Seu cadastrado foi realizado com sucesso!");
                        }

                        if (systemLoading.client.isLogin()) {
                            PrintScreen.lineWrap();
                            PrintScreen.lineBreak("Olá, " + systemLoading.client.getLogin() +
                                    " , antes de concluir a compra confira as informações:");

                            ClientFlow.viewInfoChosenCourse(optionCategory, optionCourse);
                            PrintScreen.lineWrap();

                            PrintScreen.line("Você tem interesse em comprar? (S/N):");
                            interest = scanner.next().toLowerCase().charAt(0);

                            if (interest.equals('s')) {
                                PrintScreen.lineBreak("Compra realizada com sucesso!");
                                PrintScreen.lineBreak("A Você+Conectado agradece, tenha um ótimo dia e bons estudos!");
                                PrintScreen.lineWrap();
                            } else {
                                PrintScreen.clean();
                                PrintScreen.lineBreak("Obrigado e Volte Sempre!");
                            }
                        }
                    }
                    break;
                }

            } else if (identification.equals('f')) {
                PrintScreen.lineBreak("Funcionario");
            } else {
                PrintScreen.lineBreak("Obrigado e volte sempre ao Você+Conectado!");
                break;
            }
        }
    }
}