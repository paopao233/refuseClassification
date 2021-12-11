package com.parklot.common.utils;

import cn.hutool.core.map.MapUtil;
import cn.hutool.http.HttpUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;

/**
 * ClassName TextUtil
 * Description 文本操作工具类
 * Author lezi
 * Date 2021/7/6 11:59
 * Version 1.0
 **/
@Slf4j
public class TextUtil {

    public static final String UA = "Mozilla/5.0 (iPhone; CPU iPhone OS 13_2_3 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/13.0.3 Mobile/15E148 Safari/604.1";

    /**
     * 取两个文本之间的文本值
     *
     * @param text
     * @param left
     * @param right
     * @return
     */
    public static String getSubString(String text, String left, String right) {
        String result;
        int zLen;

        //左边
        if (left == null || left.isEmpty()) {
            zLen = 0;
        } else {
            zLen = text.indexOf(left);
            if (zLen > -1) {
                zLen += left.length();
            } else {
                //找不到
                zLen = 0;
            }
        }

        //右边
        int yLen = text.indexOf(right, zLen);
        if (yLen < 0 || right.isEmpty()) {
            yLen = text.length();
        }

        result = text.substring(zLen, yLen);
        return result;
    }

    /**
     * 获取重定向 URL
     *
     * @param url
     * @return
     */
    public static String redirectUrl(String url) {
        return HttpUtil.createGet(url).addHeaders(headers()).execute().header("Location");
    }

    /**
     * 模拟
     *
     * @return headers
     */
    public static HashMap<String, String> headers() {
        HashMap<String, String> headers = MapUtil.newHashMap();
        headers.put("User-Agent", UA);
        return headers;
    }
}
