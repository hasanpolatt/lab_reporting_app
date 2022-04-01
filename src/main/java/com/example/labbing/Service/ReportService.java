package com.example.labbing.Service;

import com.example.labbing.Model.Report;
import com.example.labbing.Repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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

    public List<Report> findAllReports() {
        return reportRepository.findAll();
    }

    public Report updateReport(Report report) {
        return reportRepository.save(report);
    }

    public void deleteReport(Long id) {
        if (reportRepository.existsById(id))
            reportRepository.deleteById(id);
        else
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "hospital not found by id" + id);
    }

    public Report findReportById(Long id) {
        Report report = reportRepository.findById(id).get();
        return report;
    }


}
