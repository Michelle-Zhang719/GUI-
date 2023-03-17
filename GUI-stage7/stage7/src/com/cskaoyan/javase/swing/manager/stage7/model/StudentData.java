package com.cskaoyan.javase.swing.manager.stage7.model;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * 模拟学生数据源
 *
 * @since 14:09
 * @author wuguidong@cskaoyan.onaliyun.com
 */
public class StudentData {
    public static final Student[] STUDS = new Student[20];
    public static final String[] COLUMNS;
    // 创建文件对象作为数据源,读写这个students2.txt文件
    public static File studentFile = new File("students2.txt");
    static {
        // 初始化 读取文件
        init();

        // 表格列数据
        COLUMNS = new String[]{"学号", "姓名", "性别", "学校", "专业", "年龄", "城市", "手机号", "电子邮箱"};
    }

    /*
     * 进行初始化操作  通过对象流去反序列化为对象信息 填充到内存中数组
     * 创建日期：2021/12/27 20:52
     * @return void
     * @author 景天
     */
    private static void init() {
        // TODO 补全代码
    }

}
