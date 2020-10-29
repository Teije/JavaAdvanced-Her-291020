package nl.inholland.tentamen.teijevanhemert.controller;

import lombok.extern.java.Log;
import nl.inholland.tentamen.teijevanhemert.model.Concert;
import nl.inholland.tentamen.teijevanhemert.service.ConcertService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
}
