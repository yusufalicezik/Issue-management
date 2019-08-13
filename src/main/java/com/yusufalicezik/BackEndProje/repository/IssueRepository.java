package com.yusufalicezik.BackEndProje.repository;

import com.yusufalicezik.BackEndProje.Entity.Issue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IssueRepository extends JpaRepository<Issue,Long> { //hangi tablo ve id türü



}
