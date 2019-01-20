package com.valuepack.complaints.controller;

import com.valuepack.complaints.dto.ComplaintsDTO;
import com.valuepack.complaints.serviceI.ComplaintsServiceI;
import com.valuepack.complaints.util.VehicleResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ComplaintController {

    @Autowired
    ComplaintsServiceI complaintsServiceI;

    @GetMapping("/complaints")
    public VehicleResponse getComplaints() throws Exception {
        return complaintsServiceI.getAllComplaints();
    }

    @GetMapping("/complaints/{complaintId}")
    public VehicleResponse getComplaintsById(@PathVariable final Long complaintId) throws Exception {
        return complaintsServiceI.getAllComplaintById(complaintId);
    }

    @PostMapping("/complaints")
    public VehicleResponse saveComplaint(@RequestHeader("X-Authorization") final String xAuth, @RequestBody ComplaintsDTO complaintsDTO) throws Exception {
        return complaintsServiceI.saveComplaint(complaintsDTO);
    }

    @PutMapping("/complaints")
    public VehicleResponse updateComplaint(@RequestBody ComplaintsDTO complaintsDTO) throws Exception {
        return complaintsServiceI.updateComplaint(complaintsDTO);
    }

    @DeleteMapping("/complaints/{complaintId}")
    public VehicleResponse deleteComplaint(@PathVariable final Long complaintId) throws Exception {
        return complaintsServiceI.deleteComplaint(complaintId);
    }
}
