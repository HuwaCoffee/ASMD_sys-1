package user;

import java.util.ArrayList;
/*班级类中包含某个班级的所有学生信息
可以通过声明一个班级类型的变量进行学校信息的存储和增删改查*/
public class StudyClass {
    private ArrayList<Student>studentList;   //储存学生信息的数组
    private int ClassId;                     //班级id
    private String ClassName;                //班级名称

    public ArrayList<Student> getStudentList() {
        return studentList;
    }
    public void setStudentList(ArrayList<Student> studentList) {
        this.studentList = studentList;
    }
    public int getClassId() {
        return ClassId;
    }
    public void setClassId(int classId) {
        ClassId = classId;
    }
    public String getClassName() {
        return ClassName;
    }
    public void setClassName(String className) {
        ClassName = className;
    }
}
