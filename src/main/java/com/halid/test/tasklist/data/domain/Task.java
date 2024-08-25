package com.halid.test.tasklist.data.domain;

import com.halid.test.tasklist.enumeration.TaskPriority;
import com.halid.test.tasklist.enumeration.TaskStatus;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "task", catalog = "tasklist")
@EqualsAndHashCode
@Getter
@Setter
@DynamicUpdate
public class Task {

    public Task() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    private String title;
    private String description;


    @Enumerated(EnumType.STRING)
    private TaskPriority priority;
    @Enumerated(EnumType.STRING)
    private TaskStatus status;

    @ManyToOne
    private User author;
    @ManyToOne
    private User executor;


    @Entity
    @Table(name = "comment", catalog = "tasklist")
    @EqualsAndHashCode
    @Getter @Setter
    @DynamicInsert
    public class Comment {

        public Comment() {
        }

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;

        @ManyToOne
        private User commentator;
        @ManyToOne
        private Task task;

        private String comment;

    }

}
