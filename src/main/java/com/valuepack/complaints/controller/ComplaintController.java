package com.valuepack.complaints.controller;

import com.valuepack.complaints.repo.ComplaintsRepository;
import com.valuepack.complaints.serviceI.ComplaintsServiceI;
import com.valuepack.complaints.util.ComplaintResponse;
import com.valuepack.complaints.dto.ComplaintsDTO;
import com.valuepack.complaints.model.Complaints;
import com.valuepack.complaints.util.Helper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class ComplaintController {

    @Autowired
    ComplaintsServiceI complaintsServiceI;


    @PostMapping("/complaints")
    public ComplaintResponse saveComplaint(@RequestHeader("X-Authorization") final String xAuth, @RequestBody ComplaintsDTO complaintsDTO) throws Exception {
        return complaintsServiceI.saveComplaint(complaintsDTO);
    }

    @GetMapping("/complaints")
    public ComplaintResponse getComplaints() throws Exception {
        return complaintsServiceI.getAllComplaints();
    }
}
