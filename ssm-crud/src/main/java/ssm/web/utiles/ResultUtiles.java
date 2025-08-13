package ssm.web.utiles;

import java.lang.reflect.Method;

public class ResultUtiles {


    /**
     * 最终响应一个统一的json字符串
     * @param anEnum 传入一个枚举，要求该枚举具有getCode和getMsg方法
     * @param data
     * @return
     * @param <T>
     */
    public static <T> ResponseData<T> result(Enum anEnum,T data){
        try{
            ResponseData<T> responseData = new ResponseData<>();
            responseData.setData(data);
            if(anEnum != null){
                Method getCodeMethod = anEnum.getClass().getMethod("getCode");
                Method getMsgMethod = anEnum.getClass().getMethod("getMsg");
                if(getCodeMethod != null){
                    responseData.setCode((Integer)getCodeMethod.invoke(anEnum));
                }
                if(getMsgMethod != null){
                    responseData.setMsg((String)getMsgMethod.invoke(anEnum));
                }
            }
            return responseData;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
