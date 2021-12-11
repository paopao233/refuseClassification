package com.parklot.controller;

import com.parklot.entity.Classification;
import com.parklot.entity.User;
import com.parklot.service.ClassificationService;
import com.parklot.service.SearchService;
import com.parklot.vo.SearchVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * ClassName SearchController
 * Description TODO
 * Author lezi
 * Date 2021/11/24 13:55
 * Version 1.0
 **/

/**
 * 搜索的垃圾分类的controller
 */
@Controller
@RequestMapping("/")
@Slf4j
public class SearchController {
    @Autowired
    private SearchService searchService;

    @Autowired
    private ClassificationService classificationService;

    /**
     * 传递Demo对象到Index页面，Index页面才能提交一个Bean到后台
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("addVO", new SearchVO());
        model.addAttribute("searchVO", new SearchVO());
        return "index.html";
    }

    /**
     * 得到搜索内容
     *
     * @param searchVO
     * @param model
     * @return
     */
    @GetMapping(value = "getSearchContent")
    public String getSearchContent(@ModelAttribute("searchVO") SearchVO searchVO, Model model) {
        String searchContent = searchService.getSearchContent(searchVO.getContent());
        model.addAttribute("searchContent", searchContent);
        model.addAttribute("searchKey", searchVO.getContent());
        log.info("本次搜索结果为：[{}]", searchVO.getContent() + "是" + searchContent);
        return "search.html";
    }

    /**
     * 添加搜索内容
     *
     * @param searchVO
     * @param model
     * @return
     */
    @GetMapping(value = "addSearchContent")
    public String addSearchContent(@ModelAttribute("searchVO") SearchVO searchVO, Model model, HttpSession session) {
        Classification classification = new Classification();

        //获取登录的用户名
        User user = (User) session.getAttribute("user");
        if (user == null) {
            model.addAttribute("msg1", "你还没有登录哦，请先登录后在提交！");
            model.addAttribute("msgCode1", 400);
            return "search.html";
        }

        //获取提交的内容
        String addContent = searchVO.getAddContent();
        String[] contentSplit = addContent.split("属于");
        if (contentSplit.length == 0) {
            model.addAttribute("msg1", "请严格按照格式提交，格式为：XXX属于XXX垃圾！");
            model.addAttribute("msgCode1", 400);
            return "search.html";
        }
        String rubbish = contentSplit[0];
        String belongTo = contentSplit[1];


        //已经登录了就开始往数据库塞东西
        classification.setContent(rubbish);
        classification.setBelongto(belongTo);
        classification.setBywho(user.getUsername());
        classification.setStatus("可用");
        int insertOfRow = classificationService.addClassification(classification);
        if (insertOfRow < 1) {
            model.addAttribute("msg1", "添加失败，请联系管理员！");
            model.addAttribute("msgCode1", 400);
        }

        if (insertOfRow < 1) {
            model.addAttribute("msg1", "添加成功，请重新尝试搜索吧！");
            model.addAttribute("msgCode1", 200);
        }

        log.info("用户[{}]添加了垃圾分类词库：[{}]", user.getUsername(), addContent);
        return "search.html";
    }
}
