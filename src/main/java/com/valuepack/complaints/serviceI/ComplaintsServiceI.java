package com.valuepack.complaints.serviceI;

import com.valuepack.complaints.dto.ComplaintsDTO;
import com.valuepack.complaints.util.ComplaintResponse;

public interface ComplaintsServiceI {

    ComplaintResponse saveComplaint(ComplaintsDTO complaintsDTO);

    ComplaintResponse getAllComplaints();
}
