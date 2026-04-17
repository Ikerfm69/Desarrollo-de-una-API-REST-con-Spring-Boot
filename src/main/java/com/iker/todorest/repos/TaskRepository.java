package com.iker.todorest.repos;

import com.iker.todorest.model.Task;
import com.iker.todorest.users.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByAuthor(User author);
}
