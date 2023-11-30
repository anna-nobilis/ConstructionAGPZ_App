package com.annanobilis.menu.buttons;

import com.annanobilis.entity.Employee;
import com.annanobilis.entity.Worktask;
import com.annanobilis.menu.MenuItem;
import com.annanobilis.repository.EmployeeDao;
import com.annanobilis.repository.WorktaskDao;

import java.util.Scanner;

public class UpdateWorktaskButton implements MenuItem {
    private final WorktaskDao worktaskDao = new WorktaskDao();
    @Override
    public void run() {
        Worktask w = updateWorktask();
        worktaskDao.update(w);
    }

    @Override
    public String getTitle() {
        return "Изменить задачу";
    }

    private Worktask updateWorktask(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите ID задачи для изменения");
        int id = scanner.nextInt();

        Worktask w = worktaskDao.findById(id);
        System.out.println(w);

        System.out.println("Введите новые данные:");

        System.out.println("Введите задачу в формате Выполняемая*задача (если данные не изменяются, введите \"*\" )");
        String s = scanner.next();
        String b = "*";
        if(!s.equals(b)){
            String d = s.replace("*"," ");
            w.setTask(d);
        }

        System.out.println("Введите место выполнения задачи - СКЛАД/ОФИС(если данные не изменяются, введите \"*\" )");
        String Place = scanner.next();
        if(!Place.equals(b)){
            w.setPlace(Place);
        }

        return w;
    }
}