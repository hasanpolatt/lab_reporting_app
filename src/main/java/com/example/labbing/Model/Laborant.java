package com.example.labbing.Model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@Table(name = "Laborant")
public class Laborant implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String surname;
    private String hospital_id;
    @OneToMany(mappedBy = "laborant")
    private List<Report> reports;
}