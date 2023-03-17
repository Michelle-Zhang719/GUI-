package com.cskaoyan.javase.swing.manager.stage6.dao.impl;

import com.cskaoyan.javase.swing.manager.stage6.dao.StudentDao;
import com.cskaoyan.javase.swing.manager.stage6.model.Student;
import com.cskaoyan.javase.swing.manager.stage6.model.StudentData;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 与学生Student相关的，所有数据处理都在该类下进行
 *
 * @since 14:26
 * @author wuguidong@cskaoyan.onaliyun.com
 */
public class StudentDaoImpl implements StudentDao {

    // 从数据源获取数据
    private Student[] STUDS = StudentData.STUDS;
    private String[] COLUMNS = StudentData.COLUMNS;

    @Override
    public Student[] getRealStudents() {
        // 获取数据
        // 确定不为null学生元素的个数
        int count = 0;
        for (Student stu : STUDS) {
            if (stu != null) {
                count++;
            }
        }
        Student[] result = new Student[count];
        int index = 0;
        for (Student stu : STUDS) {
            if (stu != null) {
                result[index] = stu;
                index++;
            }
        }
        return result;
    }

    @Override
    public String[] getTableColumns() {
        return COLUMNS;
    }

    /**
     * 数组无法真正删除一个存储单元,所以将对象置为null
     *      将这个逻辑视为删除一条学生信息
     *      删除成功(对象置为null成功)就返回true
     *      构造就返回false
     * @since 10:04
     * @param id 学生id
     * @return boolean
     * @author wuguidong@cskaoyan.onaliyun.com
     */
    @Override
    public boolean delStudent(String id) {
        for (int i = 0; i < STUDS.length; i++) {
            // 为了避免空指针异常,排除null
            if (STUDS[i] == null) {
                continue;
            }
            if (id.equals(STUDS[i].getStuId())) {
                STUDS[i] = null;
                // 删除成功
                return true;
            }
        }
        return false;
    }

    /**
     * 检查id是否重复,true表示id重复,false为不重复
     * @since 18:09
     * @param id 传入学生id
     * @return boolean true表示id重复,false为不重复
     * @author wuguidong@cskaoyan.onaliyun.com
     */
    @Override
    public boolean checkStuIdRepeat(String id) {
        Student[] realStudents = getRealStudents();
        for (Student realStudent : realStudents) {
            if (realStudent.getStuId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 插入,由于数组长度不可改变，所以将null变为一个对象
     * @since 14:26
     * @param stu 非空学生
     * @return boolean
     * @author wuguidong@cskaoyan.onaliyun.com
     */
    @Override
    public boolean addStudent(Student stu) {
        for (int i = 0; i < STUDS.length; i++) {
            if (STUDS[i] == null) {
                STUDS[i] = stu;
                return true;
            }
        }
        return false;
    }

    /**
     * 通过id查询学生,如果没查到就返回null
     * @since 20:43
     * @param stuId 检索目标id
     * @return Student
     * @author wuguidong@cskaoyan.onaliyun.com
     */
    @Override
    public Student getStudentByStuId(String stuId) {
        // 去除null,避免空指针异常
        Student[] realStudents = getRealStudents();
        for (Student stu : realStudents) {
            if (stu.getStuId().equals(stuId)) {
                return stu;
            }
        }
        return null;
    }

    /**
     * 通过name查询学生,如果没查到就返回null。由于查到的学生记录可能不止一条，所以需要一个学生数组存放
     * @since 12:38
     * @param name 检索目标name
     * @return Student[]
     * @author wuguidong@cskaoyan.onaliyun.com
     */
    @Override
    public Student[] getStudentByName(String name) {
        // 去除null,避免空指针异常
        Student[] realStudents = getRealStudents();
        int count = 0;
        for (Student stu : realStudents) {
            if (stu.getName().equals(name)) {
                count++;
            }
        }
        if (count == 0) {
            // 未找到学生
            return null;
        }
        // 创建对应长度的学生数组
        Student[] result = new Student[count];
        // 遍历并赋值
        int index = 0;
        for (Student stu : realStudents) {
            if (stu.getName().equals(name)) {
                result[index] = stu;
                index++;
            }
        }
        return result;
    }

    /**
     * 通过id修改学生的某个属性
     * 通过id确定修改的是哪个学生
     * 通过传入的列数确定修改的数据是什么
     * @since 22:07
     * @param targetStuId 目标id
     * @param targetCol 目标列
     * @param newValue 目标值
     * @return boolean
     * @author wuguidong@cskaoyan.onaliyun.com
     */
    @Override
    public boolean updateStuFieldByStuId(String targetStuId, int targetCol, String newValue) {
        for (int i = 0; i < STUDS.length; i++) {
            // 为了避免空指针异常,排除null
            if (STUDS[i] == null) {
                continue;
            }
            if (targetStuId.equals(STUDS[i].getStuId())) {
                // 找到该学生对象
                switch (targetCol) {
                    case 1:
                        // 姓名
                        STUDS[i].setName(newValue);
                        break;
                    case 2:
                        // 性别
                        STUDS[i].setGender(newValue);
                        break;
                    case 3:
                        // 学校
                        STUDS[i].setSchool(newValue);
                        break;
                    case 4:
                        // 专业
                        STUDS[i].setMajor(newValue);
                        break;
                    case 5:
                        STUDS[i].setAge(newValue);
                        // 年龄
                        break;
                    case 6:
                        STUDS[i].setCity(newValue);
                        // 城市
                        break;
                    case 7:
                        STUDS[i].setPhone(newValue);
                        // 手机号
                        break;
                    case 8:
                        STUDS[i].setEmail(newValue);
                        // 电子邮箱
                        break;
                    default:
                        // 错误的列数,返回false
                        return false;
                }
                return true;
            }
        }
        return false;
    }


    /**
     * 通过id修改一条学生信息,相当于在数组中用传入的学生对象替代原本的学生对象
     * 方法返回一个int状态值表示结果:
     *      0: 表示成功修改
     *      1: 表示数据完全一致,禁止修改
     *      2: 未找到该学生,修改失败
     * @since 13:30
     * @param targetStuId 目标id
     * @param stu 新的学生对象
     * @return boolean
     * @author wuguidong@cskaoyan.onaliyun.com
     */
    @Override
    public int updateStudentByStuId(String targetStuId, Student stu) {
        for (int i = 0; i < STUDS.length; i++) {
            // 为了避免空指针异常,排除null
            if (STUDS[i] == null) {
                continue;
            }
            if (targetStuId.equals(STUDS[i].getStuId())) {
                if (STUDS[i].equals(stu)) {
                    // 说明未做任何修改,禁止修改
                    return 1;
                }
                // 找到后,直接替换
                STUDS[i] = stu;
                // 修改成功
                return 0;
            }
        }
        // 修改失败
        return 2;
    }

    /*
     *
     * 创建日期：2021/12/27 16:47
     * @return boolean
     * @author 景天
     */
    @Override
    public boolean saveDataToFile() {
        // TODO 补全代码
        return false;
    }


}
