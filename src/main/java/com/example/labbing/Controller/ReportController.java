package com.example.labbing.Controller;

import com.example.labbing.Model.Report;
import com.example.labbing.Model.SortBy;
import com.example.labbing.Service.ReportService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/hospital")
public class ReportController {
    private final ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }


    @GetMapping("/listReports/{sortBy}")
    public ModelAndView listReports(@PathVariable SortBy sortBy) {
        ModelAndView mav = new ModelAndView("index");
        List<Report> reports = reportService.findAllReports(sortBy);
        System.out.println(reports.toArray().length);
        mav.addObject("reports", reports);
        mav.addObject("report", new Report());
        return mav;
    }

    @PostMapping("/saveReport")
    public String saveReport(@ModelAttribute Report report) {
        reportService.addReport(report);
        return "redirect:../hospital/listReports/DESC";
    }

    @PutMapping("/updateReport")
    public String updateReport(@ModelAttribute Report report) {
        reportService.updateReport(report);
        return "redirect:../hospital/listReports/DESC";
    }

    @GetMapping("/report/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Report report = reportService.findReportById(id);
        model.addAttribute("report", report);
        return "modal";
    }

    @GetMapping("/deleteEmployee/{id}")
    public String deleteThroughId(@PathVariable long id) {
        reportService.deleteReport(id);
        return "redirect:../listReports";
    }

    @GetMapping("/reviewReport/{id}")
    public String reviewReport(@PathVariable("id") long id, Model model) {
        Report report = reportService.findReportById(id);
        model.addAttribute("report", report);
        return "review";
    }


}
