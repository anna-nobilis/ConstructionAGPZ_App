package com.annanobilis.menu.buttons;

import com.annanobilis.entity.Employee;
import com.annanobilis.entity.Worktask;
import com.annanobilis.menu.MenuItem;
import com.annanobilis.repository.EmployeeDao;
import com.annanobilis.repository.WorktaskDao;

import java.util.Objects;
import java.util.Scanner;

public class SaveNewWorktaskButton implements MenuItem {
    private final WorktaskDao worktaskDao = new WorktaskDao();

    @Override
    public void run() {
        Worktask e = inputNewWorktask();
        e = worktaskDao.save(e);
        System.out.println(e);
    }

    @Override
    public String getTitle() {
        return "Создать новую задачу";
    }

    private Worktask inputNewWorktask(){
        Scanner scanner = new Scanner(System.in);
        Worktask worktask = new Worktask();
        System.out.println("Введите задачу");
        worktask.setTask(scanner.nextLine());
        System.out.println("Введите место выполнения задачи (СКЛАД/ОФИС)");
        String w = scanner.next();

             while (!Objects.equals(w, "ОФИС") && !Objects.equals(w, "СКЛАД")){

            System.out.println("Значение некорректно");
            w = scanner.next();}

        worktask.setPlace(w);


        return worktask;
    }
}
