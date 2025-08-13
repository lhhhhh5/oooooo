package ssm.web.enums;


import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum OperationStatus {
    SUCCESS(200,"操作成功"),
    FAIL(404,"操作失败");


    private Integer code;
    private String msg;
}
