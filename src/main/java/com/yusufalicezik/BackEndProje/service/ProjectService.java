package com.yusufalicezik.BackEndProje.service;

import com.yusufalicezik.BackEndProje.Entity.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProjectService {
    public Project save(Project project);
    public Project getById(Long id);
    public Page<Project> getAllPageable(Pageable pageable);
    public Boolean delete(Project project);
    public List<Project> getByProjectCode(String projectCode);
    public List<Project> getByProjectCodeContains(String projectCode);

}
