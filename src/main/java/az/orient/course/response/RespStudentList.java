package az.orient.course.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class RespStudentList {

    @JsonProperty(value = "studentList")
    private List<RespStudent> respStudentList;
    private RespStatus status;
}
