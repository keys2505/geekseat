package com.geekseat.app.victim;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Victim {
    @Min(value = 0, message = "ageAtDeath must >= 0" )
    private int ageAtDeath;

    private int yearOfDeath;

    @JsonIgnore
    public int getYearOfBirth() {
        return yearOfDeath - ageAtDeath  ;
    }


}
