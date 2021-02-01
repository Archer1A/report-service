package com.vic.report.service;


import com.github.pagehelper.Page;
import com.vic.report.model.Report;
import com.vic.report.model.ReportDaoEntity;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface ReportService {
    Page<ReportDaoEntity> listReports(String userName,String idCard, int page, int pageSize);

    void insertReport(Report report) throws IOException, SQLException;

    ReportDaoEntity getReport(String idCard);

    boolean remove(String id);
}
