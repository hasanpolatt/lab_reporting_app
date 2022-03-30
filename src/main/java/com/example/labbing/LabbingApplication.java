package com.example.labbing;

import com.example.labbing.Model.Laborant;
import com.example.labbing.Model.Report;
import com.example.labbing.Repository.LaborantRepository;
import com.example.labbing.Repository.ReportRepository;
import org.springframework.boot.ConfigurableBootstrapContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class LabbingApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(LabbingApplication.class, args);

		LaborantRepository l_repo = configurableApplicationContext.getBean(LaborantRepository.class);
		ReportRepository r_repo = configurableApplicationContext.getBean(ReportRepository.class);

		Report report = new Report();
		report.setReport_date(new Date());
		report.setPatient_name_surname("Ali Ayşe");
		report.setReport_no("1234567");
		report.setDiagnosis_title("Cold");
		report.setDiagnosis_details("Had a cold");
		r_repo.save(report);

		report = new Report();
		report.setReport_date(new Date());
		report.setPatient_name_surname("James Bond");
		report.setReport_no("2345678");
		report.setDiagnosis_title("Covid-19");
		report.setDiagnosis_details("Covid-19 is over");
		r_repo.save(report);



	}

}
