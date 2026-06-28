package com.hiresmart.server.repository;

import com.hiresmart.server.entity.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReportRepository extends JpaRepository<Report, Integer> {

    List<Report> findByGeneratedByUserId(Integer userId);

}