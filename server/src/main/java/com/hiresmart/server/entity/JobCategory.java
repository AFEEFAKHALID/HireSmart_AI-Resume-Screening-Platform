package com.hiresmart.server.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name="job_categories")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JobCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="category_id")
    private Integer categoryId;

    @Column(name="category_name",nullable=false,unique=true)
    private String categoryName;

    @Column(columnDefinition="TEXT")
    private String description;

    @Column(name="created_at",insertable=false,updatable=false)
    private LocalDateTime createdAt;

}