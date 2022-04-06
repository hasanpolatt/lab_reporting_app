package com.example.labbing;

import com.example.labbing.Model.Report;
import com.example.labbing.Repository.LaborantRepository;
import com.example.labbing.Repository.ReportRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Date;

@SpringBootApplication
public class LabbingApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(LabbingApplication.class, args);

        LaborantRepository l_repo = configurableApplicationContext.getBean(LaborantRepository.class);
        ReportRepository r_repo = configurableApplicationContext.getBean(ReportRepository.class);

        Report report = new Report();
        report.setReportDate(new Date());
        report.setPatientTC("12345678901");
        report.setPatientName("Ali Ayşe");
        report.setReportNo("1234567");
        report.setDiagnosis("Cold");
        report.setDiagnosisDetails("Had a cold");
        r_repo.save(report);

        report = new Report();
        report.setReportDate(new Date());
        report.setPatientTC("12345678902");
        report.setPatientName("James Bond");
        report.setReportNo("2345678");
        report.setDiagnosis("Covid-19");
        report.setDiagnosisDetails("Covid-19 is over");
        r_repo.save(report);
    }
}
