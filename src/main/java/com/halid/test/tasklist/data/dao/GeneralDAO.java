package com.halid.test.tasklist.data.dao;

public interface GeneralDAO<T> {
    T get(long id);
    T save(T t);
    void delete(long id);
}
