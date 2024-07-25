package org.myfitnesstrackingapp.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.myfitnesstrackingapp.model.entity.enums.DietCategory;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "diets")
@Getter
@Setter
public class Diet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private DietCategory category;

    @Column(nullable = false)
    private Integer calories;

    @Column(nullable = false)
    private String nutrients;

    @ManyToOne
    private User addedBy;

    @OneToMany
    private Set<Comment> comments;

    @Column(name = "number_of_selections")
    private Integer numberOfSelections;
    private Integer likes;

    public Diet(){
        this.comments = new HashSet<>();
    }
}
