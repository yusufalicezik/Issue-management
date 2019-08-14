package com.yusufalicezik.BackEndProje.service;

import com.yusufalicezik.BackEndProje.Entity.Project;
import com.yusufalicezik.BackEndProje.dto.ProjectDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProjectService {

    public ProjectDto save(ProjectDto project);

    public ProjectDto getById(Long id);
    public Page<Project> getAllPageable(Pageable pageable);
    public Boolean delete(Project project);
    public Project getByProjectCode(String projectCode);
    public List<Project> getByProjectCodeContains(String projectCode);

    public ProjectDto update(Long id, ProjectDto projectDto);
}
