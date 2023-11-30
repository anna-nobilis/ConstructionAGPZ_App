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
        Employee em = new Employee();
        String sql = "select * from employee_agpz join worktask_agpz on worktask_agpz.id = employee_agpz.id_worktask where employee_agpz.id = ?";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                em.setId(rs.getInt(1));
                em.setName(rs.getString(2));
                em.setPost(rs.getString(3));
                em.setExperience(rs.getDouble(4));

                Worktask worktask = new Worktask();
                worktask.setId(rs.getInt(6));
                worktask.setTask(rs.getString(7));
                worktask.setPlace(rs.getString(8));


                em.setWorktask(worktask);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return em;
    }

    @Override
    public Employee save(Employee entity) {
        try {
            PreparedStatement ps = connection.prepareStatement(
                    "insert into employee_agpz (name, post, experience, id_worktask) values (?,?,?,?)");
            ps.setString(1, entity.getName());
            ps.setString(2, entity.getPost());
            ps.setDouble(3, entity.getExperience());
            ps.setInt(4, entity.getWorktask().getId());

            ps.executeUpdate();

            PreparedStatement pst = connection.prepareStatement(
                    "select id from employee_agpz  where name = ? AND post = ? AND experience = ?");
            pst.setString(1, entity.getName());
            pst.setString(2, entity.getPost());
            pst.setDouble(3, entity.getExperience());
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                entity.setId(rs.getInt(1));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return entity;
    }

    @Override
    public Employee updateoneposition(Employee entity) {
        try {
            PreparedStatement ps = connection.prepareStatement(
                    "update employee_agpz set id_worktask = ? where id = ?");
            ps.setInt(1, entity.getWorktask().getId());
            ps.setInt(2, entity.getId());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return entity;
    }


    @Override
    public void update(Employee entity) {
        try {
            PreparedStatement ps = connection.prepareStatement(
                    "update employee_agpz set name = ?, post = ?, experience = ? where id = ?");
            ps.setString(1, entity.getName());
            ps.setString(2, entity.getPost());
            ps.setDouble(3, entity.getExperience());
            ps.setInt(4, entity.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete (Employee entity){
        try {
            PreparedStatement ps = connection.prepareStatement(
                    "delete from employee_agpz where id = ?");
            ps.setInt(1,entity.getId());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
