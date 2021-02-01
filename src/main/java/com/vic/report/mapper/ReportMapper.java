package com.vic.report.mapper;

import com.github.pagehelper.Page;
import com.vic.report.model.ReportDaoEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReportMapper {
    int insertReport(ReportDaoEntity report);

    Page<ReportDaoEntity> listReports(String userName, String idCard);

    ReportDaoEntity getReport(String idCard);

    int removeReport(String id);
}
