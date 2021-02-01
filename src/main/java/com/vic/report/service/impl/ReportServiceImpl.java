package com.vic.report.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.vic.report.mapper.ReportMapper;
import com.vic.report.model.Report;
import com.vic.report.model.ReportDaoEntity;
import com.vic.report.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.rowset.serial.SerialBlob;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

@Service
public class ReportServiceImpl implements ReportService {
    @Autowired
    ReportMapper reportMapper;

    @Override
    public Page<ReportDaoEntity> listReports(String userName,String idCard,int page,int pageSize) {
        PageHelper.startPage(page, pageSize);
        Page<ReportDaoEntity> reportDaoEntities = reportMapper.listReports(userName, idCard);
        return reportDaoEntities;
    }


    @Override
    public void insertReport(Report report) throws IOException, SQLException {
        ReportDaoEntity reportDaoEntity = new ReportDaoEntity();
        reportDaoEntity.setId(UUID.randomUUID().toString());
        reportDaoEntity.setUserName(report.getUserName());
        reportDaoEntity.setIdCard(report.getIdCard());
        Blob blob = new SerialBlob(report.getReportBlob().getBytes());
        reportDaoEntity.setReport(blob);
        reportMapper.insertReport(reportDaoEntity);
    }

    @Override
    public ReportDaoEntity getReport(String idCard) {
        return reportMapper.getReport(idCard);
    }

    public boolean remove(String id) {
        int i = reportMapper.removeReport(id);
        return i == 1;
    }
}
