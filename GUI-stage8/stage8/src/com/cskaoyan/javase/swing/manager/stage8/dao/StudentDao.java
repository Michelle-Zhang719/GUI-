package com.cskaoyan.javase.swing.manager.stage8.dao;

import com.cskaoyan.javase.swing.manager.stage8.model.Student;

/**
 * 与Student学生数据相关的，数据操作的接口
 *
 * @since 14:21
 * @author wuguidong@cskaoyan.onaliyun.com
 */
public interface StudentDao {
    // 从数据源中获取学生信息,需要去除数组中为null的元素
    Student[] getRealStudents();

    // 获取表格列数据
    String[] getTableColumns();

    // 通过id删除学生
    boolean delStudent(String id);

    // 判断学号的唯一性
    boolean checkStuIdRepeat(String id);

    // 新增学生
    boolean addStudent(Student stu);

    // 通过stuId查询学生
    Student getStudentByStuId(String stuId);

    // 通过name查询学生
    Student[] getStudentByName(String name);

    // 修改一个学生的某个属性
    boolean updateStuFieldByStuId(String targetStuId, int targetCol, String newValue);

    // 修改一条学生信息
    int updateStudentByStuId(String targetStuId, Student stu);

    // 将内存中的学生数组保存到文件中
    boolean saveDataToFile();
}
