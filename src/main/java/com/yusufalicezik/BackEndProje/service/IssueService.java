package com.yusufalicezik.BackEndProje.service;

import com.yusufalicezik.BackEndProje.Entity.Issue;
import com.yusufalicezik.BackEndProje.dto.IssueDto;
import com.yusufalicezik.BackEndProje.util.TPage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IssueService {
    public IssueDto save(IssueDto issue);
    public IssueDto getById(Long id);
    public TPage<IssueDto> getAllPageable(Pageable pageable);
    public Boolean delete(IssueDto issue);

}
