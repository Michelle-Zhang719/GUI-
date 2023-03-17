package com.cskaoyan.javase.swing.manager.stage6.controller.impl;

import com.cskaoyan.javase.swing.manager.stage6.controller.StudentController;
import com.cskaoyan.javase.swing.manager.stage6.dao.StudentDao;
import com.cskaoyan.javase.swing.manager.stage6.dao.impl.StudentDaoImpl;
import com.cskaoyan.javase.swing.manager.stage6.model.Student;

/**
 * 与学生信息相关的,业务操作的具体实现
 * @since 19:30
 * @author wuguidong@cskaoyan.onaliyun.com
 */
public class StudentControllerImpl implements StudentController {

    // 业务处理需要获取数据,所以需要依赖数据处理层
    private StudentDao studentDao = new StudentDaoImpl();

    /**
     * java swing表格需要的表格数据是:
     *      String类型二维数组,所以需要封装出二维数组
     * @since 9:19
     * @return java.lang.String[][]
     * @author wuguidong@cskaoyan.onaliyun.com
     */
    @Override
    public String[][] getAllTableData() {
        // 获取数据
        Student[] realStudents = studentDao.getRealStudents();
        return get2DStrArrByStudentArr(realStudents);
    }

    /**
     * java swing表格列数据需要一维数组
     * @since 9:20
     * @return java.lang.String[]
     * @author wuguidong@cskaoyan.onaliyun.com
     */
    @Override
    public String[] getTableColumns() {
        return studentDao.getTableColumns();
    }

    /**
     * 根据界面传入的id来删除用户,方法会返回一个布尔值
     *      true表示删除成功,否者为删除失败
     * @since 9:21
     * @param id 界面传来的id
     * @return boolean
     * @author wuguidong@cskaoyan.onaliyun.com
     */
    @Override
    public boolean delStudent(String id) {
        // 删除之前,需要校验id
        // 没有获取id,就直接删除失败
        if (id == null || "".equals(id)) {
            return false;
        }
        return studentDao.delStudent(id);
    }

    /**
     * 检查id是否重复,true表示重复,否则为不重复
     * @since 18:11
     * @param id 学生id
     * @return boolean
     * @author wuguidong@cskaoyan.onaliyun.com
     */
    @Override
    public boolean checkStuIdRepeat(String id) {
        if (id == null || "".equals(id)) {
            // 若输入的id不存在,效果等同于重复,禁止插入
            return true;
        }
        return studentDao.checkStuIdRepeat(id);
    }

    /**
     * 导入一条学生信息，true表示成功，否则为失败
     * 由于已经判定过很多次了，所以失败只有一种可能，即数组满了
     * @since 14:21
     * @param stu GUI界面输入的学生对象
     * @return boolean
     * @author wuguidong@cskaoyan.onaliyun.com
     */
    @Override
    public boolean addStudent(Student stu) {
        if (stu == null) {
            // 传入null，直接算插入失败
            return false;
        }
        return studentDao.addStudent(stu);
    }

    /**
     * Swing表格中的数据,需要的是一个String类型二维数组,所以通过学号id去数据源查找一条学生信息,
     * 如果存在就返回一个长度为1,装有学生信息的String二维数组
     * 如果不存在就返回null
     * 注意: 学号是唯一的,所以只要查询到了,必然是一条数据
     * @since 20:35
     * @param stuId 查询使用的学号
     * @return java.lang.String[][]
     * @author wuguidong@cskaoyan.onaliyun.com
     */
    @Override
    public String[][] getResultByStuId(String stuId) {
        Student target = studentDao.getStudentByStuId(stuId);
        if (target == null) {
            return null;
        }
        return get2DStrArrByStudent(target);
    }

    /**
     * Swing表格中的数据,需要的是一个String类型二维数组,通过name去数据源查找学生信息,如果存在就返回一个String类型二维数组,不存在就返回null
     * 注意: 姓名不是唯一的,所以从数据源查出来的可能不只是一条数据,
     *      这时方法返回的二维数组的长度就不再一定是长度为1了.
     *
     * @since 12:10
     * @param name 被检索的name
     * @return java.lang.String[][]
     * @author wuguidong@cskaoyan.onaliyun.com
     */
    @Override
    public String[][] getResultByName(String name) {
        Student[] target = studentDao.getStudentByName(name);
        if (target == null) {
            return null;
        }
        return get2DStrArrByStudentArr(target);
    }

    /**
     * 更新表格某一行某一列，即某个单元格的具体数据
     *      更新成功返回true，否则返回false
     * @since 21:53
     * @param targetStuId 目标id
     * @param targetCol 目标列
     * @param newValue 目标值
     * @return boolean
     * @author wuguidong@cskaoyan.onaliyun.com
     */
    @Override
    public boolean updateCellByStuId(String targetStuId, int targetCol, String newValue) {
        // 获取id失败,直接更新失败
        if (targetStuId == null) {
            return false;
        }
        return studentDao.updateStuFieldByStuId(targetStuId, targetCol, newValue);
    }

    /**
     * 通过id直接修改一条学生信息,相当于用一个对象替换原先的对象
     * 方法返回一个int状态值表示结果:
     *     -1: 表示系统错误
     *      0: 表示成功修改
     *      1: 表示数据完全一致,禁止修改
     *      2: 未找到该学生,修改失败
     * @since 12:19
     * @param targetStuId 目标id
     * @param stu 新的学生对象
     * @return boolean
     * @author wuguidong@cskaoyan.onaliyun.com
     */
    @Override
    public int updateStudentByStuId(String targetStuId, Student stu) {
        if (targetStuId == null || "".equals(targetStuId) || stu == null) {
            // 学号未获取,学生信息获取失败等系统问题
            return -1;
        }
        // 返回值状态和dao层一致
        return studentDao.updateStudentByStuId(targetStuId, stu);
    }

    /*
     *
     * 创建日期：2021/12/27 16:44
     * @return void
     * @author 景天
     */
    @Override
    public boolean saveDataToFile() {
        return studentDao.saveDataToFile();
    }

    /**
     * 将一个学生对象转换成表格需要的一条数据,即只有一个元素的二维数组
     * @since 20:39
     * @param stu 目标学生对象
     * @return java.lang.String[][]
     * @author wuguidong@cskaoyan.onaliyun.com
     */
    private String[][] get2DStrArrByStudent(Student stu) {
        return new String[][]{{
                stu.getStuId(), stu.getName(), stu.getGender(), stu.getSchool(), stu.getMajor(), stu.getAge(), stu.getCity(), stu.getPhone(), stu.getEmail()}};
    }


    /**
     * 将一个学生对象数组转换成表格需要的数据,即该学生对象数组长度的一个二维数组
     * @since 12:21
     * @param stus 目标学生数组
     * @return java.lang.String[][]
     * @author wuguidong@cskaoyan.onaliyun.com
     */
    private String[][] get2DStrArrByStudentArr(Student[] stus) {
        // 获取结果二维数组的长度
        String[][] result = new String[stus.length][];
        // 遍历二维数组并赋值
        /*
            赋值很简单,因为这个二维数组的长度一定是学生数组的长度
            并且每个String数组的长度一定是表格的列数,也是固定的
            每个String数组的内容也是固定的
         */
        for (int i = 0; i < result.length; i++) {
            Student aStu = stus[i];
            result[i] = new String[]{
                    aStu.getStuId(), aStu.getName(), aStu.getGender(), aStu.getSchool(), aStu.getMajor(), aStu.getAge(), aStu.getCity(), aStu.getPhone(), aStu.getEmail()};
        }
        return result;
    }

}
