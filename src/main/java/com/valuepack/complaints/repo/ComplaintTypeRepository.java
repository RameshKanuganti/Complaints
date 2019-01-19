package com.valuepack.complaints.repo;

import com.valuepack.complaints.model.ComplaintType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComplaintTypeRepository extends JpaRepository<ComplaintType, Long> {

}
