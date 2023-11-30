package com.annanobilis.menu.buttons;

import com.annanobilis.entity.Worktask;
import com.annanobilis.menu.MenuItem;
import com.annanobilis.repository.WorktaskDao;

import java.util.Scanner;

public class DeleteWorktask implements MenuItem {
    private final WorktaskDao worktaskDao = new WorktaskDao();
    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите ID задачи, которую следует удалить");
        int id = scanner.nextInt();
        System.out.println(worktaskDao.findById(id));
        Worktask w = new Worktask();
        w.setId(id);
        worktaskDao.delete(w);
        System.out.println("Задача удалена");


    }

    @Override
    public String getTitle() {
        return "Удалить задачу";
    }
}

