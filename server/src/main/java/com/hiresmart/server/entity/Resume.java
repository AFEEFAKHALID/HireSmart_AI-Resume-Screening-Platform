package com.hiresmart.server.entity;

import com.hiresmart.server.enums.FileType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name="resumes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Resume {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="resume_id")
    private Integer resumeId;

    @ManyToOne
    @JoinColumn(name="candidate_id")
    private Candidate candidate;

    @Column(name="resume_title")
    private String resumeTitle;

    @Column(name="original_file_name")
    private String originalFileName;

    @Column(name="stored_file_name")
    private String storedFileName;

    @Column(name="file_path")
    private String filePath;

    @Enumerated(EnumType.STRING)
    @Column(name="file_type")
    private FileType fileType;

    @Column(name="file_size")
    private Long fileSize;

    @Column(name="uploaded_at",insertable=false,updatable=false)
    private LocalDateTime uploadedAt;

    @Column(name="is_default")
    private Boolean isDefault;

}