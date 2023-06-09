package Action;

import DataBaseGet.DataBaseGet;
import com.opensymphony.xwork2.Action;
import user.StudyClass;
import user.School;
import user.Student;
import java.util.ArrayList;


public class RegisterAction implements Action {
    //由用户填写，前端获取后发给Action
    private String username;   //用户名
    private String password;   //密码
    private String studentname;//学生姓名
    private String tel;        //学生电话
    private String schoolName; //学校名称
    private String className;  //班级名称

    //有默认值，或由数据库中得到
    private int schoolId;     //学校Id
    private int classId;      //班级Id
    private String permissions="a";  //权限

    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public String getStudentname() {
        return studentname;
    }
    public String getTel() {
        return tel;
    }
    public String getPermissions() {
        return permissions;
    }
    public String getSchoolName() {
        return schoolName;
    }
    public String getClassName() {
        return className;
    }

    @Override
    public String execute() throws Exception {
        //username如果重复的话，返回ERROR，重新填写信息
        DataBaseGet db=new DataBaseGet();
        ArrayList<Student> students =db.GetUser();
        ArrayList<StudyClass> classes=db.GetClasses();
        ArrayList<School> schools=db.GetSchools();
        Boolean schoolFind=false;   //作为标志变量看是否找到用户输入的school
        Boolean classFind=false;    //作为标志变量看是否找到用户输入的class

        //判断是否找到用户输入的学校和班级
        for (int i = 0; i < schools.size(); i++) {
            if(schools.get(i).getSchoolName().equals(schoolName)){
                schoolId=schools.get(i).getSchoolId();
                schoolFind=true;
            }
        }
        if(!schoolFind){
            return NONE;//返回NONE，代表未找到用户输入的学校
        }
        for (int i = 0; i < classes.size(); i++) {
            if(classes.get(i).getClassName().equals(className)){
                classId=classes.get(i).getClassId();
                classFind=true;
            }
        }
        if(!classFind){
            return LOGIN;//返回LOGIN，代表未找到用户输入的班级
        }

        //判断用户名是否重复
        for (int i = 0; i < students.size(); i++) {
            if(students.get(i).getUserName().equals(username)){
                return ERROR;//用户名重复
            }
        }


        /*在这里将类中的各个属性填入数据库，想想学生id该怎么存？怎样可以设置递增
         *
         *


         * 待完成
         * 待完成
         * 待完成
         * 待完成
         * 待完成
         * 待完成
         * 待完成
         *
         * */


        return SUCCESS;

    }

}
