package com.hiresmart.server.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="recommendations")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Recommendation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="recommendation_id")
    private Integer recommendationId;

    @ManyToOne
    @JoinColumn(name="analysis_id")
    private ResumeAnalysis analysis;

    @Column(columnDefinition="LONGTEXT")
    private String recommendation;

    private Integer priority;

}