package flow;

import Singletons.SystemLoading;

import java.util.Scanner;

public abstract class Flow {

    protected static Scanner scanner = new Scanner(System.in);
    protected static SystemLoading systemLoading = SystemLoading.getInstance();

}
