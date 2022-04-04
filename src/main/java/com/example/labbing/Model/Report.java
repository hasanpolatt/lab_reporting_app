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
    private String report_no;
    private String patient_name_surname;
    private String patient_tc_id;
    private String diagnosis_title;
    private String diagnosis_details;
    private Date report_date;
    @ManyToOne(fetch = FetchType.LAZY)
    private Laborant laborant;
}