package com.yusufalicezik.BackEndProje.dto;

import com.yusufalicezik.BackEndProje.Entity.IssueStatus;
import lombok.Data;

import java.util.Date;

@Data
public class IssueDto { //clienta gidecekler
    private Long id;
    private String description;
    private String details;
    private Date date;
    private IssueStatus issueStatus;
    private UserDto assignee; //normalde User gidecek ancak user giderse password vs de gider. sadece dışarıyla konuşacak nesneler yaratıyoruz dto ile
    private ProjectDto project;
}
