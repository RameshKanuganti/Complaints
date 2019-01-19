package com.valuepack.complaints.repo;

import com.valuepack.complaints.model.RCTransfer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RCTransferRepository extends JpaRepository<RCTransfer, Long> {

}
