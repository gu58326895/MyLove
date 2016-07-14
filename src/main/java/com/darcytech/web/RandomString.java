package com.darcytech.web;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.regex.Pattern;
import org.apache.commons.lang3.RandomStringUtils;
public class RandomString
{
    public static String genRandomNum(int passwordLength, boolean isUpperCase, boolean isUsePunctuation) {
        StringBuilder letters = new StringBuilder(128);
        for (char i = 0; i < 128; i++) {
            if (Character.isDigit(i)
                    || Character.isLowerCase(i)
                    || isUpperCase && Character.isUpperCase(i)
                    || isUsePunctuation && isPunctuation(i)) {
                letters.append(i);
            }
        }
        return RandomStringUtils.random(passwordLength, letters.toString());
    }

    public static void main(String[] args) {
        System.out.println("密码为：" + genRandomNum(getPasswordLength(args), isUpperCase(), isUsePunctuation(args)));
    }

    private static int getPasswordLength(String[] args) {
        Pattern p = Pattern.compile("\\d{1,2}");
        for (String arg : args) {
            if (p.matcher(arg).matches()) {
                return Integer.parseInt(arg);
            }
        }
        return 6;
    }

    private static boolean isUsePunctuation(String[] args) {
        for (String arg : args) {
            if ("+p".equals(arg) || "+P".equals(arg)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isUpperCase() {
        InputStream in = RandomString.class.getClassLoader().getResourceAsStream("application.properties");
        Properties p = new Properties();
        try {
            p.load(in);
        } catch (IOException e) {
            //ignore
        }
        return !"false".equalsIgnoreCase(p.getProperty("isUpperCase"));
    }

    private static boolean isPunctuation(char ch) {
        return false || (ch >= '!' && ch <= '/') || (ch >= ':' && ch <= '@') || (ch >= '[' && ch <= '`') || (ch >= '{' && ch <= '~');
    }
}
