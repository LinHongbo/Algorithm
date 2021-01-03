package com.linhongbo.huawei;

import java.util.Scanner;

/**
 * 写出一个程序，接受一个字符串，然后输出该字符串反转后的字符串。（字符串长度不超过1000）
 * 输入描述:输入N个字符
 *
 * 输出描述:输出该字符串反转后的字符串
 */
public class _12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String data = scanner.nextLine();
            StringBuilder sb = new StringBuilder(data);
            System.out.println(sb.reverse().toString());
        }
        scanner.close();
    }
}
