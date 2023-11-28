package com.annanobilis.repository;

import com.annanobilis.DatabaseConnector;
import com.annanobilis.entity.Worktask;

import java.sql.Connection;
import java.util.List;

public class WorktaskDao implements CrudDao<Worktask> {
    private final Connection connection = DatabaseConnector.getConnection();

    @Override
    public List<Worktask> findAll() {
        return null;
    }

    @Override
    public Worktask findById(int id) {
        return null;
    }

    @Override
    public Worktask save(Worktask entity) {
        return null;
    }

    @Override
    public void update(Worktask entity) {

    }

    @Override
    public void delete(Worktask entity) {

    }
}
