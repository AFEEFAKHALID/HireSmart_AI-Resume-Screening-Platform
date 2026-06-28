package com.hiresmart.server.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name="roles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="role_id")
    private Integer roleId;

    @Column(name="role_name",nullable=false,unique=true)
    private String roleName;

    private String description;

    @Column(name="created_at",insertable=false,updatable=false)
    private LocalDateTime createdAt;

}