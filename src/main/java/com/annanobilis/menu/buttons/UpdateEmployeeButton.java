package com.annanobilis.menu.buttons;

import com.annanobilis.entity.Employee;
import com.annanobilis.entity.Worktask;
import com.annanobilis.menu.MenuItem;
import com.annanobilis.repository.EmployeeDao;

import java.util.Scanner;

public class UpdateEmployeeButton implements MenuItem {

    private final EmployeeDao employeeDao = new EmployeeDao();
    @Override
    public void run() {
        Employee e = updateEmployee();
        employeeDao.update(e);
    }

    @Override
    public String getTitle() {
        return "Изменить данные работника";
    }

    private Employee updateEmployee(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите ID работника, данные которого необходимо изменить");
        int id = scanner.nextInt();

        Employee e = employeeDao.findById(id);
        System.out.println(e);

        System.out.println("Введите новые данные:");

        System.out.println("Введите имя в формате Имя-Фамилия (если данные не изменяются, введите \"*\" )");
        String s = scanner.next();
        String b = "*";
        if(!s.equals(b)){
            String d = s.replace("-"," ");
            e.setName(d);
        }

        System.out.println("Введите должность в формате Занимаемая-должность (если данные не изменяются, введите \"*\" )");
        String post = scanner.next();
        if(!s.equals(b)){
            String d = post.replace("-"," ");
            e.setPost(d);
        }

        System.out.println("Введите стаж (если данные не изменяются, введите \"-1\" )");
        double experience = scanner.nextDouble();
        if(experience != -1){
            e.setExperience(experience);
        }

        return e;
    }
}
