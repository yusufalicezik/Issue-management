package com.yusufalicezik.BackEndProje.service.impl;

import com.yusufalicezik.BackEndProje.Entity.IssueHistory;
import com.yusufalicezik.BackEndProje.repository.IssueHistoryRepository;
import com.yusufalicezik.BackEndProje.repository.IssueRepository;
import com.yusufalicezik.BackEndProje.service.IssueHistoryService;
import com.yusufalicezik.BackEndProje.service.IssueService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service //singleton instance yaratır. repodan farkı, bu repodan daha sonra yaratılır, öncelik olarak düşük.
public class IssueHistoryServiceImpl implements IssueHistoryService {


    private final IssueHistoryRepository issueHistoryRepository;
    public IssueHistoryServiceImpl(IssueHistoryRepository issueHistoryRepository){
        this.issueHistoryRepository = issueHistoryRepository;
    }


    @Override
    public IssueHistory save(IssueHistory issueHistory) {
        if(issueHistory.getIssue().getDate() == null){
            throw new IllegalArgumentException("Issue can not ve null");
        }
        issueHistory = issueHistoryRepository.save(issueHistory);
        return issueHistory;
    }

    @Override
    public IssueHistory getById(Long id) {
        return issueHistoryRepository.getOne(id);
    }

    @Override
    public Page<IssueHistory> getAllPageable(Pageable pageable) {
        return issueHistoryRepository.findAll(pageable);
    }

    @Override
    public Boolean delete(IssueHistory issueHistory) {
        issueHistoryRepository.delete(issueHistory);
        return Boolean.TRUE;
    }
}
