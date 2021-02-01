package com.vic.report.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Blob;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReportDaoEntity {
    private String id;
    private String userName;
    private String idCard;
    private Blob report;
    private byte[] reportByte;
}
