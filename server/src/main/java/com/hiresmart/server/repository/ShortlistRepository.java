package com.hiresmart.server.repository;

import com.hiresmart.server.entity.Shortlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShortlistRepository extends JpaRepository<Shortlist, Integer> {

    List<Shortlist> findByRecruiterRecruiterId(Integer recruiterId);

    List<Shortlist> findByApplicationApplicationId(Integer applicationId);

}