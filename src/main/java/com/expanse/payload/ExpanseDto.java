package com.expanse.payload;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ExpanseDto {

    private double travelExpanse;
    private double foodExpanse;

    private double otherExpanse;

    private String fileName;

}
