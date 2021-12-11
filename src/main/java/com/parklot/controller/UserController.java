package com.parklot.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.parklot.entity.Classification;
import com.parklot.entity.LoginLog;
import com.parklot.entity.User;
import com.parklot.service.ClassificationService;
import com.parklot.service.LoginLogService;
import com.parklot.service.UserService;
import com.parklot.vo.UserVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author ale
 * @since 2021-11-24
 */
@Slf4j
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private LoginLogService loginLogService;

    @Autowired
    private ClassificationService classificationService;

    /**
     * 注册用户
     */
    @RequestMapping("/createUser")
    public String createUser(@ModelAttribute("userVO") UserVo userVo, Model model) {
        User user = new User();
        if (!userVo.getPassword().equals(userVo.getRePassword())) {
            log.info("[{}]两次密码不一致！", user.getUsername());
            model.addAttribute("msg1", "两次密码不一致！请重新输入！");
            model.addAttribute("msgCode1", 400);
            return "signup.html";
        }

        user.setUsername(userVo.getUsername());
        user.setPassword(userVo.getPassword());
        user.setEmail(userVo.getEmail());

        user.setStatus("可用");

        //判断当前用户是否存在
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("username", userVo.getUsername());
        User one = userService.getOne(userQueryWrapper);
        if (one != null) {
            log.info("[{}]已经存在！", user.getUsername());
            model.addAttribute("msg1", "当前用户名已经存在数据库，请重新输入！");
            model.addAttribute("msgCode1", 400);
            return "signup.html";
        }

        //开始注册
        //啊乐做的好累啊啊啊啊
        int userDB = userService.createUser(user);
        if (userDB < 1) {
            log.info("用户[{}]注册失败了！", user.getUsername());
            model.addAttribute("msg1", "注册失败啦！请联系管理员！");
            model.addAttribute("msgCode1", 500);
            return "signup.html";
        }

        model.addAttribute("msg1", "亲爱的" + userVo.getUsername() + "，你已经注册成功啦！快登录把！");
        model.addAttribute("msgCode1", 200);

        log.info("用户[{}]注册成功！", user.getUsername());

        return "login.html";
    }

    /**
     * 注册用户
     * 2021年11月27日 19点44分
     */
    @RequestMapping("/login")
    public String login(@ModelAttribute("userVO") UserVo userVo, Model model, HttpSession session) {
        LoginLog loginLog = new LoginLog();
        User user = null;

        if (session.getAttribute("user") == null) {
            if (StringUtils.isEmpty(userVo.getUsername()) && StringUtils.isEmpty(userVo.getPassword())) {
                model.addAttribute("msg1", "用户名或者密码为空，请检查后再输入！");
                model.addAttribute("msgCode1", 500);
                return "login.html";
            }

            QueryWrapper<User> loginWrapper = new QueryWrapper<>();
            loginWrapper.eq("username", userVo.getUsername());
            loginWrapper.eq("password", userVo.getPassword());
            user = userService.getOne(loginWrapper);

            if (user == null) {
                log.info("用户[{}]登录失败了！用户不存在", userVo.getUsername());
                model.addAttribute("msg1", "登录失败，用户名或者密码错误。或者本系统没有存在你的信息，请先注册！");
                model.addAttribute("msgCode1", 500);
                return "login.html";
            }

            //这个把登录记录记录到数据库
            //ip固定为127.0.0.1
            loginLog.setIp("127.0.0.1");
            loginLog.setStatus("登录成功");
            loginLog.setUsername(userVo.getUsername());
            loginLog.setLoginTime(LocalDateTime.now());
            loginLogService.save(loginLog);

            session.setAttribute("user", user);
            //TODO 更新最后登录时间

        }
        user = (User) session.getAttribute("user");

        //查询最近的登录记录
        List<LoginLog> loginLogs = loginLogService.queryLoginLog(15);
        if (loginLogs.size() >= 1) {
            model.addAttribute("loginList", loginLogs);
//            loginLogs.forEach(System.out::println);
        }

        //查询最近词条添加记录
        List<Classification> classifications = classificationService.queryAllClassification();
        if (classifications.size() >= 1) {
            model.addAttribute("classifications", classifications);
        }

        //查询后台所需要的记录 管理员人数等等
        Map<String, Object> dashboardMap = loginLogService.queryDashboard();
//        dashboardMap.entrySet().forEach(System.out::println);

        model.addAttribute("msg1", "欢迎您，亲爱的" + userVo.getUsername());
        model.addAttribute("msgCode1", 200);


        model.addAttribute("dashboardMap", dashboardMap);
        model.addAttribute("active", "dashboard");

        log.info("用户[{}]登录成功！", user.getUsername());

        return "admin/index.html";
    }

    /**
     * 退出登录
     *
     */
    @RequestMapping("logout")
    public String logout(Model model,HttpSession session){
        //有点没有完善 不知道怎么跳转到上一级目录的
        User user = (User) session.getAttribute("user");
        if (user != null){
            session.removeAttribute("user");
        }
        model.addAttribute("msg1", "您已经成功退出！");
        model.addAttribute("msgCode1", 200);
        return "index.html";
    }
}
