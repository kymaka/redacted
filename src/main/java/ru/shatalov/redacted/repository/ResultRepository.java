package ru.shatalov.redacted.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.shatalov.redacted.model.ResultData;

@Repository
public interface ResultRepository extends JpaRepository<ResultData, Long> {}
