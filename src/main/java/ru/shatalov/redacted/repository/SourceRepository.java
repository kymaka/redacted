package ru.shatalov.redacted.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.shatalov.redacted.model.SourceData;

@ResponseBody
public interface SourceRepository extends JpaRepository<SourceData, Long> {}
