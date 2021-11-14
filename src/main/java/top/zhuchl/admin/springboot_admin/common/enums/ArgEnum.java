package top.zhuchl.admin.springboot_admin.common.enums;

/**
 * @Author AlphaZcl
 * @Date 2021/11/13
 **/
public enum ArgEnum {

    ARG_USER("name","zcl"),
    ARG_ADDRESS("address","sssss");

    private String key;

    private String value;

    public String getKey(){
        return this.key;
    }

    public String getValue(){
        return this.value;
    }

    ArgEnum(String key,String value){
        this.key = key;
        this.value = value;
    }

    public static ArgEnum getInstance(String key){
        for (ArgEnum e: values()) {
            if(e.key.equals(key)){
                return e;
            }
        }
        return null;
    }
}
