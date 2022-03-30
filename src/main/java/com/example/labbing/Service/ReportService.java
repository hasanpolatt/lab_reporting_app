package com.example.labbing.Service;

import com.example.labbing.Exception.PatientNotFoundException;
import com.example.labbing.Model.Report;
import com.example.labbing.Repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportService {
    private final ReportRepository reportRepository;
    @Autowired
    public ReportService(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    public Report addReport(Report report) {
        return reportRepository.save(report);
    }

    public List<Report> findAllReports(){
        return reportRepository.findAll();
    }

    public Report updateReport(Report report){
        return reportRepository.save(report);
    }

    //
    public void deleteReport(Long id){
        reportRepository.deleteById(id);
    }




}