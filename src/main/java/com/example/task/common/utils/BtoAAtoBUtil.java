package com.example.task.common.utils;


import org.apache.log4j.Logger;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author zxy
 * @date 2020年8月24日 上午11:20:16
 * @Description :  字符串加密类 BtoA加密 AtoB解密
 */
public class BtoAAtoBUtil {

    private static Logger log = Logger.getLogger("BtoAAtoBUtil.class");

    private static String base64hash = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";

    public static boolean isMatcher(String inStr, String reg) {
        Pattern pattern = Pattern.compile(reg);
        Matcher matcher = pattern.matcher(inStr);
        if (matcher.matches()) {
            return true;
        }
        return false;
    }

    /**
     * btoa method 使用btoa加密 atob解密
     * @param inStr
     * @return
     */
    public static String btoa(String inStr) {

        if (inStr == null || isMatcher(inStr, "([^\\u0000-\\u00ff])")) {
            return null;
        }

        StringBuilder result = new StringBuilder();
        int i = 0;
        int mod = 0;
        int ascii;
        int prev = 0;
        while (i < inStr.length()) {
            ascii = inStr.charAt(i);
            mod = i % 3;
            switch (mod) {
                case 0:
                    result.append(String.valueOf(base64hash.charAt(ascii >> 2)));
                    break;
                case 1:
                    result.append(String.valueOf(base64hash.charAt((prev & 3) << 4 | (ascii >> 4))));
                    break;
                case 2:
                    result.append(String.valueOf(base64hash.charAt((prev & 0x0f) << 2 | (ascii >> 6))));
                    result.append(String.valueOf(base64hash.charAt(ascii & 0x3f)));
                    break;
            }
            prev = ascii;
            i++;
        }
        if (mod == 0) {
            result.append(String.valueOf(base64hash.charAt((prev & 3) << 4)));
            result.append("==");
        } else if (mod == 1) {
            result.append(String.valueOf(base64hash.charAt((prev & 0x0f) << 2)));
            result.append("=");
        }
        return result.toString();
    }

    /**
     * atob method  逆转encode的思路即可       使用btoa加密 atob解密
     * @param inStr
     * @return
     */
    public static String atob(String inStr) {
        if (inStr == null)
            return null;
        inStr = inStr.replaceAll("\\s|=", "");
        StringBuilder result = new StringBuilder();
        int cur;
        int prev = -1;
        int mod;
        int i = 0;
        while (i < inStr.length()) {
            cur = base64hash.indexOf(inStr.charAt(i));
            mod = i % 4;
            switch (mod) {
                case 0:
                    break;
                case 1:
                    result.append(String.valueOf((char) (prev << 2 | cur >> 4)));
                    break;
                case 2:

                    result.append(String.valueOf((char) ((prev & 0x0f) << 4 | cur >> 2)));
                    break;
                case 3:

                    result.append(String.valueOf((char) ((prev & 3) << 6 | cur)));
                    break;
            }
            prev = cur;
            i++;
        }
        return result.toString();
    }

    /**
     * 加密字符串
     * @return
     */
    public static String encryption(String str) {
        String encode;
        try {
            encode = URLEncoder.encode(str,"utf-8");
            encode=encode.replaceAll("\\+", "%20");//URLEncoder.encode 会将空格解释为+号
            String btoa = BtoAAtoBUtil.btoa(encode);
            return btoa;
        } catch (UnsupportedEncodingException e) {
            log.info("btoa加密函数出现错误。");
        }
        return str;
    }

    /**
     * 解密字符串
     * @return
     */
    public static String decrypt(String str) {
        String atob = BtoAAtoBUtil.atob(str);
        try {
            String decode = URLDecoder.decode(atob, "utf-8");
            return decode;
        } catch (UnsupportedEncodingException e) {
            log.info("atob加密函数出现错误。");
        }
        return str;
    }

}
