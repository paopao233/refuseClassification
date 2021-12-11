package com.parklot.service.impl;

import cn.hutool.http.HttpUtil;
import com.parklot.common.constant.SearchConstant;
import com.parklot.common.utils.JsonUtil;
import com.parklot.service.ClassificationService;
import com.parklot.service.SearchService;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ClassName SearchServiceImpl
 * Description TODO
 * Author lezi
 * Date 2021/11/24 12:34
 * Version 1.0
 **/

/**
 * 首页搜索的Service
 */
@Service
public class SearchServiceImpl implements SearchService {
    @Autowired
    private ClassificationService classificationService;

    @Override
    public String getSearchContent(String content) {
        String result = null;
        //优先查询数据库 数据库没有再调用大数据
        result = classificationService.queryClassificationByName(content);
        if (StringUtils.isEmpty(result)){
            //api1查询
            result = api1(content);
            if (StringUtils.isEmpty(result)) {
                //进行下一步操作

            }
        }

        return result;
    }

    /**
     * api1
     *
     * @return
     */
    public String api1(String content) {
        String url = "https://v2.alapi.cn/api/garbage";
        String token = ""; //token请到alapi.cn申请
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("token", token);
        paramMap.put("name", content);
        paramMap.put("page", 1);
        String getResult = HttpUtil.get(url, paramMap);
        String code = JsonUtil.getJsonValue(getResult, "code");
        String result = null;
        if ("200".equals(code)) {
            String type = JsonUtil.getJsonValue(getResult, "data[0].type");
            switch (type) {
                case "1": {
                    result = SearchConstant.recyclableWaste;
                    break;
                }
                case "2": {
                    result = SearchConstant.hazardousWaste;
                    break;
                }
                case "3": {
                    result = SearchConstant.kitchenWaste;
                    break;
                }
                case "4": {
                    result = SearchConstant.otherGarbage;
                    break;
                }
            }
        }
        return result;
    }

    /**
     * api2
     *
     * @return
     */
    public String api2() {

        return null;
    }

    /**
     * api3
     *
     * @return
     */
    public String api3() {

        return null;
    }
}
