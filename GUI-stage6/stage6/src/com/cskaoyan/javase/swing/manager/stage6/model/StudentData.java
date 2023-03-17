package com.cskaoyan.javase.swing.manager.stage6.model;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * 模拟学生数据源
 *
 * @since 14:09
 * @author wuguidong@cskaoyan.onaliyun.com
 */
public class StudentData {
    public static final Student[] STUDS = new Student[20];
    public static final String[] COLUMNS;
    private static int count;
    // 创建文件对象作为数据源,读写这个students.txt文件
    public static File studentFile = new File("students.txt");
    static {
        // 初始化 读取文件
        init();
        // 表格列数据
        COLUMNS = new String[]{"学号", "姓名", "性别", "学校", "专业", "年龄", "城市", "手机号", "电子邮箱"};
    }

    /*
     * 初始化操作 读取文件 按行读取,一行就是一个学生对象 , 再还原回学生对象
     * 创建日期：2021/12/27 21:04
     * @return void
     * @author 景天
     */
    private static void init() {
        // TODO 代码补全
    }
}
