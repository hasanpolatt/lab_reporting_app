package com.example.labbing.Service;

import com.example.labbing.Model.Report;
import com.example.labbing.Model.SortBy;
import com.example.labbing.Repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReportService {
    private final ReportRepository reportRepository;

    @Autowired
    public ReportService(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    public Report addReport(Report report) {

        LocalDateTime localDateTime = LocalDateTime.now();
        Date date2 = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
        report.setReport_date(date2);
        return reportRepository.save(report);
    }

    public List<Report> findAllReports(SortBy sortBy) {
        switch (sortBy) {
            case ASC:
                return reportRepository.findAll().stream()
                        .sorted(Comparator.comparing(Report::getReport_date))
                        .collect(Collectors.toList());
            case DESC:
                List<Report> asd = reportRepository.findAll().stream()
                        .sorted(Comparator.comparing(Report::getReport_date))
                        .collect(Collectors.toList());
                Collections.reverse(asd);
                return asd;
            default:
                return reportRepository.findAll();
        }
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
