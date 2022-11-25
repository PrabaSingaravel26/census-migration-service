package com.census.migration.service;

import com.census.migration.helper.CSVHelper;
import com.census.migration.helper.ExcelHelper;
import com.census.migration.model.SourceData;
import com.census.migration.repository.SourceDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class SourceDataServiceImpl implements SourceDataService {

    @Autowired
    private SourceDataRepository sourceDataRepository;

    @Override
    public String saveSourceData(MultipartFile file) {
        if (CSVHelper.hasCSVFormat(file)) {
            try {
                List<SourceData> sourceDataList = CSVHelper.csvToSourceData(file.getInputStream());
                sourceDataRepository.saveAll(sourceDataList);
                return "Uploaded the csv file successfully: " + file.getOriginalFilename();
            } catch (IOException e) {
                throw new RuntimeException("fail to store csv data: " + e.getMessage());
            }
        } else if(ExcelHelper.hasExcelFormat(file)){
            try {
                List<SourceData> sourceDataList = ExcelHelper.excelToSourceData(file.getInputStream());
                sourceDataRepository.saveAll(sourceDataList);
                return "Uploaded the excel file successfully: " + file.getOriginalFilename();
            } catch (IOException e) {
                throw new RuntimeException("fail to store excel data: " + e.getMessage());
            }
        } else {
            return "Please upload a csv/excel file!";
        }
    }
}
