package com.halid.test.tasklist.data.repository;

import com.halid.test.tasklist.data.domain.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Task.Comment, Long> {

    Task.Comment findCommentById(Long id);

    Page<Task.Comment> findCommentsByTaskId(long id, Pageable pageable);

}
