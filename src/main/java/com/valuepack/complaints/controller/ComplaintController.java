package com.valuepack.complaints.controller;

import com.valuepack.complaints.exception.ResourceNotFoundException;
import com.valuepack.complaints.serviceI.ComplaintsServiceI;
import com.valuepack.complaints.util.VehicleResponse;
import com.valuepack.complaints.dto.ComplaintsDTO;
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

    @PostMapping("/complaints")
    public VehicleResponse saveComplaint(@RequestHeader("X-Authorization") final String xAuth, @RequestBody ComplaintsDTO complaintsDTO) throws Exception {
        return complaintsServiceI.saveComplaint(complaintsDTO);
    }

    @PutMapping("/complaints")
    public VehicleResponse updateComplaint(@RequestBody ComplaintsDTO complaintsDTO) throws Exception, ResourceNotFoundException {
        return complaintsServiceI.updateComplaint(complaintsDTO);
    }

    @DeleteMapping("/complaints/{complaintId}")
    public VehicleResponse deleteComplaint(@PathVariable final Long complaintId) throws Exception, ResourceNotFoundException {
        return complaintsServiceI.deleteComplaint(complaintId);
    }
}
