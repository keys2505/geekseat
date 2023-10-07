package com.geekseat.app.victim;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geekseat.app.helper.Fibonacci;

@Service
public class VictimService {

    @Autowired
    Fibonacci fibonacci;

    Map<Long, BigInteger> victimMap = new LinkedHashMap<>();

    public BigInteger calculateTotalVictim(long year) {
        if(victimMap.containsKey(year))
           return victimMap.get(year);

        BigInteger totalVictim = BigInteger.ZERO;

		for (long i = 0; i <= year; i++) {
            totalVictim = totalVictim.add(fibonacci.getFibonacci(i));
            victimMap.put(i, totalVictim);
        }

        return totalVictim;
    }

    public BigDecimal calculateAverageVictims(List<Victim> victims) {
        if(victims.isEmpty()){
            return BigDecimal.ZERO;
        }

        BigDecimal victimSize= new BigDecimal(victims.size());
        BigInteger totalVictim = BigInteger.ZERO;
        
        for (Victim victim : victims) {
            totalVictim = totalVictim.add(calculateTotalVictim(victim.getYearOfBirth()));
        }
    
        return  new BigDecimal(totalVictim).divide(victimSize);
    }

    

    
	
}
