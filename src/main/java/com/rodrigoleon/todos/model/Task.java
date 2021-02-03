package com.rodrigoleon.todos.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String title;

    @NotNull
    private boolean isCompleted;

//    @NotNull
//    @JsonBackReference(value = "taskUser")
//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "id_user", nullable = false)
//    private User user;

}
