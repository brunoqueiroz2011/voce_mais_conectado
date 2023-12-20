package flow;

import utils.PrintScreen;

public class EmployeeFlow extends Flow {

    public static Boolean employeeAuthentic() {
        PrintScreen.line("Matrícula: ");
        String login = scanner.next();
        PrintScreen.line("Senha: ");
        String password = scanner.next();
        systemLoading.client.setIsLogin(systemLoading.client.authentic(login, password));
        return systemLoading.client.authentic(login, password);
    }

    public static void employeeSalutation() {
        PrintScreen.lineBreak("Olá, " + systemLoading.employee.getLogin() +
                ", o que você deseja fazer?");
    }
}
