package nl.inholland.tentamen.teijevanhemert.controller;

import lombok.extern.java.Log;
import nl.inholland.tentamen.teijevanhemert.dto.CapacityDTO;
import nl.inholland.tentamen.teijevanhemert.service.VenueService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Log
@Controller
@RequestMapping(value = "/venues")
public class VenueController
{
    private VenueService venueService;

    public VenueController(VenueService venueService)
    {
        this.venueService = venueService;
    }

    @RequestMapping(
            value = "/capacity",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CapacityDTO> GetCapacity()
    {
        CapacityDTO total = new CapacityDTO(venueService.GetCapacity());
        log.info("--- Exam Question 6b completed ---");

        return ResponseEntity
                .status(200)
                .body(total);
    }
}
