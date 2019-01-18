package com.valuepack.complaints.complaints.controller;

import com.valuepack.complaints.complaints.repo.ComplaintsRepository;
import com.valuepack.complaints.complaints.util.CompliantResponse;
import com.valuepack.complaints.complaints.dto.ComplaintsDTO;
import com.valuepack.complaints.complaints.model.Complaints;
import com.valuepack.complaints.complaints.util.Helper;
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
    ComplaintsRepository complaintsRepository;

    @PostMapping("/complaints")
    public CompliantResponse saveComplaint(@RequestHeader("X-Authorization") final String xAuth, @RequestBody ComplaintsDTO complaintsDTO) throws Exception {

        CompliantResponse compliantResponse = new CompliantResponse();
        if (complaintsDTO != null) {
            Complaints complaints;
            if (!StringUtils.isEmpty(complaintsDTO.getId()) && complaintsDTO.getId() > 0) {
                Optional<Complaints> optionalComplaint = complaintsRepository.findById(complaintsDTO.getId());
                if (optionalComplaint.isPresent()) {
                    complaints = optionalComplaint.get();
                    complaints.setComplaintType(complaintsDTO.getComplaintType());
                    compliantResponse.setMessage("Complaint Updated Successfully");
                } else {
                    compliantResponse.setMessage("Complaint Not Found with given Id");
                    return compliantResponse;
                }
            } else {
                complaints = new Complaints();
                compliantResponse.setMessage("Complaint Saved Successfully");
            }

            if (!StringUtils.isEmpty(complaintsDTO.getComplaintType())) {
                complaints.setComplaintType(complaintsDTO.getComplaintType());
            }
            if (!StringUtils.isEmpty(complaintsDTO.getComplaintSeverity())) {
                complaints.setComplaintSeverity(complaintsDTO.getComplaintSeverity());
            }
            if (!StringUtils.isEmpty(complaintsDTO.getSubject())) {
                complaints.setSubject(complaintsDTO.getSubject());
            }
            if (!StringUtils.isEmpty(complaintsDTO.getDescription())) {
                complaints.setDescription(complaintsDTO.getDescription());
            }
            if (!StringUtils.isEmpty(complaintsDTO.getFilePath())) {
                complaints.setFilePath(complaintsDTO.getFilePath());
            }
            if (!StringUtils.isEmpty(complaintsDTO.getFranchise())) {
                complaints.setFranchise(complaintsDTO.getFranchise());
            }
            if (!StringUtils.isEmpty(complaintsDTO.getUser())) {
                complaints.setAppUser(complaintsDTO.getUser());
            }
             complaints = complaintsRepository.save(complaints);

            compliantResponse.setStatus(HttpStatus.OK.value());
            compliantResponse.setPayLoad(complaints);
            return compliantResponse;

        } else {
            compliantResponse.setMessage("Invalid Data");
            compliantResponse.setStatus(HttpStatus.BAD_REQUEST.value());
            return compliantResponse;
        }
    }

    @GetMapping("/complaints")
    public CompliantResponse getComplaints(@RequestHeader("X-Authorization") final String xAuth) throws Exception {
        List<Complaints> complaintsList = complaintsRepository.findAll();

        CompliantResponse compliantResponse = new CompliantResponse();

        if (!StringUtils.isEmpty(complaintsList) && complaintsList.size() > 0) {

            List<ComplaintsDTO> complaintsDTOList = new ArrayList<>();
            for (Complaints complaints : complaintsList) {
                ComplaintsDTO complaintsDTO = new ComplaintsDTO();
                complaintsDTO.setId(complaints.getId());
                complaintsDTO.setComplaintType(1l);
                complaintsDTO.setComplaintSeverity(1l);
                complaintsDTO.setSubject(complaints.getSubject());
                complaintsDTO.setDescription(complaints.getDescription());
                complaintsDTO.setFilePath(complaints.getFilePath());
                complaintsDTO.setNumberOfDaysTktOpened(Helper.compareTwoTimeStamps(complaints.getCreatedDate()));
                complaintsDTO.setCreatedDate(complaints.getCreatedDate());
                complaintsDTO.setFranchise(1l);
                complaintsDTO.setUser(2l);
                complaintsDTOList.add(complaintsDTO);
            }
            compliantResponse.setMessage("Query returned successfully");
            compliantResponse.setStatus(HttpStatus.OK.value());
            compliantResponse.setPayLoad(complaintsDTOList);
            return compliantResponse;
        }
        compliantResponse.setMessage("No Complaints Found");
        compliantResponse.setStatus(HttpStatus.OK.value());
        return compliantResponse;
    }
}
