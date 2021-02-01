package com.vic.report.controller;

import com.github.pagehelper.Page;
import com.vic.report.model.Report;
import com.vic.report.model.ReportDaoEntity;
import com.vic.report.model.ResponseResult;
import com.vic.report.service.ReportService;
import com.vic.report.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.SQLException;

/**
 * @author Vic
 */
@RestController
public class ReportController {
    @Autowired
    ReportService reportService;

    @Autowired
    UserService userService;
    @PostMapping("/reports")
    public ResponseResult upload(@RequestHeader String token,@RequestParam("report")MultipartFile report,Report reportDetail){
        if (!userService.checkToken(token)){
            return ResponseResult.failString("没有权限");
        }

        try {
            reportDetail.setReportBlob(report);
            reportService.insertReport(reportDetail);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseResult.failString("上传异常");
        }
        return ResponseResult.successString("");
    }

    @GetMapping("/reports/{idCard}")
    public ResponseResult getReport(@PathVariable String idCard) {
        ReportDaoEntity report = reportService.getReport(idCard);
        if (report == null) {
            return ResponseResult.failString("您的报告还未上传哦");
        }

        return ResponseResult.successObject(report);
    }

    @GetMapping("/reports")
    public ResponseResult list(@RequestHeader String token,
            @RequestParam(required = false,defaultValue = "") String userName,
                               @RequestParam(required = false,defaultValue = "") String idCard,
                               @RequestParam(required = false,defaultValue = "1") int page,
                               @RequestParam(required = false,defaultValue = "10") int pageSize
                               ){
        if (!userService.checkToken(token)){
            return ResponseResult.failString("没有权限");
        }
        Page<ReportDaoEntity> reportDaoEntities = reportService.listReports(userName,idCard, page, pageSize);
        return ResponseResult.successList(reportDaoEntities.getResult(), reportDaoEntities.getTotal());
    }

    @DeleteMapping("/reports/{idCard}")
    public ResponseResult remove(@RequestHeader String token,@PathVariable String idCard) {
        if (!userService.checkToken(token)){
            return ResponseResult.failString("没有权限");
        }
        boolean remove = reportService.remove(idCard);
        if (remove) {
            return ResponseResult.successString("");
        }
        return ResponseResult.failString("删除失败");
    }


}
