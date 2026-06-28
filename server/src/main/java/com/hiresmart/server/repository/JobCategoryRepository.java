package com.hiresmart.server.repository;

import com.hiresmart.server.entity.JobCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface JobCategoryRepository extends JpaRepository<JobCategory,Integer>{

    Optional<JobCategory> findByCategoryName(String categoryName);

}