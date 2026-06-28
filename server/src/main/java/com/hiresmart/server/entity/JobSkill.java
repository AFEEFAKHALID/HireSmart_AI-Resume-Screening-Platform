package com.hiresmart.server.entity;

import com.hiresmart.server.enums.SkillProficiency;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="job_skills")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JobSkill {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name="job_id")
    private Job job;

    @ManyToOne
    @JoinColumn(name="skill_id")
    private Skill skill;

    @Enumerated(EnumType.STRING)
    @Column(name="required_level")
    private SkillProficiency requiredLevel;

    private Boolean mandatory;

}