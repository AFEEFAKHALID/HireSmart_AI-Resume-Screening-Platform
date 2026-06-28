package com.hiresmart.server.entity;

import com.hiresmart.server.enums.ReportType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name="reports")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="report_id")
    private Integer reportId;

    @Column(name="report_name")
    private String reportName;

    @Enumerated(EnumType.STRING)
    @Column(name="report_type")
    private ReportType reportType;

    @ManyToOne
    @JoinColumn(name="generated_by")
    private User generatedBy;

    @Column(name="generated_at", insertable=false, updatable=false)
    private LocalDateTime generatedAt;

    @Column(name="report_file")
    private String reportFile;

}