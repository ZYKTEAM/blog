package com.myblog.entity;


import com.baomidou.mybatisplus.annotations.TableName;
import com.myblog.common.enums.LoginTypeEnum;

/**
 * @author:zyk
 * @Description: 用户表
 * @Date:Create in 10:50 2017/11/22
 * @Modified By:
 **/
@TableName("t_blog_user")
public class UserEntity extends BaseEntity {


    private String username;
    private String password;
    // 用户唯一身份识别 ID
    private String openId;

    /**
     * 登录类型 {@link LoginTypeEnum}
     */
    private String loginType;

    // 昵称
    private String nickName;

    // 头像
    private String avatar;

    // 性别
    private String gender;

    // 其他信息
    private String meta;

    // 用户信息 MD5 值，用于校验用户信息是否休息
    private String md5;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getLoginType() {
        return loginType;
    }

    public void setLoginType(String loginType) {
        this.loginType = loginType;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMeta() {
        return meta;
    }

    public void setMeta(String meta) {
        this.meta = meta;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }
}
