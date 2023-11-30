package com.annanobilis.menu.buttons;

import com.annanobilis.entity.Employee;
import com.annanobilis.entity.Worktask;
import com.annanobilis.menu.MenuItem;
import com.annanobilis.repository.EmployeeDao;

import java.util.Scanner;

public class UpdateIDWoktaskEmployeeButton implements MenuItem {
    private final EmployeeDao employeeDao = new EmployeeDao();
    @Override
    public void run() {
        Employee e = updateworktask();
        employeeDao.updateoneposition(e);
    }


    @Override
    public String getTitle() {
        return "Назначить новую выполняемую задачу работнику";
    }
    private Employee updateworktask(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите ID работника, которому необходимо изменить выполняемую задачу");
        int id = scanner.nextInt();

        Employee e = employeeDao.findById(id);
        System.out.println(e);

        System.out.println("Введите новую задачу");
        Worktask w = new Worktask();
        int wId = scanner.nextInt();

        w.setId(wId);
        e.setWorktask(w);

        return e;
    }
}
