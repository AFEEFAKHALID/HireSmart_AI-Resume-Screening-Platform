package com.hiresmart.server.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name="application_status_history")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApplicationStatusHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="history_id")
    private Integer historyId;

    @ManyToOne
    @JoinColumn(name="application_id")
    private Application application;

    @Column(name="previous_status")
    private String previousStatus;

    @Column(name="new_status")
    private String newStatus;

    @ManyToOne
    @JoinColumn(name="changed_by")
    private User changedBy;

    @Column(name="change_date")
    private LocalDateTime changeDate;

    private String remarks;

}