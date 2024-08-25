package com.halid.test.tasklist.data.dao.impl;

import com.halid.test.tasklist.data.dao.CommentDAO;
import com.halid.test.tasklist.data.domain.Task;
import com.halid.test.tasklist.data.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CommentService implements CommentDAO {

    @Autowired
    CommentRepository commentRepository;

    @Override
    public Task.Comment get(long id) {
        return commentRepository.findById(id).get();
    }

    @Override
    public Task.Comment save(Task.Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public void delete(long id) {
        commentRepository.deleteById(id);
    }

    @Override
    public Page<Task.Comment> getAllByTask(long id, int pageNumber, int pageSize, String sortField, Sort.Direction sortDirection) {
        return commentRepository.findCommentsByTaskId(id, PageRequest.of(pageNumber, pageSize, Sort.by(sortDirection, sortField)));
    }
}
