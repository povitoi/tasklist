package com.halid.test.tasklist.data.dao;

import com.halid.test.tasklist.data.domain.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

public interface CommentDAO extends GeneralDAO<Task.Comment> {

    Page<Task.Comment> getAllByTask(long id, int pageNumber, int pageSize, String sortField, Sort.Direction sortDirection);

}
