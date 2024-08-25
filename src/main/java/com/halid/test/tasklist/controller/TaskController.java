package com.halid.test.tasklist.controller;

import com.halid.test.tasklist.data.dao.impl.TaskService;
import com.halid.test.tasklist.data.domain.Task;
import com.halid.test.tasklist.data.domain.User;
import com.halid.test.tasklist.enumeration.TaskPriority;
import com.halid.test.tasklist.enumeration.TaskStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    private final String taskDoesNotExists = "Task does not exists";

    @PostMapping("/task/create")
    public ResponseEntity<?> createTask(@RequestBody Task task) {
        if (task == null)
            return ResponseEntity.badRequest().body("Received task is null");

        Task storedTask = taskService.get(task.getId());
        if (storedTask != null)
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Task already exists");
        else {
            taskService.save(task);
            return ResponseEntity.status(HttpStatus.CREATED).body(task);
        }

    }

    @DeleteMapping("/task/delete")
    public ResponseEntity<?> deleteTask(@RequestParam long id) {
        Task storedTask = taskService.get(id);

        if (storedTask == null)
            return ResponseEntity.status(HttpStatus.CONFLICT).body(taskDoesNotExists);
        else {
            taskService.delete(storedTask.getId());
            return ResponseEntity.status(HttpStatus.OK).body(storedTask);
        }
    }

    @PostMapping("/tast/update_title")
    public ResponseEntity<?> updateTitle(@RequestParam long id, @RequestBody String title) {
        if (title == null)
            return ResponseEntity.badRequest().body("Received title is null");

        Task storedTask = taskService.get(id);
        if (storedTask == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(taskDoesNotExists);

        storedTask.setTitle(title);
        taskService.save(storedTask);
        return ResponseEntity.status(HttpStatus.OK).body(storedTask);
    }

    @PostMapping("/tast/update_description")
    public ResponseEntity<?> updateDescription(@RequestParam long id, @RequestBody String description) {
        if (description == null)
            return ResponseEntity.badRequest().body("Received description is null");

        Task storedTask = taskService.get(id);
        if (storedTask == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(taskDoesNotExists);

        storedTask.setDescription(description);
        taskService.save(storedTask);
        return ResponseEntity.status(HttpStatus.OK).body(storedTask);
    }

    @PostMapping("/tast/update_status")
    public ResponseEntity<?> updateStatus(@RequestParam long id, @RequestBody TaskStatus status) {
        if (status == null)
            return ResponseEntity.badRequest().body("Received status is null");

        Task storedTask = taskService.get(id);
        if (storedTask == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(taskDoesNotExists);

        storedTask.setStatus(status);
        taskService.save(storedTask);
        return ResponseEntity.status(HttpStatus.OK).body(storedTask);
    }

    @PostMapping("/tast/update_priority")
    public ResponseEntity<?> updatePriority(@RequestParam long id, @RequestBody TaskPriority priority) {
        if (priority == null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Received priority is null");

        Task storedTask = taskService.get(id);
        if (storedTask == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(taskDoesNotExists);


        storedTask.setPriority(priority);
        taskService.save(storedTask);
        return ResponseEntity.status(HttpStatus.OK).body(storedTask);
    }

    @PostMapping("/tast/update_executor")
    public ResponseEntity<?> updateExecutor(@RequestParam long id, @RequestBody User executor) {
        if (executor == null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Received executor is null");

        Task storedTask = taskService.get(id);
        if (storedTask == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(taskDoesNotExists);


        storedTask.setExecutor(executor);
        taskService.save(storedTask);
        return ResponseEntity.status(HttpStatus.OK).body(storedTask);
    }

    @GetMapping("/task/get")
    public ResponseEntity<Task> getTask(@RequestParam long id) {
        Task task = taskService.get(id);
        if (task != null) {
            return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(task);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/task/get_list_by_author")
    public ResponseEntity<List<Task>> getTaskListByAuthor(
            @RequestParam long id,
            @RequestParam int pageNumber,
            @RequestParam int pageSize,
            @RequestParam String sortField,
            @RequestParam Sort.Direction sortDirection) {

        Page<Task> tasksPage = taskService.getAllByAuthor(id, pageNumber, pageSize, sortField, sortDirection);
        if (tasksPage.hasContent()) {
            return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(tasksPage.getContent());
        } else
            return ResponseEntity.notFound().build();
    }

    @GetMapping("/task/get_list_by_executor")
    public ResponseEntity<List<Task>> getTaskListByExecutor(
            @RequestParam long id,
            @RequestParam int pageNumber,
            @RequestParam int pageSize,
            @RequestParam String sortField,
            @RequestParam Sort.Direction sortDirection) {

        Page<Task> tasksPage = taskService.getAllByExecutor(id, pageNumber, pageSize, sortField, sortDirection);
        if (tasksPage.hasContent()) {
            return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(tasksPage.getContent());
        } else
            return ResponseEntity.notFound().build();
    }

}