package com.augite.teamservice.resource;

import com.augite.teamservice.model.ChangeTask;
import com.augite.teamservice.service.ChangeTaskService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/changetask")
public class ChangeTaskResource {


    private ChangeTaskService changeTaskService;

    @Autowired
    public ChangeTaskResource (ChangeTaskService changeTaskService) {
        this.changeTaskService = changeTaskService;
    }

    @PostMapping("/add")
    public ResponseEntity<ChangeTask> addNewChangeTask (@RequestBody ChangeTask changeTask) {
        ChangeTask newChangeTask = this.changeTaskService.addChangeTask(changeTask);
        return new ResponseEntity<>(newChangeTask, HttpStatus.OK);
    }

    @GetMapping("/getrandomctaskno")
    public ResponseEntity<String> getRandomCTaskNo() {
        String randomCTaskNo = changeTaskService.getRandomCTaskNoJSONFormat();
        return new ResponseEntity<>(randomCTaskNo, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<ChangeTask>> getAllChangeTasks() {
        List<ChangeTask> changeTaskList = this.changeTaskService.findAllChangeTasks();
        return new ResponseEntity<>(changeTaskList, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Optional<ChangeTask>> findChangeTask(@PathVariable ("id") Integer id) {
        Optional<ChangeTask> foundChangeTask = this.changeTaskService.findChangeTaskById(id);
        return new ResponseEntity<>(foundChangeTask, HttpStatus.OK);
    }

    @GetMapping("/find/ctaskno/{ctaskno}")
    public ResponseEntity<Optional<ChangeTask>> findChangeTask(@PathVariable ("ctaskno") String cTaskNo) {
        Optional<ChangeTask> foundChangeTask = this.changeTaskService.findChangeTaskBycTaskNo(cTaskNo);
        return new ResponseEntity<>(foundChangeTask, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Optional<ChangeTask>> updateChangeTaskById(@RequestBody ChangeTask changeTask) {
        Optional<ChangeTask> updatedChangeTask = this.changeTaskService.updateChangeTask(changeTask);
        return new ResponseEntity<>(updatedChangeTask, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteChangeTask(@PathVariable("id") Integer id) {
        this.changeTaskService.deleteChangeTask(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/ctaskno/{ctaskno}")
    public ResponseEntity<?> deleteChangeTask(@PathVariable("ctaskno") String cTaskNo) {
        this.changeTaskService.deleteChangeTask(cTaskNo);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
