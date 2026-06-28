package com.hiresmart.server.repository;

import com.hiresmart.server.entity.ApplicationStatusHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplicationStatusHistoryRepository extends JpaRepository<ApplicationStatusHistory, Integer> {

    List<ApplicationStatusHistory> findByApplicationApplicationId(Integer applicationId);

}