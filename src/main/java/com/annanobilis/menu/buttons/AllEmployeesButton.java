package com.annanobilis.menu.buttons;

import com.annanobilis.menu.MenuItem;
import com.annanobilis.repository.EmployeeDao;

public class AllEmployeesButton implements MenuItem{
    private final EmployeeDao employeeDao = new EmployeeDao();

    @Override
    public void run() {
        System.out.println("Список всех работников: ");
        employeeDao.findAll().forEach(System.out::println);
    }

    @Override
    public String getTitle() {
        return "Отобразить всех работников";
    }
}
