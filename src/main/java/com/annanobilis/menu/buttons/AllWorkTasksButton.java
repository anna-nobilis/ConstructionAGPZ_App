package com.annanobilis.menu.buttons;

import com.annanobilis.menu.MenuItem;
import com.annanobilis.repository.EmployeeDao;
import com.annanobilis.repository.WorktaskDao;

public class AllWorkTasksButton implements MenuItem {
    private final WorktaskDao worktaskDao = new WorktaskDao();

    @Override
    public void run() {
        System.out.println("Список всех задач: ");
        worktaskDao.findAll().forEach(System.out::println);
    }

    @Override
    public String getTitle() {
        return "Отобразить все задачи";
    }
}
