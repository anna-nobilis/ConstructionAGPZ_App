package com.annanobilis.menu.buttons;

import com.annanobilis.menu.MenuItem;
import com.annanobilis.repository.EmployeeDao;

public class AllButton implements MenuItem{
    private final EmployeeDao employeeDao = new EmployeeDao();

    @Override
    public void run() {
        System.out.println("List of All employees: ");
        employeeDao.findAll().forEach(System.out::println);
    }

    @Override
    public String getTitle() {
        return "Show all employees";
    }
}
