package com.hiresmart.server.entity;

import com.hiresmart.server.enums.Gender;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name="candidate_profiles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CandidateProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="profile_id")
    private Integer profileId;

    @OneToOne
    @JoinColumn(name="candidate_id")
    private Candidate candidate;

    @Column(name="date_of_birth")
    private LocalDate dateOfBirth;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private String nationality;

    private String country;

    private String state;

    private String city;

    private String address;

    @Column(name="postal_code")
    private String postalCode;

    private String bio;

    @Column(name="profile_photo")
    private String profilePhoto;

}