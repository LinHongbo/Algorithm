package com.linhongbo.huawei;

import java.util.Scanner;

/**
 * 写出一个程序，接受一个由字母和数字组成的字符串，和一个字符，然后输出输入字符串中含有该字符的个数。不区分大小写。
 * 输入描述:第一行输入一个有字母和数字以及空格组成的字符串，第二行输入一个字符。
 * 输出描述:输出输入字符串中含有该字符的个数。
 */
public class _2 {
    public static void main(String[] args) {
        String str, c;

        Scanner scanner = new Scanner(System.in);
        if(!scanner.hasNextLine()) {
            return;
        }
        str = scanner.nextLine();
        if(!scanner.hasNextLine()) {
            return;
        }
        c = scanner.nextLine().toLowerCase();
        if(str != null && c != null && c.length() == 1) {
            char target = c.charAt(0);
            int count = 0;
            for (char item : str.toLowerCase().toCharArray()) {
                if(item == target) {
                    count++;
                }
            }
            System.out.println(count);
        }
        scanner.close();
    }
}
