package com.yusufalicezik.BackEndProje.service;

import com.yusufalicezik.BackEndProje.Entity.IssueHistory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IssueHistoryService {
    public IssueHistory save(IssueHistory issueHistory);
    public IssueHistory getById(Long id);
    public Page<IssueHistory> getAllPageable(Pageable pageable);
    public Boolean delete(IssueHistory issueHistory);
}
