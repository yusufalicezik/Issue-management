

package com.yusufalicezik.BackEndProje.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor

@ApiModel(value = "Project data objc transfer") //swagger
public class ProjectDto {
    @ApiModelProperty(value = "Projenin idsi") //swagger
    private Long id;
    @NotNull //namei null olamaz. clienta boş gösteremez.
    @ApiModelProperty(required = true, value = "Projenin adı") //swagger
    private String projectName;
    @NotNull
    @ApiModelProperty(required = true, value = "Projenin kodu") //swagger
    private String projectCode;
}
