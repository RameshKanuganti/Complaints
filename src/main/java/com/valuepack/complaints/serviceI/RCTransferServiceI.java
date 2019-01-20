package com.valuepack.complaints.serviceI;

import com.valuepack.complaints.dto.RCTransferDTO;
import com.valuepack.complaints.util.VehicleResponse;

public interface RCTransferServiceI {

    VehicleResponse saveRCTransfer(RCTransferDTO rcTransferDTO);

    VehicleResponse updateRCTransfer(RCTransferDTO rcTransferDTO);

    VehicleResponse getAllRCTransfer();

    VehicleResponse deleteRCTransferById(Long rcId);

    VehicleResponse getRCTransferById(Long rcId);

    VehicleResponse searchComplaintByVehicleNumber(String vehicleNumber);
}
