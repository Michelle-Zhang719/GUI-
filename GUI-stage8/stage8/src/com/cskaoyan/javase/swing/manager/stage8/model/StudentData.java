package com.cskaoyan.javase.swing.manager.stage8.model;


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
    public static File studentFile = new File("students3.txt");
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
        ObjectInputStream in = null;
        try {
            // 判断文件是否为空 空就是第一次读取
            if (studentFile.length() != 0) {
                in = new ObjectInputStream(new FileInputStream(studentFile));
                // 先反序列化 读取学生数组 并遍历初始化
                Student[] students = (Student[]) in.readObject();
                for (int i = 0; i < students.length; i++) {
                    STUDS[i] = students[i];
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
