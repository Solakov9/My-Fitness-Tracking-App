package org.myfitnesstrackingapp.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.myfitnesstrackingapp.model.entity.enums.Level;
import org.myfitnesstrackingapp.model.entity.enums.WorkoutCategory;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "workouts")
@Getter
@Setter
public class Workout {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private WorkoutCategory category;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Level level;

    @ManyToOne(optional = false)
    private User addedBy;

    @Column
    private String exercises;

    @OneToMany
    private Set<Comment> comments;

    @Column(name = "number_of_selections")
    private Integer numberOfSelections;

    private Integer likes;

    public Workout(){
        this.comments = new HashSet<>();
    }
}
