package com.javaCrudApp.repository;

import com.javaCrudApp.model.Task;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface TaskRepository  extends MongoRepository <Task, String> {
    List<Task> findBySeverity(int serverity);

    @Query("{assignee: ?0}")
    List<Task> findByAssignee(String name);
}
