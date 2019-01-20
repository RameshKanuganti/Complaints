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

import java.sql.Timestamp;
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
    public VehicleResponse saveComplaint(ComplaintsDTO complaintsDTO) {

        VehicleResponse vehicleResponse = new VehicleResponse();
        if (complaintsDTO != null) {
            Complaints complaints;
            if (!StringUtils.isEmpty(complaintsDTO.getId()) && complaintsDTO.getId() > 0) {
                Optional<Complaints> optionalComplaint = complaintsRepository.findById(complaintsDTO.getId());
                if (optionalComplaint.isPresent()) {
                    complaints = optionalComplaint.get();
                    saveComplaintMapping(complaintsDTO, complaints);
                    vehicleResponse.setStatus(HttpStatus.OK.value());
                    vehicleResponse.setMessage(messageService.getMessage("complaint.update"));
                } else {
                    vehicleResponse.setStatus(HttpStatus.NOT_FOUND.value());
                    vehicleResponse.setMessage(messageService.getMessage("complaint.not.found"));
                }
                return vehicleResponse;
            } else {
                complaints = new Complaints();
                saveComplaintMapping(complaintsDTO, complaints);
                vehicleResponse.setStatus(HttpStatus.OK.value());
                vehicleResponse.setPayLoad(complaints);
                vehicleResponse.setMessage(messageService.getMessage("complaint.save"));
                return vehicleResponse;
            }
        } else {
            vehicleResponse.setMessage(messageService.getMessage("invalid.data"));
            vehicleResponse.setStatus(HttpStatus.BAD_REQUEST.value());
            return vehicleResponse;
        }
    }

    @Override
    public VehicleResponse updateComplaint(ComplaintsDTO complaintsDTO) {

        VehicleResponse vehicleResponse = new VehicleResponse();
        if (complaintsDTO != null) {
            Complaints complaints;
            if (!StringUtils.isEmpty(complaintsDTO.getId()) && complaintsDTO.getId() > 0) {
                Optional<Complaints> optionalComplaint = complaintsRepository.findById(complaintsDTO.getId());
                if (optionalComplaint.isPresent()) {
                    complaints = optionalComplaint.get();
                    saveComplaintMapping(complaintsDTO, complaints);
                    vehicleResponse.setStatus(HttpStatus.OK.value());
                    vehicleResponse.setMessage(messageService.getMessage("complaint.update"));
                } else {
                    vehicleResponse.setStatus(HttpStatus.NOT_FOUND.value());
                    vehicleResponse.setMessage(messageService.getMessage("complaint.not.found"));
                }
                return vehicleResponse;
            }
            vehicleResponse.setMessage(messageService.getMessage("invalid.data"));
            vehicleResponse.setStatus(HttpStatus.BAD_REQUEST.value());
            return vehicleResponse;
        } else {
            vehicleResponse.setMessage(messageService.getMessage("invalid.data"));
            vehicleResponse.setStatus(HttpStatus.BAD_REQUEST.value());
            return vehicleResponse;
        }
    }

    @Override
    public VehicleResponse getAllComplaints() {

        List<Complaints> complaintsList = complaintsRepository.findAll();
        VehicleResponse vehicleResponse = new VehicleResponse();
        if (!StringUtils.isEmpty(complaintsList) && complaintsList.size() > 0) {
            List<ComplaintsDTO> complaintsDTOList = getComplaintsDTOList(complaintsList);
            vehicleResponse.setMessage(messageService.getMessage("success.message"));
            vehicleResponse.setStatus(HttpStatus.OK.value());
            vehicleResponse.setPayLoad(complaintsDTOList);
            return vehicleResponse;
        }
        vehicleResponse.setMessage(messageService.getMessage("complaint.no"));
        vehicleResponse.setStatus(HttpStatus.OK.value());
        return vehicleResponse;
    }

    private List<ComplaintsDTO> getComplaintsDTOList(List<Complaints> complaintsList) {
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
        return complaintsDTOList;
    }

    @Override
    public VehicleResponse deleteComplaint(Long complaintId) {
        VehicleResponse vehicleResponse = new VehicleResponse();
        if (complaintId > 0) {
            Optional<Complaints> optionalComplaint = complaintsRepository.findById(complaintId);
            if (optionalComplaint.isPresent()) {
                Complaints complaints = optionalComplaint.get();
                complaintsRepository.delete(complaints);
                vehicleResponse.setStatus(HttpStatus.OK.value());
                vehicleResponse.setMessage(messageService.getMessage("delete.success"));
            } else {
                vehicleResponse.setStatus(HttpStatus.NOT_FOUND.value());
                vehicleResponse.setMessage(messageService.getMessage("complaint.not.found"));
            }
        } else {
            vehicleResponse.setStatus(HttpStatus.BAD_REQUEST.value());
            vehicleResponse.setMessage(messageService.getMessage("invalid.data"));
        }
        return vehicleResponse;
    }

    @Override
    public VehicleResponse getAllComplaintById(Long complaintId) {
        VehicleResponse vehicleResponse = new VehicleResponse();
        if (complaintId > 0) {
            Optional<Complaints> optionalComplaint = complaintsRepository.findById(complaintId);
            if (optionalComplaint.isPresent()) {
                Complaints complaints = optionalComplaint.get();
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

                vehicleResponse.setStatus(HttpStatus.OK.value());
                vehicleResponse.setMessage(messageService.getMessage("success.message"));
                vehicleResponse.setPayLoad(complaintsDTO);
            } else {
                vehicleResponse.setStatus(HttpStatus.NOT_FOUND.value());
                vehicleResponse.setMessage(messageService.getMessage("complaint.not.found"));
            }
            return vehicleResponse;
        } else {
            vehicleResponse.setStatus(HttpStatus.BAD_REQUEST.value());
            vehicleResponse.setMessage(messageService.getMessage("invalid.data"));
            return vehicleResponse;
        }
    }

    @Override
    public VehicleResponse searchComplaintByDates(Timestamp fromTime, Timestamp toTime) {
        VehicleResponse vehicleResponse = new VehicleResponse();
        List<Complaints> complaintsList;
        if (toTime != null) {
            complaintsList = complaintsRepository.findByCreatedDateAfterAndCreatedDateBefore(fromTime, toTime);
        } else {
            complaintsList = complaintsRepository.findByCreatedDateAfter(fromTime);
        }
        if (!StringUtils.isEmpty(complaintsList) && complaintsList.size() > 0) {
            List<ComplaintsDTO> complaintsDTOList = getComplaintsDTOList(complaintsList);
            vehicleResponse.setMessage(messageService.getMessage("success.message"));
            vehicleResponse.setStatus(HttpStatus.OK.value());
            vehicleResponse.setPayLoad(complaintsDTOList);
            return vehicleResponse;
        } else {
            vehicleResponse.setMessage(messageService.getMessage("complaint.no"));
            vehicleResponse.setStatus(HttpStatus.BAD_REQUEST.value());
            return vehicleResponse;
        }
    }

    private Complaints saveComplaintMapping(ComplaintsDTO complaintsDTO, Complaints complaints) {

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
        return complaints;
    }
}
