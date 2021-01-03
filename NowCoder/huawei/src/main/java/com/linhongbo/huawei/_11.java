package com.linhongbo.huawei;

import java.util.Scanner;

/**
 * 输入一个整数，将这个整数以字符串的形式逆序输出
 * 程序不考虑负数的情况，若数字含有0，则逆序形式也含有0，如输入为100，则输出为001
 *
 * 输入描述:输入一个int整数
 *
 * 输出描述:将这个整数以字符串的形式逆序输出
 */
public class _11 {

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
