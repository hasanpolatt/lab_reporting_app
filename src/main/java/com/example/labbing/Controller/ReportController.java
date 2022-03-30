package com.example.labbing.Controller;

import com.example.labbing.Model.Report;
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


    @GetMapping("/listReports")
    public ModelAndView listStudent(Model model) {
        ModelAndView mav = new ModelAndView("index");
        List<Report> reports = reportService.findAllReports();
        System.out.println(reports.toArray().length);
        mav.addObject("reports", reports);
        mav.addObject("report", new Report());
        return mav;
    }

    @PostMapping("/saveReport")
    public String saveReport(@ModelAttribute Report report) {
        reportService.addReport(report);
        return "redirect:../hospital/listReports";
    }

    @PutMapping("/updateReport")
    public String updateReport(@ModelAttribute Report report) {
        reportService.updateReport(report);
        return "redirect:../hospital/listReports";
    }

}
