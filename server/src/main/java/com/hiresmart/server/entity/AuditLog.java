package com.hiresmart.server.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name="audit_logs")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuditLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="audit_id")
    private Integer auditId;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    private String action;

    @Column(name="table_name")
    private String tableName;

    @Column(name="record_id")
    private Integer recordId;

    @Column(name="old_value", columnDefinition="LONGTEXT")
    private String oldValue;

    @Column(name="new_value", columnDefinition="LONGTEXT")
    private String newValue;

    @Column(name="action_time", insertable=false, updatable=false)
    private LocalDateTime actionTime;

}