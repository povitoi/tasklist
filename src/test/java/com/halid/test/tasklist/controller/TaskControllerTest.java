//package com.halid.train.demo.controller;
//
//import com.halid.train.demo.data.dao.impl.TaskService;
//import com.halid.train.demo.data.domain.Task;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//import static org.mockito.Mockito.*;
//
//@ExtendWith(MockitoExtension.class)
//class TaskControllerTest {
//
//    @Mock
//    TaskService taskService;
//
//    @InjectMocks
//    TaskController taskController;
//
//    @Test
//    void createTask_ReceivedTaskIsNull_saveAndFlushMethodIsNotCalled() {
//        //given
//        Task task = null;
//
//        when(taskController.createTask(task)).thenReturn(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
//
//        //when
//        var responseEntity = taskController.createTask(task);
//
//        //then
//        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
//        verify(taskService, never()).save(task);
//    }
//
//    @Test
//    void createTask_TaskAlreadyExists_saveAndFlushMethodIsNotCalled() {
//        //given
//        Task task = new Task();
//
//        when(taskService.get(task.getId())).thenReturn(task);
//
//        //when
//        var responseEntity = taskController.createTask(task);
//
//        //then
//        assertEquals(HttpStatus.CONFLICT, responseEntity.getStatusCode());
//        verify(taskService, never()).save(task);
//    }
//
//    @Test
//    void createTask_TaskIsNotExists_saveAndFlushMethodIsCalled() {
//        //given
//        Task task = new Task();
//
//        when(taskService.get(task.getId())).thenReturn(null);
//        when(taskService.save(task)).thenReturn(task);
//
//        //when
//        var responseEntity = taskController.createTask(task);
//
//        //then
//        assertNotNull(responseEntity);
//        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
//        verify(taskService, only()).save(task);
//    }
//
//    @Test
//    void deleteTask_TaskIsNotExists_deleteMethodIsNotCalled() {
//        //given
//        long id = 1L;
//
//        when(taskService.get(id)).thenReturn(null);
//
//        //when
//        var responseEntity = taskController.deleteTask(id);
//
//        //then
//        assertEquals(HttpStatus.CONFLICT, responseEntity.getStatusCode());
//        verify(taskService, never()).delete(id);
//    }
//
//    @Test
//    void deleteTask_TaskIsFound_deleteMethodIsCalled() {
//        //given
//        long id = 1L;
//
//        taskService.delete(id);
//
//        //when
//        var responseEntity = taskController.deleteTask(id);
//
//        //then
//        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
//        verify(taskService, only()).delete(id);
//    }
//
//    @Test
//    void updateTitle_TitleIsNull_updateMethodIsNotCalled() {
//        //given
//        long id = 1L;
//        String title = null;
//        Task task = new Task();
//
//        //when
//        var responseEntity = taskController.updateTitle(id, title);
//
//        //then
//        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
//        verify(taskService, never()).save(task);
//    }
//
//    @Test
//    void updateTitle_TaskIsNotExists_updateMethodIsNotCalled() {
//        //given
//        long id = 1L;
//        String title = "title";
//
//        when(taskService.get(id)).thenReturn(null);
//
//        //when
//        var ResponseEntity = taskController.updateTitle(id, title);
//
//        //then
//        assertEquals(HttpStatus.NOT_FOUND, ResponseEntity.getStatusCode());
//        verify(taskService, never()).save(any(Task.class));
//    }
//
//    @Test
//    void updateTitle_TaskIsFound_updateMethodIsCalled() {
//        //given
//        long id = 1L;
//        String title = "title";
//        Task task = new Task();
//
//        when(taskService.get(id)).thenReturn(task);
//
//        //when
//        var ResponseEntity = taskController.updateTitle(id, title);
//
//        //then
//        assertEquals(HttpStatus.OK, ResponseEntity.getStatusCode());
//        verify(taskService, only()).save(any(Task.class));
//    }
//
//}