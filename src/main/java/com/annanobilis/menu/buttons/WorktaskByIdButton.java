package com.annanobilis.menu.buttons;

import com.annanobilis.menu.MenuItem;
import com.annanobilis.repository.EmployeeDao;
import com.annanobilis.repository.WorktaskDao;

import java.util.Scanner;

public class WorktaskByIdButton implements MenuItem {
    private final WorktaskDao worktaskDao = new WorktaskDao();


    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите ID задачи");
        int id = scanner.nextInt();

        System.out.println(worktaskDao.findById(id));
    }

    @Override
    public String getTitle() {
        return "Найти задачу по ID";
    }

}
