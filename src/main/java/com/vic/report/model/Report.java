package com.vic.report.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Report {
    private String id;
    private String userName;
    private String idCard;
    private MultipartFile reportBlob;

}
