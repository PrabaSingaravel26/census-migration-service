package com.census.migration.service;

import org.springframework.web.multipart.MultipartFile;

public interface SourceDataService {
    String saveSourceData(MultipartFile file);
}
