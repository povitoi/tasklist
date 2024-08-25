package com.halid.test.tasklist.data.dao.impl;

import com.halid.test.tasklist.data.dao.TaskDAO;
import com.halid.test.tasklist.data.domain.Task;
import com.halid.test.tasklist.data.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TaskService implements TaskDAO {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public Task get(long id) {
        return taskRepository.findTaskById(id);
    }

    @Override
    public Task save(Task task) {
        return taskRepository.updateOrInsert(task);
    }

    @Override
    public void delete(long id) {
        taskRepository.deleteTaskById(id);
    }

    @Override
    public Page<Task> getAllByAuthor(long id, int pageNumber, int pageSize, String sortField, Sort.Direction sortDirection) {
        return taskRepository.findTasksByAuthorId(id, PageRequest.of(pageNumber, pageSize, Sort.by(sortDirection, sortField)));
    }

    @Override
    public Page<Task> getAllByExecutor(long id, int pageNumber, int pageSize, String sortField, Sort.Direction sortDirection) {
        return taskRepository.findTasksByExecutorId(id, PageRequest.of(pageNumber, pageSize, Sort.by(sortDirection, sortField)));
    }

}
