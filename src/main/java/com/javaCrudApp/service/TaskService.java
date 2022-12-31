package com.javaCrudApp.service;

import com.javaCrudApp.model.Task;
import com.javaCrudApp.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TaskService {

    @Autowired
    private TaskRepository repository;

    //CRUD

    // Create
    public Task addTask(Task task) {
        task.setTaskId(UUID.randomUUID().toString().split("-")[0]);
        return repository.save(task);
    }

    // Read
    public List<Task> findAllTasks() {
        return repository.findAll();
    }

    public Task getTaskbyId(String taskId) {
        return repository.findById(taskId).get();
    }

    public List<Task> getTaskBySeverity(int serverity) {
        return repository.findBySeverity(serverity);
    }

    public List<Task> getTaskbyAssignee(String name) {
        return repository.findByAssignee(name);

    }

    // update

    public Task updateTask(Task taskRequest) {
        Task existingTask = repository.findById(taskRequest.getTaskId()).get();
        existingTask.setDescription(taskRequest.getDescription());
        existingTask.setAssignee(taskRequest.getAssignee());
        existingTask.setStoryPoint(taskRequest.getStoryPoint());
        existingTask.setSeverity(taskRequest.getSeverity());
        return repository.save(existingTask);
    }

    // Delete
    public String deleteTask(String taskId) {
        repository.deleteById(taskId);
        return "Successfully deleted task " + taskId;
    }
}
