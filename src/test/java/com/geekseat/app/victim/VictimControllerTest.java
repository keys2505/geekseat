package com.geekseat.app.victim;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class VictimControllerTest {
   
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;


    @Test
    public void testCalculateTotalVictim() {
        int year = 5;
        ResponseEntity<Map> responseEntity = restTemplate.getForEntity("/api/victims/" + year, Map.class);
        Map<String, Integer> responseBody = responseEntity.getBody();

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(12, responseBody.get("result"));
    }

    @Test
    public void testCalculateTotalVictimWithNegativeYear() {
        int year = -5;
        ResponseEntity<Map> responseEntity = restTemplate.getForEntity("/api/victims/" + year, Map.class);
        Map<String, Integer> responseBody = responseEntity.getBody();
        
        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        assertEquals(-1, responseBody.get("result"));
    }

    @Test
    public void testCalculateAverageVictims() {
        List<Victim> victims = new ArrayList<>();
        victims.add(new Victim(10,12));
        victims.add(new Victim(13,17));

        ResponseEntity<Map> responseEntity = restTemplate.postForEntity("/api/victims/average", victims, Map.class);
        Map<String, Double> responseBody = responseEntity.getBody();

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(Double.parseDouble("4.5"), responseBody.get("result"));
    }

    @Test
    public void testCalculateAverageVictimsWithNegativeAge() {
        List<Victim> victims = new ArrayList<>();
        victims.add(new Victim(-10,12));
        victims.add(new Victim(-13,17));

        ResponseEntity<Map> responseEntity = restTemplate.postForEntity("/api/victims/average", victims, Map.class);
        Map<String, Integer> responseBody = responseEntity.getBody();

        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        assertEquals(-1, responseBody.get("result"));
    }

    @Test
    public void testCalculateAverageVictimsWithEmptyList() {
        List<Victim> victims = new ArrayList<>();

        ResponseEntity<Map> responseEntity = restTemplate.postForEntity("/api/victims/average", victims, Map.class);
        Map<String, Integer> responseBody = responseEntity.getBody();

        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        assertEquals(-1, responseBody.get("result"));
    }
}
