package com.parklot.controller;

import com.parklot.entity.Classification;
import com.parklot.entity.LoginLog;
import com.parklot.entity.User;
import com.parklot.service.ClassificationService;
import com.parklot.service.LoginLogService;
import com.parklot.service.UserService;
import com.parklot.vo.SearchVO;
import com.parklot.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Map;

/**
 * ClassName ViewController
 * Description TODO
 * Author lezi
 * Date 2021/11/24 12:09
 * Version 1.0
 **/
@Controller
public class ViewController {
    @Autowired
    private LoginLogService loginLogService;

    @Autowired
    private ClassificationService classificationService;

    @Autowired
    private UserService userService;
    /**
     *前台相关的
     */

    @RequestMapping("")
    public String toIndex(Model model){
        SearchVO searchVO = new SearchVO();
        model.addAttribute("addVO", searchVO);
        return "index.html";
    }

    //登录
    @RequestMapping("toLoginPage")
    public String toLoginPage(Model model){
        UserVo userVo = new UserVo();
        model.addAttribute("userVO",userVo);
        return "login.html";
    }

    //首页
    @RequestMapping("toIndexPage")
    public String toIndexPage(Model model){
        model.addAttribute("addVO", new SearchVO());
        model.addAttribute("searchVO", new SearchVO());
        return "index.html";
    }

    //注册
    @RequestMapping("toSignUpPage")
    public String toSignUpPage(Model model){
        UserVo userVo = new UserVo();
        model.addAttribute("userVO",userVo);
        return "signup.html";
    }

    //关于
    @RequestMapping("toAboutPage")
    public String toAboutPage(){
        return "about.html";
    }


    /**
     * 后台相关的
     */
    //到后台
    @RequestMapping("toDashboard")
    public String toDashboard(Model model){
        //查询登录记录
        List<LoginLog> loginLogs = loginLogService.queryLoginLog(15);
        if (loginLogs.size() >= 1){
            model.addAttribute("loginList", loginLogs);
        }

        //查询最近词条添加记录
        List<Classification> classifications = classificationService.queryAllClassification();
        if (classifications.size() >=1 ){
            model.addAttribute("classifications", classifications);
        }

        //查询后台所需要的记录 管理员人数等等
        Map<String, Object> dashboardMap = loginLogService.queryDashboard();

        model.addAttribute("dashboardMap",dashboardMap);

        //加一个model好识别是dashboard
        model.addAttribute("active", "dashboard");
        return "admin/index.html";
    }

    /**
     * 到所有用户管理界面
     */
    @RequestMapping("toUser")
    public String toUser(Model model){
        model.addAttribute("active", "allUser");

        List<User> users = userService.queryAllUser();
        if (users.size() >= 1){
            model.addAttribute("userList", users);
//            users.forEach(System.out::println);
        }
        return "admin/all-user.html";
    }

    /**
     * 到添加用户管理界面
     */
    @RequestMapping("toAddUser")
    public String toAddUser(Model model){
        model.addAttribute("active", "allUser");

        return "admin/add-new-user.html";
    }

    /**
     * 到用户登录记录
     */
    @RequestMapping("toAllLoginInfo")
    public String toAllLoginInfo(Model model){
        //查询最近的登录记录
        List<LoginLog> loginLogs = loginLogService.queryLoginLog(200);
        if (loginLogs.size() >= 1){
            model.addAttribute("loginList", loginLogs);
//            loginLogs.forEach(System.out::println);
        }

        model.addAttribute("active", "loginInfo");
        return "admin/all-loginInfo.html";
    }

    /**
     * 到所有垃圾分类词条管理页面
     */
    @RequestMapping("toAllClassification")
    public String toAllClassification(Model model){
        model.addAttribute("active", "classification");

        //查询最近词条添加记录
        List<Classification> classifications = classificationService.queryAllClassification();
        if (classifications.size() >=1 ){
            model.addAttribute("classifications", classifications);
        }

        return "admin/all-classification.html";
    }

    /**
     * 到添加垃圾分类词条管理页面
     */
    @RequestMapping("toAddClassification")
    public String toAddClassification(Model model){
        model.addAttribute("active", "classification");
        return "admin/add-new-classification.html";
    }

    /**
     * 跳转到个人信息修改页面
     */
    @RequestMapping("toEditProfile")
    public String toEditProfile(Model model){
        model.addAttribute("active", "editProfile");
        return "admin/edit-profile.html";
    }

    /**
     * 跳转到密码修改页面
     */
    @RequestMapping("toChangePassword")
    public String toChangePassword(Model model){
        model.addAttribute("active", "editProfile");
        return "admin/password-change.html";
    }
}
