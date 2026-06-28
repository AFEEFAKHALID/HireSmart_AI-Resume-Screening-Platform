package com.hiresmart.server.entity;

import com.hiresmart.server.enums.NotificationType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name="notifications")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="notification_id")
    private Integer notificationId;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    private String title;

    @Column(columnDefinition="TEXT")
    private String message;

    @Enumerated(EnumType.STRING)
    @Column(name="notification_type")
    private NotificationType notificationType;

    @Column(name="is_read")
    private Boolean isRead;

    @Column(name="created_at", insertable=false, updatable=false)
    private LocalDateTime createdAt;

}