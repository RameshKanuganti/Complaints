package com.valuepack.complaints.repo;

import com.valuepack.complaints.model.Complaints;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface ComplaintsRepository extends JpaRepository<Complaints, Long> {

    List<Complaints> findByCreatedDateAfter(Timestamp createdDate);

    List<Complaints> findByCreatedDateAfterAndCreatedDateBefore(Timestamp date1, Timestamp date2);
}
