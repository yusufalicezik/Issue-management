package com.yusufalicezik.BackEndProje.repository;

import com.yusufalicezik.BackEndProje.Entity.IssueHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IssueHistoryRepository extends JpaRepository<IssueHistory,Long> {
}
