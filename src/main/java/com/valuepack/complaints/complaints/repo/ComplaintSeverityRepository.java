package com.valuepack.complaints.complaints.repo;

import com.valuepack.complaints.complaints.model.ComplaintSeverity;
import com.valuepack.complaints.complaints.model.Complaints;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ComplaintSeverityRepository extends JpaRepository<ComplaintSeverity, Long> {

}
