package com.halid.test.tasklist.data.domain;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;

@Entity
@Table(name = "user", catalog = "tasklist")
@EqualsAndHashCode
@Getter @Setter
@DynamicInsert
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(
//            catalog = "tasklist",
//            name = "users_roles",
//            joinColumns = @JoinColumn(name = "user_id"),
//            inverseJoinColumns = @JoinColumn(name = "role_id"))
//    private Set<UserRole> roles;

//    @Column(nullable = false)
//    private boolean enabled;

    @Column(unique = true, nullable = false)
    private String email;
//    @Column(nullable = false)
//    private String password;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;

}
