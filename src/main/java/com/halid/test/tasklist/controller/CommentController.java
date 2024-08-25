package com.halid.test.tasklist.controller;

import com.halid.test.tasklist.data.dao.impl.CommentService;
import com.halid.test.tasklist.data.domain.Task;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @GetMapping("/comment/get")
    public ResponseEntity<Task.Comment> getComment(@RequestParam long id) {
        Task.Comment comment = commentService.get(id);
        if (comment != null)
            return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(comment);
        else
            return ResponseEntity.notFound().build();
    }

    @GetMapping("/comment/get_comments_by_task_id")
    public ResponseEntity<List<Task.Comment>> getComment(
            @RequestParam long id,
            @RequestParam int pageNumber,
            @RequestParam int pageSize,
            @RequestParam String sortField,
            @RequestParam Sort.Direction sortDirection) {
        Page<Task.Comment> commentPage = commentService.getAllByTask(id, pageNumber, pageSize, sortField, sortDirection);
        if (commentPage != null)
            return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(commentPage.getContent());
        else
            return ResponseEntity.notFound().build();
    }

    @PostMapping("/comment/post_comment")
    public ResponseEntity<?> postComment(@RequestBody Task.Comment comment) {
        if (comment == null)
            return ResponseEntity.badRequest().body("Received comment is null");

        Task.Comment storedComment = commentService.get(comment.getId());
        if (storedComment != null)
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Comment already exists");
        else {
            commentService.save(comment);
            return ResponseEntity.status(HttpStatus.CREATED).body(comment);
        }

    }

}
