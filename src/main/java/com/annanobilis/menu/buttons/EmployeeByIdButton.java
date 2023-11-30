package com.annanobilis.menu.buttons;

import com.annanobilis.menu.MenuItem;
import com.annanobilis.repository.EmployeeDao;

import java.util.Scanner;

public class EmployeeByIdButton implements MenuItem {

    private final EmployeeDao employeeDao = new EmployeeDao();


    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите ID работника");
        int id = scanner.nextInt();

        System.out.println(employeeDao.findById(id));
    }

    @Override
    public String getTitle() {
        return "Найти работника по ID";
    }
}
