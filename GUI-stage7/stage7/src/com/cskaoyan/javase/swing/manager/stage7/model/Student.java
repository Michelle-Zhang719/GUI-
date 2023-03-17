package com.cskaoyan.javase.swing.manager.stage7.model;

import java.io.Serializable;

/**
 * 学生实体类
 * @since 10:00
 * @author wuguidong@cskaoyan.onaliyun.com
 */

public class Student implements Serializable {

    // 学号
    private String stuId;
    // 姓名
    private String name;
    // 性别
    private String gender;
    // 学校
    private String school;
    // 专业
    private String major;
    // 年龄
    private String age;
    // 城市
    private String city;
    // 电话
    private String phone;
    // 邮箱
    private String email;


    public Student() {
        super();
    }

    public Student(String stuId, String name, String gender, String school, String major, String age, String city, String phone, String email) {
        this.stuId = stuId;
        this.name = name;
        this.gender = gender;
        this.school = school;
        this.major = major;
        this.age = age;
        this.city = city;
        this.phone = phone;
        this.email = email;
    }

    @Override
    public String toString() {
        return
                "stuId=" + stuId +
                ",name=" + name +
                ",gender=" + gender +
                ",school=" + school +
                ",major=" + major +
                ",age=" + age +
                ",city=" + city +
                ",phone=" + phone +
                ",email=" + email ;
    }

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (getStuId() != null ? !getStuId().equals(student.getStuId()) : student.getStuId() != null) return false;
        if (getName() != null ? !getName().equals(student.getName()) : student.getName() != null) return false;
        if (getGender() != null ? !getGender().equals(student.getGender()) : student.getGender() != null) return false;
        if (getSchool() != null ? !getSchool().equals(student.getSchool()) : student.getSchool() != null) return false;
        if (getMajor() != null ? !getMajor().equals(student.getMajor()) : student.getMajor() != null) return false;
        if (getAge() != null ? !getAge().equals(student.getAge()) : student.getAge() != null) return false;
        if (getCity() != null ? !getCity().equals(student.getCity()) : student.getCity() != null) return false;
        if (getPhone() != null ? !getPhone().equals(student.getPhone()) : student.getPhone() != null) return false;
        return getEmail() != null ? getEmail().equals(student.getEmail()) : student.getEmail() == null;
    }

    @Override
    public int hashCode() {
        int result = getStuId() != null ? getStuId().hashCode() : 0;
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getGender() != null ? getGender().hashCode() : 0);
        result = 31 * result + (getSchool() != null ? getSchool().hashCode() : 0);
        result = 31 * result + (getMajor() != null ? getMajor().hashCode() : 0);
        result = 31 * result + (getAge() != null ? getAge().hashCode() : 0);
        result = 31 * result + (getCity() != null ? getCity().hashCode() : 0);
        result = 31 * result + (getPhone() != null ? getPhone().hashCode() : 0);
        result = 31 * result + (getEmail() != null ? getEmail().hashCode() : 0);
        return result;
    }
}
