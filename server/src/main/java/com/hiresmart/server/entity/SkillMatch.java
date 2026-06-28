package com.hiresmart.server.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name="skill_matches")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SkillMatch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="match_id")
    private Integer matchId;

    @ManyToOne
    @JoinColumn(name="analysis_id")
    private ResumeAnalysis analysis;

    @ManyToOne
    @JoinColumn(name="skill_id")
    private Skill skill;

    @Column(name="match_percentage")
    private BigDecimal matchPercentage;

    @Column(name="is_present")
    private Boolean present;

}