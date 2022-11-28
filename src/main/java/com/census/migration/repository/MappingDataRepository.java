package com.census.migration.repository;

import com.census.migration.model.MappingTable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MappingDataRepository extends MongoRepository<MappingTable, String> {
    MappingTable findBySourceEHR(String sourceEHRType);
}
