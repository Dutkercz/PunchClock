package dev_java._5.punch_clock.controllers;

import dev_java._5.punch_clock.repositories.PunchClockRespository;
import dev_java._5.punch_clock.service.PunchClockService;
import dev_java._5.punch_clock.entities.PunchClockDTO;
import dev_java._5.punch_clock.entities.PunchClockListing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/punch-clock")
public class PunchClockController {
    @Autowired
    private PunchClockRespository respository;
    @Autowired
    private PunchClockService service;

    @PostMapping()
    public ResponseEntity<PunchClockListing> punchClock(@RequestBody PunchClockDTO data,
                                                        UriComponentsBuilder builder){
        var punchClock = service.saveRegister(data);
        var uri = builder.path("/punch-clock/{id}").buildAndExpand(punchClock.getId()).toUri();
        return ResponseEntity.created(uri).body(new PunchClockListing(data));
    }
}
