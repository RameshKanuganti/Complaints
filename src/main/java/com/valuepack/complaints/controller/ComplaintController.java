package com.valuepack.complaints.controller;

import com.valuepack.complaints.dto.ComplaintsDTO;
import com.valuepack.complaints.exception.BadRequestException;
import com.valuepack.complaints.exception.InvalidInputException;
import com.valuepack.complaints.serviceI.ComplaintsServiceI;
import com.valuepack.complaints.util.VehicleResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
    public VehicleResponse updateComplaint(@RequestBody ComplaintsDTO complaintsDTO) throws Exception {
        return complaintsServiceI.updateComplaint(complaintsDTO);
    }

    @DeleteMapping("/complaints/{complaintId}")
    public VehicleResponse deleteComplaint(@PathVariable final Long complaintId) throws Exception {
        return complaintsServiceI.deleteComplaint(complaintId);
    }

    @GetMapping("/complaints/{complaintId}")
    public VehicleResponse getComplaintsById(@PathVariable final Long complaintId) throws Exception {
        return complaintsServiceI.getAllComplaintById(complaintId);
    }

    @GetMapping("/complaints/search")
    public VehicleResponse getComplaintsSearch(@RequestParam(value = "fromDate", required = true) String fromDate, @RequestParam(value = "toDate", required = false) String toDate) throws Exception {
        if (!StringUtils.isEmpty(fromDate)) {
            if (!StringUtils.isEmpty(toDate)) {
                try {
                    SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
                    Date date1 = formatter.parse(fromDate);
                    Timestamp fromTime = new Timestamp(date1.getTime());

                    Date date2 = formatter.parse(toDate);
                    Timestamp toTime = new Timestamp(date2.getTime());
                    if (fromTime.before(toTime)) {
                        return complaintsServiceI.searchComplaintByDates(fromTime, toTime);
                    } else if (fromTime.equals(toTime)) {
                        return complaintsServiceI.searchComplaintByDates(fromTime, null);
                    } else {
                        throw new BadRequestException("fromDate should be less than toDate");
                    }
                } catch (ParseException e) {
                    throw new BadRequestException("Timestamp should be in dd-MM-yyyy");
                }
            } else {
                try {
                    SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
                    java.util.Date date1 = formatter.parse(fromDate);
                    Timestamp fromTime = new Timestamp(date1.getTime());
                    return complaintsServiceI.searchComplaintByDates(fromTime, null);

                } catch (ParseException e) {
                    throw new BadRequestException("Timestamp should be in dd-MM-yyyy");
                }
            }

        } else {
            throw new InvalidInputException("Timestamp should not be null");
        }
    }
}
