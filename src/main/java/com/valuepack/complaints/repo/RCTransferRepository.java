package com.valuepack.complaints.repo;

import com.valuepack.complaints.model.RCTransfer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RCTransferRepository extends JpaRepository<RCTransfer, Long> {

    List<RCTransfer> findByVehicleNumber(String vehicleNo);
}
