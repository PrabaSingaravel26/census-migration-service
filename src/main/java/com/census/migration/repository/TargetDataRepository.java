package com.census.migration.repository;

import com.census.migration.model.TargetData;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TargetDataRepository extends MongoRepository<TargetData, String> {
}
