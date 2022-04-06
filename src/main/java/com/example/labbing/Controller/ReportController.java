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

    @GetMapping("/updateReport/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Report report = reportService.findReportById(id);
        model.addAttribute("report", report);
        return "modal";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable long id) {
        reportService.deleteReport(id);
        return "redirect:../listReports/DESC";
    }

    @GetMapping("/reviewReport/{id}")
    public String reviewReport(@PathVariable("id") long id, Model model) {
        Report report = reportService.findReportById(id);
        model.addAttribute("report", report);
        return "review";
    }
}
