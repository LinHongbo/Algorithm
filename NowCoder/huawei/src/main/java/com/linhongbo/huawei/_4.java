package com.linhongbo.huawei;

import java.util.Scanner;

/**
 * 连续输入字符串，请按长度为8拆分每个字符串后输出到新的字符串数组；
 * 长度不是8整数倍的字符串请在后面补数字0，空字符串不处理。
 * 输入描述:连续输入字符串(输入2次,每个字符串长度小于100)
 * 输出描述:输出到长度为8的新字符串数组
 */
public class _4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()) {
            print(scanner.nextLine());
        }
        scanner.close();
    }

    private static void print(String str) {
        if (str == null || str.length() == 0) {
            return;
        }
        int count = str.length() % 8;
        if (count != 0) {
            while (count++ < 8) {
                str += "0";
            }
        }
        for (int i = 0; i < str.length(); i += 8) {
            System.out.println(str.substring(i, i + 8));
        }
    }
}
