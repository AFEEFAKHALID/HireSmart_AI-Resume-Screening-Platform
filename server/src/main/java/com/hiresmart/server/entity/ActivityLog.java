package com.hiresmart.server.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name="activity_logs")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ActivityLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="activity_id")
    private Integer activityId;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    private String activity;

    @Column(name="activity_time", insertable=false, updatable=false)
    private LocalDateTime activityTime;

    @Column(name="ip_address")
    private String ipAddress;

    private String browser;

    @Column(name="operating_system")
    private String operatingSystem;

}

