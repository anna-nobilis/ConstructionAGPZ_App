package com.annanobilis.menu;

import com.annanobilis.menu.buttons.AllButton;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Menu {
    private static boolean exit = false;
    private static Map<String, MenuItem> menu = new TreeMap<>();
    static {
        menu.put("Exit", () -> exit = true);
        menu.put("All", new AllButton());
    }
    public void startMenu(){
        Scanner scanner = new Scanner(System.in);
        do {
            printMenuChoice();
            String choice = scanner.nextLine();
            if (menu.containsKey(choice)) {
                menu.get(choice).run();
            } else {
                System.out.println("Choose one command that represents in menu");
            }

        } while(!exit);

    }

    private void printMenuChoice(){
        System.out.println("---------------");
        System.out.println("Select your choice:");
        menu.forEach((k,v) -> System.out.println(k + " - " + v.getTitle()));
    }
}
