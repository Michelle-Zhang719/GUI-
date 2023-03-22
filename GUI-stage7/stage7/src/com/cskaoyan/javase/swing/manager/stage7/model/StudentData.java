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
    public static File studentFile = new File("GUI-stage7/stage7/students2.txt");
    static {
        // 初始化 读取文件
        init();

        // 表格列数据
        COLUMNS = new String[]{"学号", "姓名", "性别", "学校", "专业", "年龄", "城市", "手机号", "电子邮箱"};
    }


    /**
     * 进行初始化操作  通过对象流去反序列化为对象信息 填充到内存中数组
     * @return void
     * @author MinjieZhang
     * @date 2023/03/22 15:09
     */
    private static void init() {
        ObjectInputStream in = null;
        try {
            if (studentFile.length() != 0) {
                //文件不为空
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
