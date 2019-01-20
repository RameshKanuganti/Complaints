package com.valuepack.complaints.controller;

import com.valuepack.complaints.dto.RCTransferDTO;
import com.valuepack.complaints.serviceI.RCTransferServiceI;
import com.valuepack.complaints.util.VehicleResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class RCTransferController {

    @Autowired
    RCTransferServiceI rcTransferServiceI;

    @GetMapping("/rc-transfer")
    public VehicleResponse getAllRCTransfer() throws Exception {
        return rcTransferServiceI.getAllRCTransfer();
    }

    @GetMapping("/rc-transfer/{rcId}")
    public VehicleResponse getRCTransferById(@PathVariable final  Long rcId) throws Exception {
        return rcTransferServiceI.getRCTransferById(rcId);
    }

    @PostMapping("/rc-transfer")
    public VehicleResponse saveRCTransfer(@RequestHeader("X-Authorization") final String xAuth, @RequestBody RCTransferDTO rcTransferDTO) throws Exception {
        return rcTransferServiceI.saveRCTransfer(rcTransferDTO);
    }

    @PutMapping("/rc-transfer")
    public VehicleResponse updateRCTransfer(@RequestHeader("X-Authorization") final String xAuth, @RequestBody RCTransferDTO rcTransferDTO) throws Exception {
        return rcTransferServiceI.updateRCTransfer(rcTransferDTO);
    }

    @DeleteMapping("/rc-transfer/{rcId}")
    public VehicleResponse deleteRCTransfer(@PathVariable final Long rcId) throws Exception {
        return rcTransferServiceI.deleteRCTransferById(rcId);
    }


}
