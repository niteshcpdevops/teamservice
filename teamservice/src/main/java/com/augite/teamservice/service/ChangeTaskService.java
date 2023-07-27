package com.augite.teamservice.service;

import com.augite.teamservice.model.ChangeTask;
import com.augite.teamservice.repo.ChangeTaskRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
@Transactional
public class ChangeTaskService {

    private ChangeTaskRepo changeTaskRepo;

    @Autowired
    public ChangeTaskService(ChangeTaskRepo changeTaskRepo) {
        this.changeTaskRepo = changeTaskRepo;
    }

    public ChangeTask addChangeTask(ChangeTask changeTask) {
    	changeTask.setDateTimeCreated(new Date());
    	changeTask.setDateTimeModified(new Date());
        return this.changeTaskRepo.save(changeTask);
    }

    public Optional<ChangeTask> findChangeTaskById(Integer id) {
        return this.changeTaskRepo.findChangeTaskById(id);
    }

    public Optional<ChangeTask> findChangeTaskBycTaskNo(String cTaskNo) {
        return this.changeTaskRepo.findChangeTaskBycTaskNo(cTaskNo);
    }

    public void deleteChangeTask(Integer id) {
        this.changeTaskRepo.deleteChangeTaskById(id);
    }

    public void deleteChangeTask(String cTaskNo) {
        this.changeTaskRepo.deleteChangeTaskBycTaskNo(cTaskNo);
    }

    public List<ChangeTask> findAllChangeTasks() {
        return this.changeTaskRepo.findAll();
    }

    public String getRandomCTaskNo() {
        return ("CTA" + new Random().nextInt()).replaceAll("-","");
    }

    public String getRandomCTaskNoJSONFormat() {
        return "{\"cTaskNo\": \""+getRandomCTaskNo()+"\"}";
    }

    public Optional<ChangeTask> updateChangeTask(ChangeTask changeTask) {
        this.changeTaskRepo.findChangeTaskBycTaskNo(changeTask.getcTaskNo()).ifPresent(
                updatedChangeTask -> {
                    updatedChangeTask.setcTaskShortDesc(changeTask.getcTaskShortDesc());
                    updatedChangeTask.setcTaskLongDesc(changeTask.getcTaskLongDesc());
                    updatedChangeTask.setGroupName(changeTask.getGroupName());
                    updatedChangeTask.setcTaskAssignedTo(changeTask.getcTaskAssignedTo());
                    updatedChangeTask.setcTaskState(changeTask.getcTaskState());
                    updatedChangeTask.setChangeNo(changeTask.getChangeNo());
                    updatedChangeTask.setcTaskPlannedStartDateTime(changeTask.getcTaskPlannedStartDateTime());
                    updatedChangeTask.setcTaskPlannedEndDateTime(changeTask.getcTaskPlannedEndDateTime());
                    updatedChangeTask.setDateTimeModified(new Date());

                    this.changeTaskRepo.save(updatedChangeTask);
                }
        );

        //changeTask.setDateTimeModified(new Date());
        //String cTaskNo = changeTask.getcTaskNo();
        return this.changeTaskRepo.findChangeTaskBycTaskNo(changeTask.getcTaskNo());
    }

}
