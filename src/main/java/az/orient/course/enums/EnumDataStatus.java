package az.orient.course.enums;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public enum EnumDataStatus {
    ACTIVE(1) ,INACTIVE(0) ;

    private Integer value;

    public static final Map<Integer, EnumDataStatus> VALUES= new ConcurrentHashMap<>();

    static {
        for (EnumDataStatus type: EnumDataStatus.values()){
              VALUES.put(type.value,type);
        }
    }

    private EnumDataStatus(int enumValue){
        this.value=enumValue;
    }

    public Integer getValue(){
        return value;
    }

    public static EnumDataStatus getEnum(Integer value){
        if(value == null)
            return null;
        return VALUES.get(value.intValue());
    }

}
