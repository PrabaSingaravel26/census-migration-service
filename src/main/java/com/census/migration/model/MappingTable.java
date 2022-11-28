package com.census.migration.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "mapping_table")
public class MappingTable {
    @Id
    private String sourceEHR;
    private String destinationEHR;
    private Map<String, String> sourceTargetColumnMap;
}
