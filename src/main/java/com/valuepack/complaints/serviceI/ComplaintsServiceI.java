package com.valuepack.complaints.serviceI;

import com.valuepack.complaints.dto.ComplaintsDTO;
import com.valuepack.complaints.util.VehicleResponse;

public interface ComplaintsServiceI {

    VehicleResponse saveComplaint(ComplaintsDTO complaintsDTO);

    VehicleResponse updateComplaint(ComplaintsDTO complaintsDTO);

    VehicleResponse getAllComplaints();

    VehicleResponse deleteComplaint(Long complaintId);
}
