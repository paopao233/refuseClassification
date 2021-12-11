package com.parklot.common.utils;

import com.alibaba.fastjson.JSON;
import org.springframework.util.StringUtils;


/**
 * Description:
 *
 * @author honghh
 * Date 2020/08/18 14:42
 * Copyright (C) Harry技术
 */
public class JsonUtil {
    /**
     * 将json格式化为字符串，然后根据key取值
     * 格式 ：data.item_info.url
     *       item_list[0].video.play_addr.url_list[0]
     *
     * @param jsonStr
     * @param key
     * @return
     */
    public static String getJsonValue(String jsonStr, String key) {
        if (StringUtils.isEmpty(jsonStr) || StringUtils.isEmpty(key)) {
            return "";
        }
        if (!key.contains(".")) {
            if (key.contains("[")) {
                int num = Integer.parseInt(TextUtil.getSubString(key, "[", "]"));
                key = key.substring(0, key.indexOf("["));
                return JSON.parseObject(jsonStr).getJSONArray(key).getString(num);
            } else {
                return JSON.parseObject(jsonStr).getString(key);
            }
        } else {
            String[] keys = key.split("\\.");
            for (String s : keys) {
                String tempKey = s;
                if (tempKey.contains("[")) {
                    int num = Integer.parseInt(TextUtil.getSubString(tempKey, "[", "]"));
                    tempKey = tempKey.substring(0, s.indexOf("["));
                    jsonStr = JSON.parseObject(jsonStr).getJSONArray(tempKey).getString(num);
                } else {
                    jsonStr = JSON.parseObject(jsonStr).getString(tempKey);
                }
            }
            return jsonStr;
        }

    }

}
