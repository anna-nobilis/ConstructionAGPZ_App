package com.annanobilis.menu.buttons;

import com.annanobilis.entity.Employee;
import com.annanobilis.entity.Worktask;
import com.annanobilis.menu.MenuItem;
import com.annanobilis.repository.EmployeeDao;

import java.util.Scanner;

public class SaveNewEmployeeButton implements MenuItem {
    private final EmployeeDao employeeDao = new EmployeeDao();

    @Override
    public void run() {
        Employee e = inputNewEmployee();
        e = employeeDao.save(e);
        System.out.println(e);
    }

    @Override
    public String getTitle() {
        return "Создать нового работника";
    }

    private Employee inputNewEmployee(){
        Scanner scanner = new Scanner(System.in);
        Employee e = new Employee();
        System.out.println("Введите имя ");
        e.setName(scanner.nextLine());
        System.out.println("Введите должность");
        e.setPost(scanner.nextLine());
        System.out.println("Введите опыт работника ");
        e.setExperience(scanner.nextDouble());
        System.out.println("Введите ID выполняемой задачи ");
        Worktask p = new Worktask();
        p.setId(scanner.nextInt());
        e.setWorktask(p);

        return e;
    }
}
