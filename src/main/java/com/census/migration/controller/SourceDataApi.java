package com.census.migration.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@RequestMapping("/api/migration")
public interface SourceDataApi {

    @PostMapping("/upload")
    String uploadSourceFile(@RequestParam("file") MultipartFile file);
}
