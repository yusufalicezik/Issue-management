package com.yusufalicezik.BackEndProje.api;

import com.yusufalicezik.BackEndProje.dto.ProjectDto;
import com.yusufalicezik.BackEndProje.service.impl.ProjectServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/project")
@Api(value = "/project", description = "Project Api") //swagger için
public class ProjectController {

    private final ProjectServiceImpl projectServiceImpl;

    public ProjectController(ProjectServiceImpl projectServiceImpl){
        this.projectServiceImpl = projectServiceImpl;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Id'ye göre project getir", response = ProjectDto.class) //Swagger
    public ResponseEntity<ProjectDto>getById(@PathVariable(value = "id", required = true) Long id){
        ProjectDto projectDto = projectServiceImpl.getById(id); //1 ve long
        return ResponseEntity.ok(projectDto);
    }

    @PostMapping //path koymadık oyomatik project pathine post edilecek.
    @ApiOperation(value = "Proje oluştur", response = ProjectDto.class)//Swagger
    public ResponseEntity<ProjectDto> createProject(@Valid @RequestBody ProjectDto projectDto){
       return ResponseEntity.ok(projectServiceImpl.save(projectDto));

    }

    //@RequestMapping(path = "/update", method = RequestMethod.PUT) bu uzun yazımı
    @PutMapping("/{id}")
    @ApiOperation(value = "Id'ye göre project güncelle", response = ProjectDto.class)//Swagger
    public ResponseEntity<ProjectDto>updateProject(@PathVariable(value = "id", required = true) Long id, @Valid @RequestBody ProjectDto projectDto){

        return ResponseEntity.ok(projectServiceImpl.update(id,projectDto));
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Id'ye göre proje sil", response = Boolean.class)//Swagger
    public ResponseEntity<Boolean> delete(@PathVariable(value = "id", required = true) Long id){

        return ResponseEntity.ok(projectServiceImpl.deleteById(id));
    }
}
