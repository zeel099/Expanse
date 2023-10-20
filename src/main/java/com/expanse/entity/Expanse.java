package com.expanse.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name="expanse")
public class Expanse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private double travelExpanse;
    private double foodExpanse;
    private double otherExpanse;

    private String fileName;
}
