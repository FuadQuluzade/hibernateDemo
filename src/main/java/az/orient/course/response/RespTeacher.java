package az.orient.course.response;

import lombok.Data;

@Data
public class RespTeacher {


    private Long teacherId;
    private String name;
    private String surname;
    private String address;
    private String  dob;
    private String phone;
    private Integer experience;
    private RespStatus status;
}
