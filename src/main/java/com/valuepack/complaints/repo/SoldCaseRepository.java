package com.valuepack.complaints.repo;

import com.valuepack.complaints.model.SoldCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SoldCaseRepository extends JpaRepository<SoldCase, Long> {

}
