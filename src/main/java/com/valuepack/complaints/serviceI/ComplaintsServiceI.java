package com.valuepack.complaints.serviceI;

import com.valuepack.complaints.dto.ComplaintsDTO;
import com.valuepack.complaints.util.VehicleResponse;

import java.sql.Timestamp;

public interface ComplaintsServiceI {

    VehicleResponse saveComplaint(ComplaintsDTO complaintsDTO);

    VehicleResponse updateComplaint(ComplaintsDTO complaintsDTO);

    VehicleResponse getAllComplaints();

    VehicleResponse deleteComplaint(Long complaintId);

    VehicleResponse getAllComplaintById(Long complaintId);

    VehicleResponse searchComplaintByDates(Timestamp fromTime, Timestamp toTime);

}
