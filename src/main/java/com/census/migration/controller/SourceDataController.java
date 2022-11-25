package com.census.migration.controller;

import com.census.migration.service.SourceDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class SourceDataController implements SourceDataApi {

    @Autowired
    private SourceDataService sourceDataService;

    public String uploadSourceFile(MultipartFile file) {
        return sourceDataService.saveSourceData(file);
    }

}
