package az.orient.course.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class RespTeacherList {


    @JsonProperty(value = "teacherList")
    private List<RespTeacher> respTeacherList;
    private RespStatus status;
}
