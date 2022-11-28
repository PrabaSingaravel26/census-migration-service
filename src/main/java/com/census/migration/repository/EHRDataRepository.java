package com.census.migration.repository;

import com.census.migration.model.EHRData;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EHRDataRepository extends MongoRepository<EHRData, Integer> {
}
