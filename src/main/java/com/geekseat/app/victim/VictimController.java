package com.geekseat.app.victim;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;


@RestController
@RequestMapping("/api/victims")
@Validated
public class VictimController {
    @Autowired
    private VictimService victimService;

    @GetMapping("/{year}")
    public ResponseEntity<Map<String, BigInteger>> calculateTotalVictim(@PathVariable @Valid @Min(value = 0, message = "year must >= 0") int year) {
        var body = new HashMap<String, BigInteger>();
        body.put("result", victimService.calculateTotalVictim(year));

        return ResponseEntity.status(HttpStatus.OK).body(body);
    }

    @PostMapping("/average")
    public ResponseEntity<Map<String, BigDecimal>> calculateAverageVictims(@Valid @NotEmpty(message = "request body must not be empty") @RequestBody List< Victim> victims) {
        var body = new HashMap<String, BigDecimal>();
        body.put("result", victimService.calculateAverageVictims(victims));

        return ResponseEntity.status(HttpStatus.OK).body(body);
    }

     


  
    
    
}
