package com.census.migration.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "source_data")
public class SourceData {
    @Id
    private int patientId;
    private String name;
    private String address;
    private String state;
    private int zipCode;
    private String county;
    private Long mobileNumber;
    private String gender;
}
