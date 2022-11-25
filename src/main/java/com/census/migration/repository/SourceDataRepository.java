package com.census.migration.repository;

import com.census.migration.model.SourceData;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SourceDataRepository extends MongoRepository<SourceData, Integer> {
}
