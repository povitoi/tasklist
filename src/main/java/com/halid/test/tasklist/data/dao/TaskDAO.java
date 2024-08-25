package com.halid.test.tasklist.data.dao;

import com.halid.test.tasklist.data.domain.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

public interface TaskDAO extends GeneralDAO<Task> {

    Page<Task> getAllByAuthor(long id, int pageNumber, int pageSize, String sortField, Sort.Direction sortDirection);
    Page<Task> getAllByExecutor(long id, int pageNumber, int pageSize, String sortField, Sort.Direction sortDirection);

}
