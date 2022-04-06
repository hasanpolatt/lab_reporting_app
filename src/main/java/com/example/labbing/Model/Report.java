package com.example.labbing.Model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@Table(name = "Report")
public class Report implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String reportNo;
    private String patientName;
    private String patientTC;
    private String diagnosis;
    private String diagnosisDetails;
    private Date reportDate;
    @ManyToOne(fetch = FetchType.LAZY)
    private Laborant laborant;
    private String photos;
}