package com.valuepack.complaints.serviceImpl;

import com.valuepack.complaints.component.Messages;
import com.valuepack.complaints.dto.DocumentsDTO;
import com.valuepack.complaints.dto.SoldCaseDTO;
import com.valuepack.complaints.model.Documents;
import com.valuepack.complaints.model.SoldCase;
import com.valuepack.complaints.repo.SoldCaseRepository;
import com.valuepack.complaints.serviceI.SoldCaseControllerI;
import com.valuepack.complaints.util.VehicleResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SoldCaseControllerImpl implements SoldCaseControllerI {

    @Autowired
    SoldCaseRepository soldCaseRepository;

    @Autowired
    Messages messageService;

    @Override
    public VehicleResponse getAllSoldCases() {
        VehicleResponse vehicleResponse = new VehicleResponse();
        List<SoldCase> soldCaseList = soldCaseRepository.findAll();
        if (!StringUtils.isEmpty(soldCaseList) && soldCaseList.size() > 0) {
            List<SoldCaseDTO> soldCaseDTOList = getSoldCaseDTOList(soldCaseList);
            vehicleResponse.setMessage(messageService.getMessage("success.message"));
            vehicleResponse.setStatus(HttpStatus.OK.value());
            vehicleResponse.setPayLoad(soldCaseDTOList);
            return vehicleResponse;
        } else {
            vehicleResponse.setMessage(messageService.getMessage("sold-case.no"));
            vehicleResponse.setStatus(HttpStatus.OK.value());
            return vehicleResponse;
        }
    }

    @Override
    public VehicleResponse saveSoldCase(SoldCaseDTO soldCaseDTO) {
        VehicleResponse vehicleResponse = new VehicleResponse();
        if (soldCaseDTO != null) {
            SoldCase soldCase;
            if (!StringUtils.isEmpty(soldCaseDTO.getId()) && soldCaseDTO.getId() > 0) {
                Optional<SoldCase> optionalComplaint = soldCaseRepository.findById(soldCaseDTO.getId());
                if (optionalComplaint.isPresent()) {
                    soldCase = optionalComplaint.get();
                    soldCaseDTOtoEntityMapping(soldCaseDTO, soldCase);
                    vehicleResponse.setStatus(HttpStatus.OK.value());
                    vehicleResponse.setMessage(messageService.getMessage("sold-case.update"));
                } else {
                    vehicleResponse.setStatus(HttpStatus.NOT_FOUND.value());
                    vehicleResponse.setMessage(messageService.getMessage("sold-case.not.found"));
                }
                return vehicleResponse;
            } else {
                soldCase = new SoldCase();
                soldCaseDTOtoEntityMapping(soldCaseDTO, soldCase);
                vehicleResponse.setStatus(HttpStatus.OK.value());
                vehicleResponse.setMessage(messageService.getMessage("sold-case.save"));
                return vehicleResponse;
            }
        } else {
            vehicleResponse.setMessage(messageService.getMessage("invalid.data"));
            vehicleResponse.setStatus(HttpStatus.BAD_REQUEST.value());
            return vehicleResponse;
        }
    }

    private SoldCase soldCaseDTOtoEntityMapping(SoldCaseDTO soldCaseDTO, SoldCase soldCase) {

        if (!StringUtils.isEmpty(soldCaseDTO.getVehicleNo().replaceAll(" ", ""))) {
            soldCase.setVehicleNo(soldCaseDTO.getVehicleNo());
        }
        if (!StringUtils.isEmpty(soldCaseDTO.getModelNo())) {
            soldCase.setModelNo(soldCaseDTO.getModelNo());
        }
        if (!StringUtils.isEmpty(soldCaseDTO.getEstimatedSalePrice())) {
            soldCase.setEstimatedSalePrice(soldCaseDTO.getEstimatedSalePrice());
        }
        if (!StringUtils.isEmpty(soldCaseDTO.getCustomerSignature())) {
            soldCase.setCustomerSignature(soldCaseDTO.getCustomerSignature());
        }
        if (!StringUtils.isEmpty(soldCaseDTO.getLeadId())) {
            soldCase.setLeadId(soldCaseDTO.getLeadId());
        }
        if (!StringUtils.isEmpty(soldCaseDTO.getSoldDate())) {
            soldCase.setSoldDate(soldCaseDTO.getSoldDate());
        }

        if (!StringUtils.isEmpty(soldCaseDTO.getDocuments()) && soldCaseDTO.getDocuments().size() > 0) {
            List<Documents> documentsList = new ArrayList<>();
            for (DocumentsDTO documentsDTO : soldCaseDTO.getDocuments()) {
                Documents documents = new Documents();
                if (!StringUtils.isEmpty(documentsDTO.getDocumentImageUrl())) {
                    documents.setDocumentImageUrl(documentsDTO.getDocumentImageUrl());
                }
                if (!StringUtils.isEmpty(documentsDTO.getDocumentName())) {
                    documents.setDocumentName(documentsDTO.getDocumentName());
                }
                documentsList.add(documents);
            }
            soldCase.setDocuments(documentsList);
        }
        soldCase = soldCaseRepository.save(soldCase);
        return soldCase;
    }

    @Override
    public VehicleResponse updateSoldCase(SoldCaseDTO soldCaseDTO) {
        VehicleResponse vehicleResponse = new VehicleResponse();
        if (soldCaseDTO != null) {
            SoldCase soldCase;
            if (!StringUtils.isEmpty(soldCaseDTO.getId()) && soldCaseDTO.getId() > 0) {
                Optional<SoldCase> optionalComplaint = soldCaseRepository.findById(soldCaseDTO.getId());
                if (optionalComplaint.isPresent()) {
                    soldCase = optionalComplaint.get();
                    soldCaseDTOtoEntityMapping(soldCaseDTO, soldCase);
                    vehicleResponse.setStatus(HttpStatus.OK.value());
                    vehicleResponse.setMessage(messageService.getMessage("sold-case.update"));
                } else {
                    vehicleResponse.setStatus(HttpStatus.NOT_FOUND.value());
                    vehicleResponse.setMessage(messageService.getMessage("sold-case.not.found"));
                }
                return vehicleResponse;
            } else {
                vehicleResponse.setMessage(messageService.getMessage("invalid.data"));
                vehicleResponse.setStatus(HttpStatus.BAD_REQUEST.value());
                return vehicleResponse;
            }
        } else {
            vehicleResponse.setMessage(messageService.getMessage("invalid.data"));
            vehicleResponse.setStatus(HttpStatus.BAD_REQUEST.value());
            return vehicleResponse;
        }
    }

    @Override
    public VehicleResponse deleteSoldCase(Long soldCaseId) {
        VehicleResponse vehicleResponse = new VehicleResponse();
        if (soldCaseId > 0) {
            Optional<SoldCase> optionalComplaint = soldCaseRepository.findById(soldCaseId);
            if (optionalComplaint.isPresent()) {
                SoldCase soldCase = optionalComplaint.get();
                soldCaseRepository.delete(soldCase);
                vehicleResponse.setStatus(HttpStatus.OK.value());
                vehicleResponse.setMessage(messageService.getMessage("delete.success"));
            } else {
                vehicleResponse.setStatus(HttpStatus.NOT_FOUND.value());
                vehicleResponse.setMessage(messageService.getMessage("sold-case.not.found"));
            }
        } else {
            vehicleResponse.setStatus(HttpStatus.BAD_REQUEST.value());
            vehicleResponse.setMessage(messageService.getMessage("invalid.data"));
        }
        return vehicleResponse;
    }

    private List<SoldCaseDTO> getSoldCaseDTOList(List<SoldCase> soldCaseList) {
        List<SoldCaseDTO> soldCaseDTOList = new ArrayList<>();
        for (SoldCase soldCase : soldCaseList) {
            SoldCaseDTO soldCaseDTO = new SoldCaseDTO();
            soldCaseDTO.setId(soldCase.getId());
            soldCaseDTO.setVehicleNo(soldCase.getVehicleNo());
            soldCaseDTO.setModelNo(soldCase.getModelNo());
            soldCaseDTO.setEstimatedSalePrice(soldCase.getEstimatedSalePrice());
            soldCaseDTO.setCustomerSignature(soldCase.getCustomerSignature());
            soldCaseDTO.setLeadId(soldCase.getLeadId());
            soldCaseDTO.setSoldDate(soldCase.getSoldDate());
            if (soldCase.getDocuments() != null && soldCase.getDocuments().size() > 0) {
                List<DocumentsDTO> documentsDTOList = new ArrayList<>();
                for (Documents documents : soldCase.getDocuments()) {
                    DocumentsDTO documentsDTO = new DocumentsDTO();
                    documentsDTO.setId(documents.getId());
                    documentsDTO.setDocumentName(documents.getDocumentName());
                    documentsDTO.setDocumentImageUrl(documents.getDocumentImageUrl());
                    documentsDTOList.add(documentsDTO);
                }
                soldCaseDTO.setDocuments(documentsDTOList);
            }
            soldCaseDTOList.add(soldCaseDTO);
        }
        return soldCaseDTOList;
    }
}
