package az.orient.course.service.Impl;

import az.orient.course.entity.Student;
import az.orient.course.entity.Teacher;
import az.orient.course.enums.EnumDataStatus;
import az.orient.course.exception.ExceptionConstant;
import az.orient.course.repository.TeacherDao;
import az.orient.course.request.ReqTeacher;
import az.orient.course.response.*;
import az.orient.course.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherDao teacherDao;

    DateFormat df=new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public RespTeacherList getTeacherList() {
        RespTeacherList response=new RespTeacherList();
        List<RespTeacher> respTeacherList=new ArrayList<>();

        try {
            List<Teacher> teacherList=  teacherDao.findAllByActive(EnumDataStatus.ACTIVE.getValue());
            if(teacherList.isEmpty()){
                response.setStatus(new RespStatus(ExceptionConstant.DATA_NOT_FOUND,"Data not found"));
                return  response;
            }
            for(Teacher teacher :teacherList){
                RespTeacher respTeacher=new RespTeacher();
                respTeacher.setTeacherId(teacher.getId());
                respTeacher.setName(teacher.getName());
                respTeacher.setSurname(teacher.getSurname());
                respTeacher.setAddress(teacher.getAddress());
                respTeacher.setPhone(teacher.getPhone());
                respTeacher.setExperience(teacher.getExperience());
                if(teacher.getDob() != null)
                    respTeacher.setDob(df.format(teacher.getDob()));
                respTeacherList.add(respTeacher);

            }
            response.setRespTeacherList(respTeacherList);
            response.setStatus(RespStatus.getSuccessMessage());
        } catch (Exception e) {
            e.printStackTrace();
            response.setStatus(new RespStatus(ExceptionConstant.INTERNAL_EXCEPTION,"internal exception"));
        }
        return response;
    }

    @Override
    public RespTeacher getTeacherById(Long teacherId) {
        RespTeacher response=new RespTeacher();
        try {
            if(teacherId ==null){
                response.setStatus(new RespStatus(ExceptionConstant.INVALID_REQUEST_DATA,"Invalid request data"));
                return response;

            }
            Teacher teacher=  teacherDao.findTeacherByIdAndActive(teacherId,EnumDataStatus.ACTIVE.getValue());
            if(teacher == null){
                response.setStatus(new RespStatus(ExceptionConstant.DATA_NOT_FOUND,"Data not found"));
                return  response;
            }

            response.setTeacherId(teacher.getId());
            response.setName(teacher.getName());
            response.setSurname(teacher.getSurname());
            response.setAddress(teacher.getAddress());
            response.setPhone(teacher.getPhone());
            response.setExperience(teacher.getExperience());
            if(teacher.getDob() != null)
                response.setDob(df.format(teacher.getDob()));
            response.setStatus(RespStatus.getSuccessMessage());
        } catch (Exception e) {
            e.printStackTrace();
            response.setStatus(new RespStatus(ExceptionConstant.INTERNAL_EXCEPTION,"internal exception"));
        }
        return response;
    }

    @Override
    public RespStatusList addTeacher(ReqTeacher reqTeacher) {
        RespStatusList response =new RespStatusList();
        try {
            String name=reqTeacher.getName();
            String surname =reqTeacher.getSurname();
            String address =reqTeacher.getAddress();
            String phone=reqTeacher.getPhone();
            Date dob=reqTeacher.getDob();
            Integer experience=reqTeacher.getExperience();
            if(name == null ||
                    surname == null||
                    dob== null  ){
                response.setStatus(new RespStatus(ExceptionConstant.INVALID_REQUEST_DATA,"Invalid request data"));
                return response;

            }
            Teacher teacher =new Teacher();
            teacher.setName(name);
            teacher.setSurname(surname);
            teacher.setAddress(address);
            teacher.setPhone(phone);
            teacher.setDob(dob);
            teacher.setExperience(experience);
            teacherDao.save(teacher);
            response.setStatus(RespStatus.getSuccessMessage());
        }catch (Exception ex){
            ex.printStackTrace();
            response.setStatus(new RespStatus(ExceptionConstant.INTERNAL_EXCEPTION,"internal exception"));

        }
        return response;
    }

    @Override
    public RespStatusList updateTeacher(ReqTeacher reqTeacher) {
        RespStatusList response =new RespStatusList();
        try {
            String name=reqTeacher.getName();
            String surname =reqTeacher.getSurname();
            String address =reqTeacher.getAddress();
            String phone=reqTeacher.getPhone();
            Date dob=reqTeacher.getDob();
            Integer experience=reqTeacher.getExperience();
            Long teacherId=reqTeacher.getTeacherId();
            if(name == null ||
                    surname == null||
                    dob== null  ){
                response.setStatus(new RespStatus(ExceptionConstant.INVALID_REQUEST_DATA,"Invalid request data"));
                return response;
            }
            Teacher teacher= teacherDao.findTeacherByIdAndActive(teacherId,EnumDataStatus.ACTIVE.getValue());
            if(teacher==null){
                response.setStatus(new RespStatus(ExceptionConstant.DATA_NOT_FOUND,"Data not found"));
                return response;
            }
            teacher.setName(name);
            teacher.setSurname(surname);
            teacher.setAddress(address);
            teacher.setPhone(phone);
            teacher.setDob(dob);
            teacher.setExperience(experience);
            teacher.setId(teacherId);
            teacher.setDataDate(teacher.getDataDate());
            teacher.setActive(teacher.getActive());
            teacherDao.save(teacher);
            response.setStatus(RespStatus.getSuccessMessage());
        }catch (Exception ex){
            ex.printStackTrace();
            response.setStatus(new RespStatus(ExceptionConstant.INTERNAL_EXCEPTION,"internal exception"));

        }
        return response;
    }

    @Override
    public RespStatusList deleteTeacher(Long teacherId) {
        RespStatusList response =new RespStatusList();
        try {
            if(teacherId==null){
                response.setStatus(new RespStatus(ExceptionConstant.INVALID_REQUEST_DATA,"Invalid request data"));
                return response;
            }
            Teacher teacher= teacherDao.findTeacherByIdAndActive(teacherId,EnumDataStatus.ACTIVE.getValue());
            if(teacher==null){
                response.setStatus(new RespStatus(ExceptionConstant.DATA_NOT_FOUND,"Data not found"));
                return response;
            }
            teacher.setId(teacherId);
            teacher.setActive(EnumDataStatus.INACTIVE.getValue());
            teacherDao.save(teacher);
            response.setStatus(RespStatus.getSuccessMessage());
        }catch (Exception ex){
            ex.printStackTrace();
            response.setStatus(new RespStatus(ExceptionConstant.INTERNAL_EXCEPTION,"internal exception"));

        }
        return response;
    }


}
