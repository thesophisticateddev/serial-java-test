package com.example.serialtest;


import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jpa.repository.JpaRepository;

@Repository
public interface LogRecordRepository extends JpaRepository<LogRecord,Long> {
}
