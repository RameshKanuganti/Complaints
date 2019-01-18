package com.valuepack.complaints.complaints.repo;

import com.valuepack.complaints.complaints.model.ComplaintType;
import com.valuepack.complaints.complaints.model.Complaints;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ComplaintTypeRepository extends JpaRepository<ComplaintType, Long> {

    List<ComplaintType> findAll();

    Complaints findTop1ByComplaints(Long complaint);
}
