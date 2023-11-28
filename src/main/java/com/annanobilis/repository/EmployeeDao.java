package com.annanobilis.repository;

import com.annanobilis.DatabaseConnector;
import com.annanobilis.entity.Employee;
import com.annanobilis.entity.Worktask;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao implements CrudDao<Employee> {
    private final Connection connection = DatabaseConnector.getConnection();

    @Override
    public List<Employee> findAll() {
        List<Employee> employee = new ArrayList<>();

        try {
            PreparedStatement ps = connection.prepareStatement
                    ("select * from employee_agpz join worktask_agpz on worktask_agpz.id = employee_agpz.id_worktask");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Employee e = new Employee();
                e.setId(rs.getInt(1));
                e.setName(rs.getString(2));
                e.setPost(rs.getString(3));
                e.setExperience(rs.getDouble(4));

                Worktask worktask = new Worktask();
                worktask.setId(rs.getInt(6));
                worktask.setTask(rs.getString(7));
                worktask.setPlace(rs.getString(8));


                e.setWorktask(worktask);


                employee.add(e);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }

    @Override
    public Employee findById(int id) {
        return null;
    }

    @Override
    public Employee save(Employee entity) {
        return null;
    }

    @Override
    public void update(Employee entity) {

    }

    @Override
    public void delete(Employee entity) {

    }
}
