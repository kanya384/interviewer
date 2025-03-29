package com.java.laurkan.interviewer.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "topics")
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @ManyToOne
    @JoinColumn(name = "parent_id", referencedColumnName = "id")
    private Topic parent;

    @OneToMany(mappedBy = "parent")
    private List<Topic> child;

    @OneToMany(mappedBy = "topic")
    private List<Lesson> lessons;

    @CreatedDate
    @Column(name = "created_at")
    private LocalDate createdAt;

    @LastModifiedDate
    @Column(name = "modified_at")
    private LocalDate modifiedAt;
}
