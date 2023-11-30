package com.annanobilis.menu.buttons;

import com.annanobilis.entity.Employee;
import com.annanobilis.menu.MenuItem;
import com.annanobilis.repository.EmployeeDao;

import java.util.Scanner;

public class DeleteEmployee implements MenuItem {
    private final EmployeeDao employeeDao = new EmployeeDao();
    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите ID работника, которого следует удалить");
        int id = scanner.nextInt();
        System.out.println(employeeDao.findById(id));
        Employee e = new Employee();
        e.setId(id);
        employeeDao.delete(e);
        System.out.println("Данные работника удалены");


    }

    @Override
    public String getTitle() {
        return "Удалить работника";
    }
}
