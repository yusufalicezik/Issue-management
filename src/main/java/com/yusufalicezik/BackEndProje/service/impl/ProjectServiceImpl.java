package com.yusufalicezik.BackEndProje.service.impl;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.yusufalicezik.BackEndProje.Entity.Project;
import com.yusufalicezik.BackEndProje.dto.ProjectDto;
import com.yusufalicezik.BackEndProje.repository.ProjectRepository;
import com.yusufalicezik.BackEndProje.service.ProjectService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;
    private final ModelMapper modelMapper;

    public ProjectServiceImpl(ProjectRepository projectRepository, ModelMapper modelMapper){
        this.projectRepository = projectRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ProjectDto save(ProjectDto project) {
        /**if(project.getProjectCode()==null) {
            throw new IllegalArgumentException("Project code null olamaz!");
        } gerek kalmadı notnull ekledik **/

        Project projectCheck = projectRepository.getByProjectCode(project.getProjectCode());
        if(projectCheck != null){
            throw new IllegalArgumentException("Project code zaten var!");
        }
        Project p = modelMapper.map(project,Project.class);
        p = projectRepository.save(p);
        project.setId(p.getId());
        return project;
    }



    @Override
    public ProjectDto getById(Long id) {
        Project p = projectRepository.getOne(id);
        return modelMapper.map(p,ProjectDto.class);
    }

    @Override
    public Page<Project> getAllPageable(Pageable pageable) {
        return projectRepository.findAll(pageable);
    }

    @Override
    public Boolean delete(Project project) {
        projectRepository.delete(project);
        return Boolean.TRUE;
    }


    public Boolean deleteById(Long id) {
        projectRepository.deleteById(id);
        return Boolean.TRUE;
    }


    @Override
    public Project getByProjectCode(String projectCode) {
        return null;
    }

    @Override
    public List<Project> getByProjectCodeContains(String projectCode) {
        return projectRepository.getByProjectCodeContains(projectCode);
    }

    @Override
    public ProjectDto update(Long id, ProjectDto projectDto) {
        Project projectDb = projectRepository.getOne(id);
        if(projectDb == null){
            throw new IllegalArgumentException("Böyle bir proje bulunamadı!");
        }

        Project projectCheck = (Project) projectRepository.getByProjectCodeAndIdNot(projectDto.getProjectCode(),id);
        if(projectCheck != null && projectCheck.getId() != projectDb.getId()){
            throw new IllegalArgumentException("Project code zaten var!");
        }
        projectDb.setProjectCode(projectDto.getProjectCode());
        projectDb.setProjectName(projectDto.getProjectName());
        projectRepository.save(projectDb); //yine save e gider ama id si olduğu için update modunda çalıştırır bu kez. save değil.
        return modelMapper.map(projectDb,ProjectDto.class);
    }
}
