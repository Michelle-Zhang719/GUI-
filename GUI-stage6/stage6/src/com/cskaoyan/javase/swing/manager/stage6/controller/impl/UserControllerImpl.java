package com.cskaoyan.javase.swing.manager.stage6.controller.impl;

import com.cskaoyan.javase.swing.manager.stage6.controller.UserController;
import com.cskaoyan.javase.swing.manager.stage6.dao.UserDao;
import com.cskaoyan.javase.swing.manager.stage6.dao.impl.UserDaoImpl;
import com.cskaoyan.javase.swing.manager.stage6.model.User;

/**
 * 与管理员用户相关的,业务操作的实现
 * @since 20:18
 * @author wuguidong@cskaoyan.onaliyun.com
 */
public class UserControllerImpl implements UserController {

    // 业务处理需要获取数据,所以需要依赖数据处理层
    private UserDao userDao = new UserDaoImpl();

    /**
     * 判断能否登陆，返回一个int状态值
     * 其中：
     * 0，表示正常成功登陆
     * 1，表示用户不存在
     * 2，表示密码输入错误
     * @since 20:26
     * @param user 用户输入用户对象
     * @return int 登陆状态判断
     * @author wuguidong@cskaoyan.onaliyun.com
     */
    public int judgeLogin(User user) {
        String usernameInput = user.getUsername();
        String passwordInput = user.getPassword();
        if (!userDao.checkUserExist(usernameInput)) {
            // 说明用户不存在
            return 1;
        }
        // 用户存在，检查密码是否正确
        String realPass = userDao.getPassByUsername(usernameInput);
        if (!realPass.equals(passwordInput)) {
            // 密码错误
            return 2;
        }
        // 登陆成功
        return 0;
    }
}
