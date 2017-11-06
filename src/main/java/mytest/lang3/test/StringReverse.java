package mytest.lang3.test;

import java.io.UnsupportedEncodingException;

/**
 * Created by guxiaoli on 30/08/2017.
 */
public class StringReverse {

    public static String reverse(String originStr) {
        if (originStr == null || originStr.length() <= 1)
            return originStr;
        return reverse(originStr.substring(1)) + originStr.charAt(0);
    }

    public static void main(String[] args) throws UnsupportedEncodingException {
        String s1 = "你好";
        String s2 = new String(s1.getBytes("GB2312"), "ISO-8859-1");
        System.out.println(s2);
    }
}
