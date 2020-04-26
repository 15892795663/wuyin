package org.wuy.demo;

import com.sun.org.apache.regexp.internal.RE;

/**
 * @Title:
 * @Description: TODO
 * @Company:北京九恒星科技股份有限公司
 * @Author xiaolong
 * @Date 2020/4/3
 **/
public class StringToNum {
    public static void main(String[] args) {
        System.out.println(stringToNum("2147483648"));
    }

    private static int stringToNum(String str) {
        str = str.trim();
        if (str == null || str.length() == 0) {
            return 0;
        }
        boolean startFlag = true;
        Integer start = null;
        Integer end = null;

        boolean firstFlag = true;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c != ' ') {
                if (firstFlag && ((c > 57 || c < 48) && c != '-' && c != '+')) {
                    return 0;
                }
                firstFlag = false;
            }
        }

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (startFlag && ((c <= 57 && c >= 48) || c == '-' || c == '+')) {
                start = i;
                startFlag = false;
                continue;
            }
            if (start != null && (c > 57 || c < 48) && c != '-' && c != '+') {
                end = i;
                break;
            }
        }
        if (end == null) {
            end = str.length();
        }
        String ss = str.substring(start, end);
        Integer sss = 0;
        try {
            sss = Integer.valueOf(ss);
        } catch (Exception e) {
            if(ss.indexOf("+") > -1 && ss.indexOf("-") > -1 && ss.length() > 1){
                return 0;
            }
            if (ss.indexOf("-") > -1  &&  ss.length() > 1) {
                return Integer.MIN_VALUE;
            }
            if(ss.indexOf("+") > -1  && ss.length() > 1){
                return Integer.MAX_VALUE;
            }
            if((ss.indexOf("+") > -1  && ss.length() == 1) || (ss.indexOf("-") > -1  && ss.length() == 1)){
                return 0;
            }
            return Integer.MAX_VALUE;
        }
        return sss;
    }
}
