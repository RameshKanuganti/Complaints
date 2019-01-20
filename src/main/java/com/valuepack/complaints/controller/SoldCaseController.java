package com.valuepack.complaints.controller;

import com.valuepack.complaints.dto.SoldCaseDTO;
import com.valuepack.complaints.serviceI.SoldCaseControllerI;
import com.valuepack.complaints.util.VehicleResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class SoldCaseController {

    @Autowired
    SoldCaseControllerI soldCaseControllerI;

    @GetMapping("/sold-case")
    public VehicleResponse getAllSoldCases() throws Exception {
        return soldCaseControllerI.getAllSoldCases();
    }

    @PostMapping("/sold-case")
    public VehicleResponse saveSoldCase(@RequestHeader("X-Authorization") final String xAuth, @RequestBody SoldCaseDTO soldCaseDTO) throws Exception {
        return soldCaseControllerI.saveSoldCase(soldCaseDTO);
    }

    @PutMapping("/sold-case")
    public VehicleResponse updateSoldCase(@RequestBody SoldCaseDTO soldCaseDTO) throws Exception {
        return soldCaseControllerI.updateSoldCase(soldCaseDTO);
    }

    @DeleteMapping("/sold-case/{soldCaseId}")
    public VehicleResponse deleteSoldCase(@PathVariable final Long soldCaseId) throws Exception {
        return soldCaseControllerI.deleteSoldCase(soldCaseId);
    }

}
