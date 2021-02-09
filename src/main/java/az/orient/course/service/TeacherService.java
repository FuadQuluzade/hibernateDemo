package az.orient.course.service;

import az.orient.course.request.ReqTeacher;
import az.orient.course.response.RespStatusList;
import az.orient.course.response.RespTeacher;
import az.orient.course.response.RespTeacherList;

import java.util.List;

public interface TeacherService {

   RespTeacherList getTeacherList();

   RespTeacher getTeacherById(Long teacherId);

   RespStatusList addTeacher(ReqTeacher reqTeacher);

   RespStatusList updateTeacher(ReqTeacher reqTeacher);

   RespStatusList deleteTeacher(Long teacherId);
}
