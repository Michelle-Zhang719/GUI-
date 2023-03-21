package com.cskaoyan.javase.swing.manager.stage6.model;


import java.io.*;
import java.util.Arrays;

/**
 * 模拟学生数据源
 *
 * @author wuguidong@cskaoyan.onaliyun.com
 * @since 14:09
 */
public class StudentData {
    public static final Student[] STUDS = new Student[20];
    public static final String[] COLUMNS;
    private static int count;
    // 创建文件对象作为数据源,读写这个students.txt文件
    public static File studentFile = new File("students.txt");

    static {
        // 初始化 读取文件
        try {
            init();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 表格列数据
        COLUMNS = new String[]{"学号", "姓名", "性别", "学校", "专业", "年龄", "城市", "手机号", "电子邮箱"};
    }


    /**
     * 初始化操作 读取文件 按行读取,一行就是一个学生对象 , 再还原回学生对象
     * @return void
     * @author MinjieZhang
     * @date 2023/03/21 11:00
     */
    private static void init() throws IOException {
        //创建字符输入流对象
        BufferedReader in = new BufferedReader(new FileReader("GUI-stage6/stage6/students.txt"));
        //可变字符串
        StringBuilder sb = new StringBuilder();
        //循环读，一次读一行
        String line;
        while ((line = in.readLine()) != null) {
            sb.append(line);
            sb.append("；");
        }
        String newStr = sb.toString();
        String[] studentNum = newStr.split("；");
        //分开了
//        for (String s : studentNum) {
//            System.out.println(s);
//        }

        //外层循环，学生信息个数
        for (int i = 0; i < studentNum.length; i++) {
            String str = studentNum[i].toString();
            String[] s = str.split(",");
            //内层循环，赋值，使用student构造方法
            for (int j = 0; j < s.length; j++) {

                //专业和学校可以为空
                if (s[3]==null||"".equals(s[3])){
                    s[3] = " ";
                }
                if (s[4]==null||"".equals(s[4])){
                    s[4] = " ";
                }
                STUDS[i] = new Student(s[0].substring(6),s[1].substring(5),s[2].substring(7),s[3].substring(7),
                        s[4].substring(6),s[5].substring(4),s[6].substring(5),s[7].substring(6),s[8].substring(6));
            }
        }
    }
}
