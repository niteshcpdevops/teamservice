package com.augite.teamservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.augite.teamservice.model.ChangeTask;

import java.util.Optional;

public interface ChangeTaskRepo extends JpaRepository<ChangeTask, Integer> {

    Optional<ChangeTask> findChangeTaskById(Integer id);

    Optional<ChangeTask> findChangeTaskBycTaskNo(String cTaskNo);

    //ChangeTask updateChangeTaskByCtaskNo(String cTaskNo);

    void deleteChangeTaskById(Integer id);

    void deleteChangeTaskBycTaskNo(String cTaskNo);
}
