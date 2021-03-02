package com.tech.movie.controller;

import com.tech.movie.common.SverResponse;
import com.tech.movie.pojo.User;
import com.tech.movie.dao.UserRepository;
import com.tech.movie.service.UserService;
import com.tech.movie.utils.ConstUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(path="/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 注册账户
     * @param user
     * @return
     */
    @PostMapping(path = "/do_register")
    public @ResponseBody SverResponse<String> doRegister (User user) {
        return userService.doRegister(user);
    }

    /**
     * 登陆账户
     * @param account
     * @param password
     * @param session
     * @return
     */
    @PostMapping(path = "do_login")
    public @ResponseBody SverResponse<User> doLogin(String account, String password, HttpSession session){
        SverResponse<User> response = userService.doLogin(account,password);
        if(response.isSuccess()) {
            //登陆成功，将用户信息存入session
            session.setAttribute(ConstUtil.CUR_USER, response.getData());
        }
        return response;
    }

    /**
     * 登出
     * @param session
     * @return
     */
    @PostMapping(path = "do_logout")
    public @ResponseBody SverResponse<String> logout(HttpSession session){
        User user = (User)session.getAttribute(ConstUtil.CUR_USER);
        if(user != null) {
            session.removeAttribute(ConstUtil.CUR_USER);
            return SverResponse.createRespBySuccess("登出成功");
        }
        return SverResponse.createByErrorMessage("请先登录");
    }

    /**
     * 获取本机已登录的用户信息
     * @param session
     * @return
     */
    @GetMapping(path = "/getuserlogin")
    public @ResponseBody SverResponse<User> getUserLogin(HttpSession session) {
        User user = (User)session.getAttribute(ConstUtil.CUR_USER);
        if (user == null){
            //未登录返回错误信息
            return SverResponse.createRespByError();
        }else{
            return SverResponse.createRespBySuccess(user);
        }
    }

    /**
     * 获取账户信息
     * @param info
     * @param type
     * @return
     */
    @PostMapping(path = "/getuserbyaccount")
    public @ResponseBody SverResponse<User> getUserByAccount(@RequestParam String info, @RequestParam String type){
        return userService.findUserByAccount(info, type);
    }

    /**
     * 修改用户个人资料
     * @param session
     * @param user
     * @return
     */
    @PostMapping(path = "updateuserinfo")
    public @ResponseBody SverResponse<User> updateUserInfo(HttpSession session,User user){
        User curUser = (User) session.getAttribute(ConstUtil.CUR_USER);
        if(curUser==null) {
            return SverResponse.createByErrorMessage("用户尚未登录！");
        }
        user.setId(curUser.getId());
        user.setAccount(curUser.getAccount());
        SverResponse<User> resp = userService.updateUserInfo(user);
        if(resp.isSuccess()) {
            //重写session
            session.setAttribute(ConstUtil.CUR_USER, resp.getData());
        }
        return resp;
    }

    /**
     * 登录用户修改密码
     * @param session
     * @param newpwd
     * @param oldpwd
     * @return
     */
    @PostMapping(path = "updatepassword")
    public @ResponseBody SverResponse<String> updatePassword(HttpSession session, String newpwd, String oldpwd){
        //将我们的session取出
        User user = (User) session.getAttribute(ConstUtil.CUR_USER);
        if(user==null) {
            return SverResponse.createByErrorMessage("请登录后在修改密码！");
        }
        SverResponse<String> result = userService.updatePassword(user,newpwd,oldpwd);
        //修改之后清空session，准备重新登录
        if(result.isSuccess()) {
            session.removeAttribute(ConstUtil.CUR_USER);
        }
        return result;
    }

}