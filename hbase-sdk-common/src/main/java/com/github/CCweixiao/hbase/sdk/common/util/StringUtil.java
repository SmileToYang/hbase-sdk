package com.github.CCweixiao.hbase.sdk.common.util;

import cn.hutool.core.util.StrUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * string util
 *
 * @author leo.jie (weixiao.me@aliyun.com)
 */
public class StringUtil extends StrUtil {
    /**
     * 驼峰命名法转换为下划线
     *
     * @param camelCaseName 驼峰命名法的字段名
     * @return 下划线字段名
     */
    public static String underscoreName(String camelCaseName) {
        StringBuilder builder = StringUtil.builder();
        if (isNotBlank(camelCaseName)) {
            builder.append(camelCaseName.substring(0, 1).toLowerCase());
            for (int i = 1; i < camelCaseName.length(); i++) {
                char ch = camelCaseName.charAt(i);
                if (Character.isUpperCase(ch)) {
                    builder.append("_");
                    builder.append(Character.toLowerCase(ch));
                } else {
                    builder.append(ch);
                }
            }
        }
        return builder.toString();
    }

    /**
     * 下划线命名转换为驼峰
     *
     * @param underscoreName 下划线字段名
     * @return 驼峰命名法
     */
    public static String camelCaseName(String underscoreName) {
        StringBuilder builder = StringUtil.builder();
        if (isNotBlank(underscoreName)) {
            boolean flag = false;
            for (int i = 0; i < underscoreName.length(); i++) {
                char ch = underscoreName.charAt(i);
                if ("_".charAt(0) == ch) {
                    flag = true;
                } else {
                    if (flag) {
                        builder.append(Character.toUpperCase(ch));
                        flag = false;
                    } else {
                        builder.append(ch);
                    }
                }
            }
        }
        return builder.toString();
    }

    public static Map<String, String> parsePropertyToMapFromStr(String prop) {
        if (isBlank(prop)) {
            return new HashMap<>(0);
        }
        Map<String, String> property = new HashMap<>(4);
        for (String p : prop.split(";")) {
            if (isBlank(p)) {
                continue;
            }
            if (!p.contains("=")) {
                continue;
            }
            String[] ps = p.split("=");
            if (ps.length == 2) {
                property.put(ps[0], ps[1]);
            }
        }
        return property;
    }

    public static String leftPad(String str, int size, char padChar) {
        if (str == null) {
            return null;
        } else {
            int pads = size - str.length();
            if (pads <= 0) {
                return str;
            } else {
                return pads > 8192 ? leftPad(str, size, String.valueOf(padChar)) : repeat(padChar, pads).concat(str);
            }
        }
    }

    public static String repeat(char ch, int repeat) {
        if (repeat <= 0) {
            return "";
        } else {
            char[] buf = new char[repeat];

            for (int i = repeat - 1; i >= 0; --i) {
                buf[i] = ch;
            }

            return new String(buf);
        }
    }

    public static String leftPad(String str, int size, String padStr) {
        if (str == null) {
            return null;
        } else {
            if (isEmpty(padStr)) {
                padStr = " ";
            }

            int padLen = padStr.length();
            int strLen = str.length();
            int pads = size - strLen;
            if (pads <= 0) {
                return str;
            } else if (padLen == 1 && pads <= 8192) {
                return leftPad(str, size, padStr.charAt(0));
            } else if (pads == padLen) {
                return padStr.concat(str);
            } else if (pads < padLen) {
                return padStr.substring(0, pads).concat(str);
            } else {
                char[] padding = new char[pads];
                char[] padChars = padStr.toCharArray();

                for (int i = 0; i < pads; ++i) {
                    padding[i] = padChars[i % padLen];
                }

                return (new String(padding)).concat(str);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(isBlank("a dbc"));
        System.out.println(parsePropertyToMapFromStr("test=12=239;key=23;"));
    }
}
