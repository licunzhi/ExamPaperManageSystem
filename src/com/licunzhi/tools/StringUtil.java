package com.licunzhi.tools;

import org.junit.Test;

public class StringUtil {


    //去除指定位置的逗号
    public static String[] removeSd(String str) {
        if (str != null && str != "") {
            String str1 = str.replace(".,", ".");
            str1 = str1.replace(",", ">");
            String str2[] = str1.split(">");
            System.out.println(str2);
            return str2;
        } else {
            String[] str2 = new String[]{"无显示选项"};
            return str2;
        }
    }

    @Test
    public void removeTips() {
        String str = " A., 是, B., 不是, C., 是或者不是, D., 你说是就是";
        String str1 = str.replace(".,", ".");
        str1 = str1.replace(",", ">");
        String str2[] = str1.split(">");
        for (String s : str2) {
            System.out.println(s);
        }
    }
}
