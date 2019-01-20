package com.valuepack.complaints.serviceImpl;

import com.valuepack.complaints.component.Messages;
import com.valuepack.complaints.dto.RCTransferDTO;
import com.valuepack.complaints.model.RCTransfer;
import com.valuepack.complaints.repo.RCTransferRepository;
import com.valuepack.complaints.serviceI.RCTransferServiceI;
import com.valuepack.complaints.util.VehicleResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RCTransferServiceImpl implements RCTransferServiceI {

    @Autowired
    private RCTransferRepository rcTransferRepository;

    @Autowired
    private Messages messageService;

    @Override
    public VehicleResponse saveRCTransfer(RCTransferDTO rcTransferDTO) {
        VehicleResponse vehicleResponse = new VehicleResponse();
        if (rcTransferDTO != null) {
            RCTransfer rcTransfer;
            if (!StringUtils.isEmpty(rcTransferDTO.getId()) && rcTransferDTO.getId() > 0) {
                Optional<RCTransfer> optionalRCTransfer = rcTransferRepository.findById(rcTransferDTO.getId());
                if (optionalRCTransfer.isPresent()) {
                    rcTransfer = optionalRCTransfer.get();
                    saveRCTransferMapping(rcTransferDTO, rcTransfer);
                    vehicleResponse.setStatus(HttpStatus.OK.value());
                    vehicleResponse.setMessage(messageService.getMessage("rc.update"));
                } else {
                    vehicleResponse.setStatus(HttpStatus.NOT_FOUND.value());
                    vehicleResponse.setMessage(messageService.getMessage("rc.not.found"));
                }
                return vehicleResponse;
            } else {
                rcTransfer = new RCTransfer();
                saveRCTransferMapping(rcTransferDTO, rcTransfer);
                vehicleResponse.setStatus(HttpStatus.OK.value());
                vehicleResponse.setMessage(messageService.getMessage("rc.save"));
                return vehicleResponse;
            }

        } else {
            vehicleResponse.setMessage(messageService.getMessage("invalid.data"));
            vehicleResponse.setStatus(HttpStatus.BAD_REQUEST.value());
            return vehicleResponse;
        }
    }

    @Override
    public VehicleResponse getAllRCTransfer() {

        List<RCTransfer> rcTransferList = rcTransferRepository.findAll();
        VehicleResponse vehicleResponse = new VehicleResponse();
        if (!StringUtils.isEmpty(rcTransferList) && rcTransferList.size() > 0) {
            List<RCTransferDTO> rcTransferDTOList = new ArrayList<>();
            for (RCTransfer rcTransfer : rcTransferList) {
                RCTransferDTO rcTransferDTO = new RCTransferDTO();
                rcTransferDTO.setId(rcTransfer.getId());
                rcTransferDTO.setVehicleNumber(rcTransfer.getVehicleNumber());
                rcTransferDTO.setDateOfSale(rcTransfer.getDateOfSale());
                rcTransferDTO.setHypothecationNOCRecorded(rcTransfer.getHypothecationNOCRecorded());
                rcTransferDTO.setHypothecationNOCDateRecorded(rcTransfer.getHypothecationNOCDateRecorded());
                rcTransferDTO.setDocumentSubmittedToRTC(rcTransfer.getDocumentSubmittedToRTC());
                rcTransferDTO.setDocumentSubmittedToRTCDate(rcTransfer.getDocumentSubmittedToRTCDate());
                rcTransferDTO.setNewRCIssued(rcTransfer.getNewRCIssued());
                rcTransferDTO.setNewRCIssuedDate(rcTransfer.getNewRCIssuedDate());
                rcTransferDTO.setUploadNewRCCopy(rcTransfer.getUploadNewRCCopy());
                rcTransferDTOList.add(rcTransferDTO);
            }
            vehicleResponse.setMessage(messageService.getMessage("success.message"));
            vehicleResponse.setStatus(HttpStatus.OK.value());
            vehicleResponse.setPayLoad(rcTransferDTOList);
            return vehicleResponse;

        } else {
            vehicleResponse.setMessage(messageService.getMessage("rc.no"));
            vehicleResponse.setStatus(HttpStatus.OK.value());
            return vehicleResponse;
        }
    }

    @Override
    public VehicleResponse updateRCTransfer(RCTransferDTO rcTransferDTO) {
        VehicleResponse vehicleResponse = new VehicleResponse();
        if (rcTransferDTO != null) {
            RCTransfer rcTransfer;
            if (!StringUtils.isEmpty(rcTransferDTO.getId()) && rcTransferDTO.getId() > 0) {
                Optional<RCTransfer> optionalRCTransfer = rcTransferRepository.findById(rcTransferDTO.getId());
                if (optionalRCTransfer.isPresent()) {
                    rcTransfer = optionalRCTransfer.get();
                    saveRCTransferMapping(rcTransferDTO, rcTransfer);
                    vehicleResponse.setStatus(HttpStatus.OK.value());
                    vehicleResponse.setMessage(messageService.getMessage("rc.update"));
                } else {
                    vehicleResponse.setStatus(HttpStatus.NOT_FOUND.value());
                    vehicleResponse.setMessage(messageService.getMessage("rc.not.found"));
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
    public VehicleResponse deleteRCTransferById(Long rcId) {
        VehicleResponse vehicleResponse = new VehicleResponse();
        if (rcId > 0) {
            Optional<RCTransfer> optionalRCTransfer = rcTransferRepository.findById(rcId);
            if (optionalRCTransfer.isPresent()) {
                RCTransfer rcTransfer = optionalRCTransfer.get();
                rcTransferRepository.delete(rcTransfer);
                vehicleResponse.setStatus(HttpStatus.OK.value());
                vehicleResponse.setMessage(messageService.getMessage("delete.success"));
            } else {
                vehicleResponse.setStatus(HttpStatus.NOT_FOUND.value());
                vehicleResponse.setMessage(messageService.getMessage("rc.not.found"));
            }
        } else {
            vehicleResponse.setStatus(HttpStatus.BAD_REQUEST.value());
            vehicleResponse.setMessage(messageService.getMessage("invalid.data"));
        }
        return vehicleResponse;
    }

    @Override
    public VehicleResponse getRCTransferById(Long rcId) {
        VehicleResponse vehicleResponse = new VehicleResponse();
        if (!StringUtils.isEmpty(rcId) && rcId > 0) {
            Optional<RCTransfer> optionalRCTransfer = rcTransferRepository.findById(rcId);
            if (optionalRCTransfer.isPresent()) {
                RCTransfer rcTransfer = optionalRCTransfer.get();
                RCTransferDTO rcTransferDTO = new RCTransferDTO();
                rcTransferDTO.setId(rcTransfer.getId());
                rcTransferDTO.setVehicleNumber(rcTransfer.getVehicleNumber());
                rcTransferDTO.setDateOfSale(rcTransfer.getDateOfSale());
                rcTransferDTO.setHypothecationNOCRecorded(rcTransfer.getHypothecationNOCRecorded());
                rcTransferDTO.setHypothecationNOCDateRecorded(rcTransfer.getHypothecationNOCDateRecorded());
                rcTransferDTO.setDocumentSubmittedToRTC(rcTransfer.getDocumentSubmittedToRTC());
                rcTransferDTO.setDocumentSubmittedToRTCDate(rcTransfer.getDocumentSubmittedToRTCDate());
                rcTransferDTO.setNewRCIssued(rcTransfer.getNewRCIssued());
                rcTransferDTO.setNewRCIssuedDate(rcTransfer.getNewRCIssuedDate());
                rcTransferDTO.setUploadNewRCCopy(rcTransfer.getUploadNewRCCopy());

                vehicleResponse.setStatus(HttpStatus.OK.value());
                vehicleResponse.setMessage(messageService.getMessage("success.message"));
            } else {
                vehicleResponse.setStatus(HttpStatus.NOT_FOUND.value());
                vehicleResponse.setMessage(messageService.getMessage("rc.not.found"));
            }
            return vehicleResponse;
        }
        vehicleResponse.setMessage(messageService.getMessage("invalid.data"));
        vehicleResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        return vehicleResponse;
    }

    private RCTransfer saveRCTransferMapping(RCTransferDTO rcTransferDTO, RCTransfer rcTransfer) {
        if (!StringUtils.isEmpty(rcTransferDTO.getVehicleNumber())) {
            rcTransfer.setVehicleNumber(rcTransferDTO.getVehicleNumber());
        }
        if (!StringUtils.isEmpty(rcTransferDTO.getDateOfSale())) {
            rcTransfer.setDateOfSale(rcTransferDTO.getDateOfSale());
        }
        if (!StringUtils.isEmpty(rcTransferDTO.getHypothecationNOCDateRecorded())) {
            rcTransfer.setHypothecationNOCDateRecorded(rcTransferDTO.getHypothecationNOCDateRecorded());
        }
        if (!StringUtils.isEmpty(rcTransferDTO.getDocumentSubmittedToRTCDate())) {
            rcTransfer.setDocumentSubmittedToRTCDate(rcTransferDTO.getDocumentSubmittedToRTCDate());
        }
        if (!StringUtils.isEmpty(rcTransferDTO.getNewRCIssuedDate())) {
            rcTransfer.setNewRCIssuedDate(rcTransferDTO.getNewRCIssuedDate());
        }
        if (!StringUtils.isEmpty(rcTransferDTO.getUploadNewRCCopy())) {
            rcTransfer.setUploadNewRCCopy(rcTransferDTO.getUploadNewRCCopy());
        }
        rcTransfer = rcTransferRepository.save(rcTransfer);
        return rcTransfer;
    }
}
