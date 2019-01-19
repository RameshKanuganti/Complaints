package com.valuepack.complaints.serviceImpl;

import com.valuepack.complaints.component.Messages;
import com.valuepack.complaints.dto.ComplaintsDTO;
import com.valuepack.complaints.model.Complaints;
import com.valuepack.complaints.repo.ComplaintsRepository;
import com.valuepack.complaints.serviceI.ComplaintsServiceI;
import com.valuepack.complaints.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ComplaintsServiceImpl implements ComplaintsServiceI {

    @Autowired
    ComplaintsRepository complaintsRepository;

    @Autowired
    Messages messageService;

    @Override
    public ComplaintResponse saveComplaint(ComplaintsDTO complaintsDTO) {

        ComplaintResponse complaintResponse = new ComplaintResponse();
        if (complaintsDTO != null) {
            Complaints complaints;
            if (!StringUtils.isEmpty(complaintsDTO.getId()) && complaintsDTO.getId() > 0) {
                Optional<Complaints> optionalComplaint = complaintsRepository.findById(complaintsDTO.getId());
                if (optionalComplaint.isPresent()) {
                    complaints = optionalComplaint.get();
                    complaintResponse.setMessage(messageService.getMessage("complaint.update"));
                } else {
                    complaintResponse.setMessage(messageService.getMessage("complaint.not.found"));
                    return complaintResponse;
                }
            } else {
                complaints = new Complaints();
                complaintResponse.setMessage(messageService.getMessage("complaint.save"));
            }

            if (!StringUtils.isEmpty(complaintsDTO.getComplaintType())) {
                complaints.setComplaintType(ComplaintTypeEnum.valueOf(complaintsDTO.getComplaintType()));
            }
            if (!StringUtils.isEmpty(complaintsDTO.getComplaintSeverity())) {
                complaints.setComplaintSeverity(ComplaintSeverityEnum.valueOf(complaintsDTO.getComplaintSeverity()));
            }
            if (!StringUtils.isEmpty(complaintsDTO.getComplaintStatus())) {
                complaints.setComplaintStatus(ComplaintStatusEnum.valueOf(complaintsDTO.getComplaintStatus()));
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
            if (!StringUtils.isEmpty(complaintsDTO.getAppUser())) {
                complaints.setAppUser(complaintsDTO.getAppUser());
            }
            complaints = complaintsRepository.save(complaints);

            complaintResponse.setStatus(HttpStatus.OK.value());
            complaintResponse.setPayLoad(complaints);
            return complaintResponse;

        } else {
            complaintResponse.setMessage(messageService.getMessage("invalid.data"));
            complaintResponse.setStatus(HttpStatus.BAD_REQUEST.value());
            return complaintResponse;
        }
    }

    @Override
    public ComplaintResponse getAllComplaints() {

        List<Complaints> complaintsList = complaintsRepository.findAll();
        ComplaintResponse complaintResponse = new ComplaintResponse();
        if (!StringUtils.isEmpty(complaintsList) && complaintsList.size() > 0) {
            List<ComplaintsDTO> complaintsDTOList = new ArrayList<>();
            for (Complaints complaints : complaintsList) {
                ComplaintsDTO complaintsDTO = new ComplaintsDTO();
                complaintsDTO.setId(complaints.getId());
                complaintsDTO.setComplaintType(StringUtils.isEmpty(complaints.getComplaintType()) ? null : complaints.getComplaintType().getComplaintType());
                complaintsDTO.setComplaintSeverity(StringUtils.isEmpty(complaints.getComplaintSeverity()) ? null : complaints.getComplaintSeverity().getComplaintSeverity());
                complaintsDTO.setComplaintStatus(StringUtils.isEmpty(complaints.getComplaintStatus()) ? null : complaints.getComplaintStatus().getComplaintStatus());
                complaintsDTO.setSubject(complaints.getSubject());
                complaintsDTO.setDescription(complaints.getDescription());
                complaintsDTO.setFilePath(complaints.getFilePath());
                complaintsDTO.setNumberOfDaysTktOpened(Helper.compareTwoTimeStamps(complaints.getCreatedDate()));
                complaintsDTO.setCreatedDate(complaints.getCreatedDate());
                complaintsDTO.setFranchise(1l);
                complaintsDTO.setAppUser(2l);
                complaintsDTOList.add(complaintsDTO);
            }
            complaintResponse.setMessage(messageService.getMessage("success.message"));
            complaintResponse.setStatus(HttpStatus.OK.value());
            complaintResponse.setPayLoad(complaintsDTOList);
            return complaintResponse;
        }
        complaintResponse.setMessage(messageService.getMessage("complaint.no"));
        complaintResponse.setStatus(HttpStatus.OK.value());
        return complaintResponse;
    }
}
