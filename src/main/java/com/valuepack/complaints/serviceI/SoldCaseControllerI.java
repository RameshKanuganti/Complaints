package com.valuepack.complaints.serviceI;

import com.valuepack.complaints.dto.SoldCaseDTO;
import com.valuepack.complaints.util.VehicleResponse;

public interface SoldCaseControllerI {

    VehicleResponse getAllSoldCases();

    VehicleResponse saveSoldCase(SoldCaseDTO soldCaseDTO);

    VehicleResponse updateSoldCase(SoldCaseDTO soldCaseDTO);

    VehicleResponse deleteSoldCase(Long soldCaseId);
}
