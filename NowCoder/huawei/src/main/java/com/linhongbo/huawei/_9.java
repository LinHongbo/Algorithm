package com.linhongbo.huawei;

import java.util.Scanner;

/**
 * 输入一个int型整数，按照从右向左的阅读顺序，返回一个不含重复数字的新的整数。
 * 输入描述:输入一个int型整数
 * <p>
 * 输出描述:按照从右向左的阅读顺序，返回一个不含重复数字的新的整数
 */
public class _9 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            StringBuilder sb = new StringBuilder(scanner.nextLine()).reverse();
            for (int i = 0; i< sb.length();) {
                char tmp = sb.charAt(i);
                int lastIndex = sb.lastIndexOf(String.valueOf(tmp));
                if(lastIndex != i) {
                    sb.deleteCharAt(lastIndex);
                } else {
                    i++;
                }
            }
            System.out.println(sb.toString());
        }
        scanner.close();
    }
}
