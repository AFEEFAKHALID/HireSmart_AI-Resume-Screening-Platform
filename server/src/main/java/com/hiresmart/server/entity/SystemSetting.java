package com.hiresmart.server.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name="system_settings")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SystemSetting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="setting_id")
    private Integer settingId;

    @Column(name="setting_key", unique=true)
    private String settingKey;

    @Column(name="setting_value", columnDefinition="TEXT")
    private String settingValue;

    @Column(columnDefinition="TEXT")
    private String description;

    @Column(name="updated_at", insertable=false, updatable=false)
    private LocalDateTime updatedAt;

}