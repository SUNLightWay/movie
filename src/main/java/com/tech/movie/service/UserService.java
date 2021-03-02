package com.tech.movie.service;

import com.tech.movie.common.SverResponse;
import com.tech.movie.dao.UserRepository;
import com.tech.movie.pojo.User;
import com.tech.movie.service.impl.UserServiceImpl;
import com.tech.movie.utils.ConstUtil;
import com.tech.movie.utils.MD5Util;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserService implements UserServiceImpl {

    @Autowired
    private UserRepository userRepository;

    @Override
    public SverResponse<String> doRegister(User user) {
        //检查用户名是否存在
        SverResponse<String> resp = checkValidation(user.getAccount(), ConstUtil.TYPE_ACCOUNT);
        if(!resp.isSuccess()) {
            return resp;
        }
        //检查邮箱是否被注册
        resp = checkValidation(user.getEmail(),ConstUtil.TYPE_EMAIL);
        if(!resp.isSuccess()) {
            return resp;
        }
        //指定用户角色，通过前端注册的用户都为客户
        user.setRole(ConstUtil.RoleType.ROLE_USER);
        //密码加密
        user.setPassword(MD5Util.MD5Encode(user.getPassword(), "utf-8", false));

        User userReturned = userRepository.save(user);

        if (userReturned == null){
            return SverResponse.createByErrorMessage("注册失败！");
        } else {
            return SverResponse.createRespBySuccessMessage("注册成功！");
        }
    }

    @Override
    public SverResponse<String> checkValidation(String str, String type) {
        //判断我们的字符串不为空 type
        if(StringUtils.isNotBlank(type)) {
            if(ConstUtil.TYPE_ACCOUNT.equals(type)) {
                User user = userRepository.findByAccount(str);
                if(user != null) {
                    return SverResponse.createByErrorMessage("用户名已经存在");
                }
            }
            if(StringUtils.isNotBlank(type)) {
                if(ConstUtil.TYPE_EMAIL.equals(type)) {
                    User user = userRepository.findByEmail(str);
                    if(user != null) {
                        return SverResponse.createByErrorMessage("Email已经存在");
                    }
                }
            }
            if(StringUtils.isNotBlank(type)) {
                if(ConstUtil.TYPE_PHONE.equals(type)) {
                    User user = userRepository.findByPhone(str);
                    if(user != null) {
                        return SverResponse.createByErrorMessage("电话号码已经存在");
                    }
                }
            }

        }else {
            return SverResponse.createByErrorMessage("信息验证类别错误！");
        }
        return SverResponse.createRespBySuccessMessage("信息验证成功！");
    }

    @Override
    public SverResponse<User> doLogin(String account, String password) {
        //获取该账户对象
        User user = userRepository.findByAccount(account);
        if (user == null){
            //不存在该用户
            return SverResponse.createByErrorMessage("用户不存在或密码不正确！");
        }
        String md5Pwd = MD5Util.MD5Encode(password, "utf-8", false);
        User user_check = userRepository.findByAccountAndPassword(account, md5Pwd);
        if (user_check == null){
            //密码错误
            return SverResponse.createByErrorMessage("用户不存在或密码不正确！");
        }
        //将密码置空，防止泄密，返回结果以及用户信息
        user.setPassword(StringUtils.EMPTY);
        return SverResponse.createRespBySuccess("登陆成功", user_check);
    }

    @Override
    public SverResponse<User> updateUserInfo(User user) {
        //避免save()时覆盖原有数据，先将表中对应数据取出进行修改，再写回关系数据库
        User userInRepo = userRepository.findByAccount(user.getAccount());
        if (user.getAccount() != null)
            userInRepo.setAccount(user.getAccount());
        if (user.getAge() != null)
            userInRepo.setAge(user.getAge());
        if (user.getEmail() != null)
            userInRepo.setEmail(user.getEmail());
        if (user.getName() != null)
            userInRepo.setName(user.getName());
        if (user.getPhone() != null)
            userInRepo.setPhone(user.getPhone());
        if (user.getRole() != null)
            userInRepo.setRole(user.getRole());
        if (user.getSex() != null)
            userInRepo.setSex(user.getSex());

        User userReturned = userRepository.save(userInRepo);
        if(userReturned != null) {
            return SverResponse.createRespBySuccess("用户信息修改成功！",userReturned);
        }
        //密码置空
        userReturned.setPassword(StringUtils.EMPTY);
        return SverResponse.createByErrorMessage("用户信息修改失败！");
    }

    @Override
    public SverResponse<String> updatePassword(User user, String newpwd, String oldpwd) {
        //防止越权，检测用户旧密码是否正确
        oldpwd = MD5Util.MD5Encode(oldpwd, "utf-8", false);
        User user_check = userRepository.findByAccountAndPassword(user.getAccount(), oldpwd);
        if(user_check == null) {
            return SverResponse.createByErrorMessage("原始密码错误！");
        }
        //将新密码插入数据库
        newpwd = MD5Util.MD5Encode(newpwd, "utf-8", false);
        user_check.setPassword(newpwd);
        User user_update = userRepository.save(user_check);
        if(user_update != null) {
            return SverResponse.createRespBySuccessMessage("密码修改成功！");
        }
        return SverResponse.createByErrorMessage("密码修改失败！");
    }

    @Override
    public SverResponse<String> isAdmin(User user) {
        if(user.getRole()==ConstUtil.RoleType.ROLE_ADMIN) {
            return SverResponse.createRespBySuccess();
        }
        return SverResponse.createRespByError();
    }

    @Override
    public SverResponse<User> findUserByAccount(String account, String type) {
        User user = null;
        switch (type){
            case ConstUtil.TYPE_ACCOUNT:
                user = userRepository.findByAccount(account);
                break;
            case ConstUtil.TYPE_EMAIL:
                user = userRepository.findByEmail(account);
                break;
        }
        if (user == null)
            return SverResponse.createRespByError();
        else{
            user.setPassword(StringUtils.EMPTY);
            return SverResponse.createRespBySuccess(user);
        }
    }

}
