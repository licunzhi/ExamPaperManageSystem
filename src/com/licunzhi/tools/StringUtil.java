package com.licunzhi.tools;

import org.junit.Test;

public class StringUtil {


    //ȥ��ָ��λ�õĶ���
    public static String[] removeSd(String str) {
        if (str != null && str != "") {
            String str1 = str.replace(".,", ".");
            str1 = str1.replace(",", ">");
            String str2[] = str1.split(">");
            System.out.println(str2);
            return str2;
        } else {
            String[] str2 = new String[]{"����ʾѡ��"};
            return str2;
        }
    }

    @Test
    public void removeTips() {
        String str = " A., ��, B., ����, C., �ǻ��߲���, D., ��˵�Ǿ���";
        String str1 = str.replace(".,", ".");
        str1 = str1.replace(",", ">");
        String str2[] = str1.split(">");
        for (String s : str2) {
            System.out.println(s);
        }
    }
}
