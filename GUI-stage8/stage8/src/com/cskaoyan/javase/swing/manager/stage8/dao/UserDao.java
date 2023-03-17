package com.cskaoyan.javase.swing.manager.stage8.dao;

/**
 * 与管理员用户相关的，数据操作相关接口
 *
 * @since 19:35
 * @author wuguidong@cskaoyan.onaliyun.com
 */
public interface UserDao {

    // 通过用户名检查用户是否存在
    boolean checkUserExist(String username);

    // 通过用户名查找到对应密码
    String getPassByUsername(String username);

}
