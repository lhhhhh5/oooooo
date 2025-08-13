package edu.bw.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SelectDeptByConditionForm {
    /*部门名称*/
    private String deptName;

    /*当前页*/
    private Integer page;

    /*每页显示条数*/
    private Integer length;
    /*起始*/
    private Integer start;
}
