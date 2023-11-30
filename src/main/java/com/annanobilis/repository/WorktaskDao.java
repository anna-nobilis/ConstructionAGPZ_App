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

public class WorktaskDao implements CrudDao<Worktask> {
    private final Connection connection = DatabaseConnector.getConnection();

    @Override
    public List<Worktask> findAll() {
        List<Worktask> worktasks = new ArrayList<>();

        try {
            PreparedStatement ps = connection.prepareStatement("select * from worktask_agpz");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Worktask worktask = new Worktask();
                worktask.setId(rs.getInt(1));
                worktask.setTask(rs.getString(2));
                worktask.setPlace(rs.getString(3));

                worktasks.add(worktask);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return worktasks;
    }

    @Override
    public Worktask findById(int id) {
        Worktask worktask = new Worktask();

        try {
            PreparedStatement ps = connection.prepareStatement("select * from worktask_agpz where id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                worktask.setId(rs.getInt(1));
                worktask.setTask(rs.getString(2));
                worktask.setPlace(rs.getString(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return worktask;
    }

    @Override
    public Worktask save(Worktask entity) {
        try {
            PreparedStatement ps = connection.prepareStatement(
                    "insert into worktask_agpz (task, place) values (?,?)");
            ps.setString(1, entity.getTask());
            ps.setString(2, entity.getPlace());


            ps.executeUpdate();

            PreparedStatement pst = connection.prepareStatement(
                    "select id from worktask_agpz where task = ? AND place = ?");
            pst.setString(1, entity.getTask());
            pst.setString(2, entity.getPlace());
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
    public Worktask updateoneposition(Worktask entity) {
        return null;
    }

    @Override
    public void update(Worktask entity) {
        try {
            PreparedStatement ps = connection.prepareStatement(
                    "update worktask_agpz set task = ?, place = ? where id = ?");
            ps.setString(1, entity.getTask());
            ps.setString(2, entity.getPlace());
            ps.setInt(3, entity.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Worktask entity){
        try {
            PreparedStatement ps = connection.prepareStatement(
                    "delete from worktask_agpz where id = ?");
            ps.setInt(1,entity.getId());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
