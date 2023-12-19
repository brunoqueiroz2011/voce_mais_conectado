package utils;

import java.io.IOException;

public class PrintScreen {

    public static void lineBreak(String msg) {
        System.out.println(msg);
    }

    public static void lineWrap() {
        System.out.println("");
    }

    public static void line(String msg) {
        System.out.print(msg);
    }

    public static void clean() {
        try {
            //Limpa a tela no windows, no linux e no MacOS
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
