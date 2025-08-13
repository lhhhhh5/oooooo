package edu.bw.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import edu.bw.utils.PermissionDeserializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateRoleForm {

    private Integer id;

    private String roleName;


    /*
    序列化：将java转为json数据
    反序列化：将json转为java对象
     */
    @JsonDeserialize(using = PermissionDeserializer.class)
    private String permissions;
//    private String permissions;
//    private List<Integer> permissions

    private String desc;
}
