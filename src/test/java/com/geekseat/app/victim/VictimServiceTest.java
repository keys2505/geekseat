package com.geekseat.app.victim;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class VictimServiceTest {
    @Autowired
    VictimService victimService;

    @Test
    public void testCalculateTotalVictimForZeroYear() {
        BigInteger result = victimService.calculateTotalVictim(0);
        assertEquals(BigInteger.ZERO, result);
    }

    @Test
    public void testCalculateTotalVictimForOneYear() {
        BigInteger result = victimService.calculateTotalVictim(1);
        assertEquals(BigInteger.ONE, result);
    }

    @Test
    public void testCalculateTotalVictimForSomeYear() {
        BigInteger result = victimService.calculateTotalVictim(5);
        assertEquals(BigInteger.valueOf(12), result);
        // Total victims for year 5 should be 0 + 1 + 1 + 2 + 3 + 5 = 12
    }

     @Test
    public void testCalculateAverageVictimsWithEmptyList() {
        List<Victim> victims = new ArrayList<>();
        BigDecimal result = victimService.calculateAverageVictims(victims);
        assertEquals(BigDecimal.ZERO, result);
    }

    @Test
    public void testCalculateAverageVictimsWithSingleVictim() {
        List<Victim> victims = new ArrayList<>();
        victims.add(new Victim(13, 17));

        BigDecimal result = victimService.calculateAverageVictims(victims);
        assertEquals(BigDecimal.valueOf(7), result);
    }

    @Test
    public void testCalculateAverageVictimsWithMultipleVictims() {
        List<Victim> victims = new ArrayList<>();
        victims.add(new Victim(10,12));
        victims.add(new Victim(13,17));

        BigDecimal result = victimService.calculateAverageVictims(victims);
        assertEquals(BigDecimal.valueOf(4.5), result);
    }
   
}
