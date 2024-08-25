package com.halid.test.tasklist.data.repository;

import com.halid.test.tasklist.data.domain.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    Task findTaskById(long id);

    Page<Task> findTasksByAuthorId(long id, Pageable pageable);

    Page<Task> findTasksByExecutorId(long id, Pageable pageable);

    default Task updateOrInsert(Task task) {
        return saveAndFlush(task);
    }

    default void deleteTaskById(long id) {
        deleteById(id);
    }

}

