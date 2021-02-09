package az.orient.course.request;

import lombok.Data;

import java.util.Date;

@Data
public class ReqTeacher {

    private Long teacherId;
    private String name;
    private String surname;
    private String address;
    private String phone;
    private Date dob;
    private Integer experience;
}
