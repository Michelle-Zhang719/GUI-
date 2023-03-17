package com.cskaoyan.javase.swing.manager.stage6.controller;

import com.cskaoyan.javase.swing.manager.stage6.model.User;

/**
 * 与管理员用户相关的,业务操作接口
 * @since 19:27
 * @author wuguidong@cskaoyan.onaliyun.com
 */
public interface UserController {
    // 根据输入的用户，判断能否成功登陆
    int judgeLogin(User user);
}
