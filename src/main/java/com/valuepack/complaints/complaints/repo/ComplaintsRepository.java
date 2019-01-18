package com.valuepack.complaints.complaints.repo;

import com.valuepack.complaints.complaints.model.Complaints;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ComplaintsRepository extends JpaRepository<Complaints, Long> {

    List<Complaints> findAll();

    Complaints find1ById(Long complaint);
}
