package az.orient.course.controller;

import az.orient.course.request.ReqStudent;
import az.orient.course.request.ReqTeacher;
import az.orient.course.response.*;
import az.orient.course.service.StudentService;
import az.orient.course.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/teacher")
public class TeacherController {

        @Autowired
        private TeacherService teacherService;

        @GetMapping(value = "/getTeacherList")
        public RespTeacherList getTeacherList() {
            return teacherService.getTeacherList();
        }

        @PostMapping(value = "/addTeacher")
        public RespStatusList addTeacher(@RequestBody ReqTeacher reqTeacher){
            return  teacherService.addTeacher(reqTeacher);
        }

        @PutMapping(value = "/updateTeacher")
        public RespStatusList updateTeacher(@RequestBody ReqTeacher reqTeacher){
            return  teacherService.updateTeacher(reqTeacher);
        }

        @PutMapping(value = "/deleteTeacher/{teacherId}")
        public RespStatusList deleteTeacher(@PathVariable Long teacherId){
            return  teacherService.deleteTeacher(teacherId);
        }

        @GetMapping(value = "/getTeacherById/{teacherId}")
        public RespTeacher getStudentById(@PathVariable Long teacherId) {
            return teacherService.getTeacherById(teacherId);
        }

    }
