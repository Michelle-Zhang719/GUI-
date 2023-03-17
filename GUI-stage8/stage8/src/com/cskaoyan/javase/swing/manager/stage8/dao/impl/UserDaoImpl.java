package com.cskaoyan.javase.swing.manager.stage8.dao.impl;

import com.cskaoyan.javase.swing.manager.stage8.dao.UserDao;
import com.cskaoyan.javase.swing.manager.stage8.model.User;
import com.cskaoyan.javase.swing.manager.stage8.model.UserData;

/**
 * 与管理员用户相关的，所有数据处理都在该类下进行
 *
 * @since 19:36
 * @author wuguidong@cskaoyan.onaliyun.com
 */
public class UserDaoImpl implements UserDao {

    // 从数据源获取数据
    private  User[] users = UserData.USERS;

    /**
     * 为了避免空指针异常，排除数组中为null的元素
     * @since 20:01
     * @return com.cskaoyan.javase.swing.manager.stage5.model.User[]
     * @author wuguidong@cskaoyan.onaliyun.com
     */
    private User[] getRealUsers() {
        // 用于记录真实用户个数
        int count = 0;
        for (User user : users) {
            if (user != null) {
                count++;
            }
        }
        User[] result = new User[count];
        int index = 0;
        for (User user : users) {
            if (user != null) {
                result[index] = user;
            }
            index++;
        }
        return result;
    }


    /**
     * 校验用户输入的用户名是否存在
     * @since 20:16
     * @param username 输入框输入的用户名
     * @return boolean true表示存在，反之不存在
     * @author wuguidong@cskaoyan.onaliyun.com
     */
    @Override
    public boolean checkUserExist(String username) {
        User[] realUsers = this.getRealUsers();
        for (User realUser : realUsers) {
            if (realUser.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 当用户名存在时，从数据源获取密码
     * @since 1:45
     * @param username 登陆输入框输入的用户
     * @return java.lang.String 已经判断用户名存在了，返回值不会是null
     * @author wuguidong@cskaoyan.onaliyun.com
     */
    @Override
    public String getPassByUsername(String username) {
        User[] realUsers = this.getRealUsers();
        String resultPass = null;
        for (User realUser : realUsers) {
            if (realUser.getUsername().equals(username)) {
                resultPass = realUser.getPassword();
            }
        }
        return resultPass;
    }
}
