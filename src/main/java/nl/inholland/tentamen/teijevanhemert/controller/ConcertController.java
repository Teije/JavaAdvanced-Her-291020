package nl.inholland.tentamen.teijevanhemert.controller;

import lombok.extern.java.Log;
import nl.inholland.tentamen.teijevanhemert.GenericErrorResponseDTO;
import nl.inholland.tentamen.teijevanhemert.model.Concert;
import nl.inholland.tentamen.teijevanhemert.service.ConcertService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Log
@Controller
@RequestMapping(value = "/concerts")
public class ConcertController
{
    private ConcertService concertService;

    public ConcertController(ConcertService concertService)
    {
        this.concertService = concertService;
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity GetDriverById(@PathVariable long id)
    {
        Concert concert = concertService.GetConcertById(id);
        log.info("--- Exam Question 5a completed ---");

        return ResponseEntity
                .status(200)
                .body(concert);
    }

    @RequestMapping(
            value = "",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE,
            params = {"country"})
    public ResponseEntity GetConcertsByCountry(@RequestParam String country) {
        try
        {
            List<Concert> concerts = concertService.GetConcertsByCountry(country);
            log.info("--- Exam Question 5b completed ---");

            return ResponseEntity
                    .status(200)
                    .body(concerts);
        }
        catch (Exception exception)
        {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(new GenericErrorResponseDTO(400, exception.getMessage()));
        }
    }
}
