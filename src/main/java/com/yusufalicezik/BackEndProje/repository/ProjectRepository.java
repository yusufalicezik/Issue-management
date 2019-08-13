package com.yusufalicezik.BackEndProje.repository;

import com.yusufalicezik.BackEndProje.Entity.Project;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;

import java.util.List;

// @Repository eklenmesi gerek ancak jpaRepostory olduğu için gerek kalmadı.
public interface ProjectRepository extends JpaRepository<Project,Long> {

    List<Project> getByProjectCode(String projectCode); //where conditional ile sorgulama

    //Sıralama önemli, ilk code, sonra name ise parametreler de aynı şekilde.
    List<Project> getByProjectCodeAndProjectNameContains(String projectCode, String name); //adı name i içerecek ve code code olan. Sıralama aynı olacak.

    List<Project> getByProjectCodeContains(String projectCode);
    Page<Project> findAll(Pageable pageable);
    List<Project> findAll(Sort sort);
}

//Crud kullanıkacaksa sadece JpaRepostory yerine CrudRepostory de extends edilebilir.