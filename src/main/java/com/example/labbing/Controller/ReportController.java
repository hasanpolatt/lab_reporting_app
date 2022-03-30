package com.example.labbing.Controller;

import com.example.labbing.Model.Report;
import com.example.labbing.Service.ReportService;
import com.example.labbing.Repository.ReportRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/hospital")
public class ReportController {
    private final ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }


    @GetMapping("/listReports")
    public String listPatient(Model model) {
        List<Report> reports = reportService.findAllReports();
        model.addAttribute("reports", reports);
        return "index";
    }

    @GetMapping("/addnew")
    public String addPatient(Model model) {
        Report report = new Report();
        model.addAttribute("report", report);
        return "index";
    }

    @PostMapping("/add")
    public String addPatient(@ModelAttribute("report") Report report) {
        reportService.addReport(report);
        return "index";
    }



}
