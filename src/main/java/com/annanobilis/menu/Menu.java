package com.annanobilis.menu;

import com.annanobilis.menu.buttons.*;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Menu {
    private static boolean exit = false;
    private static final Map<String, MenuItem> menu = new TreeMap<>();
    static {
        menu.put("В", () -> exit = true);
        menu.put("Р1", new AllEmployeesButton());
        menu.put("Р2", new EmployeeByIdButton());
        menu.put("Р3", new SaveNewEmployeeButton());
        menu.put("Р4", new UpdateEmployeeButton());
        menu.put("Р5", new UpdateIDWoktaskEmployeeButton());
        menu.put("Р6", new DeleteEmployee());
        menu.put("З1", new AllWorkTasksButton());
        menu.put("З2", new WorktaskByIdButton());
        menu.put("З3", new SaveNewWorktaskButton());
        menu.put("З4", new UpdateWorktaskButton());
        menu.put("З5", new DeleteWorktask());
    }
    public void startMenu(){
        Scanner scanner = new Scanner(System.in);
        do {
            printMenuChoice();
            String choice = scanner.nextLine();
            if (menu.containsKey(choice)) {
                menu.get(choice).run();
            } else {
                System.out.println("Запрос неверен. Выберите команду из списка");
            }

        } while(!exit);

    }

    private void printMenuChoice(){
        System.out.println("---------------");
        System.out.println("Выберите команду из списка:");
        menu.forEach((k,v) -> System.out.println(k + " - " + v.getTitle()));
    }
}
