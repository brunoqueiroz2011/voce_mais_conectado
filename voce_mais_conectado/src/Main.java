import Singletons.SaveDataMemory;
import flow.ClientFlow;
import flow.EmployeeFlow;
import utils.PrintScreen;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        if (SaveDataMemory.getInstance().categoryList.isEmpty())
            SaveDataMemory.getInstance().insertCategoryDefault();

        while (true) {
            homeGreeting();
            Scanner scanner = new Scanner(System.in);
            PrintScreen.line("Digite sua opção:");
            Character identification = scanner.next().toLowerCase().charAt(0);

            if (identification.equals('c')) {
                ClientFlow.loadingData();

                while (true) {
                    ClientFlow.ChooseArea();

                    ClientFlow.ChooseCourse();

                    ClientFlow.viewInfoChosenCourse();

                    if (ClientFlow.interestBuy()) {

                        if (ClientFlow.isRegistered()) {

                            if (ClientFlow.clientAuthentic()) {
                                PrintScreen.lineBreak("Login realizado com sucesso!");
                            } else {
                                PrintScreen.lineBreak("Houve um problema ao logar!");
                                break;//Volta para o Inicio do Fluxo.
                            }
                            PrintScreen.lineWrap();

                        } else {
                            if (ClientFlow.clientRegistered())
                                PrintScreen.lineBreak("Seu cadastrado foi realizado com sucesso!");
                            else
                                PrintScreen.lineBreak("Houve um problema ao Cadastrar!");
                        }

                        PrintScreen.lineWrap();

                        if (ClientFlow.isLogin()) {

                            ClientFlow.clientSalutation();

                            ClientFlow.viewInfoChosenCourse();
                            PrintScreen.lineWrap();

                            if (ClientFlow.interestBuy()) {
                                PrintScreen.lineBreak("Compra realizada com sucesso!");
                                PrintScreen.lineBreak("A Você+Conectado agradece, tenha um ótimo dia e bons estudos!");
                            } else {
                                PrintScreen.clean();
                                PrintScreen.lineBreak("Obrigado e Volte Sempre!");
                            }

                            PrintScreen.lineWrap();
                        }
                    }

                    break;
                }

            } else if (identification.equals('f')) {

                EmployeeFlow.loadingData();

                if (EmployeeFlow.employeeAuthentic()) {
                    PrintScreen.lineBreak("Login realizado com sucesso!");
                    PrintScreen.lineWrap();
                    EmployeeFlow.employeeSalutation();

                    int optionOperation = EmployeeFlow.choiceOperation();
                    switch (optionOperation) {
                        case 1:
                            EmployeeFlow.chooseArea();
                            EmployeeFlow.createNewCourse();
                            break;
                        case 2:
                        case 3:
                            EmployeeFlow.chooseArea();
                            EmployeeFlow.chooseCourse();
                            break;
                        default:
                            PrintScreen.lineBreak("Opção escolhida não exite!!!");
                    }

                    if (optionOperation == 2)
                        EmployeeFlow.updateCourse();
                    else
                        EmployeeFlow.deleteCourse();

                } else {
                    PrintScreen.lineBreak("Houve um problema ao logar!");
                    break;//Volta para o Inicio do Fluxo.
                }
                PrintScreen.lineWrap();
            } else {
                PrintScreen.lineBreak("Obrigado e volte sempre ao Você+Conectado!");
                break;
            }
        }
    }

    public static void homeGreeting() {
        PrintScreen.lineBreak("Olá, seja bem-vindo ao Você+Conectado!");
        PrintScreen.lineBreak("Por favor, identifique-se, você é um cliente ou funcionário?");
        PrintScreen.lineBreak("c -> Cliente");
        PrintScreen.lineBreak("f -> Funcionario");
        PrintScreen.lineBreak("s -> Sair");
    }
}