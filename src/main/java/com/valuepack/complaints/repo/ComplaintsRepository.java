package com.valuepack.complaints.repo;

import com.valuepack.complaints.model.Complaints;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComplaintsRepository extends JpaRepository<Complaints, Long> {




}
