package com.valuepack.complaints.repo;

import com.valuepack.complaints.model.ComplaintSeverity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComplaintSeverityRepository extends JpaRepository<ComplaintSeverity, Long> {

}
