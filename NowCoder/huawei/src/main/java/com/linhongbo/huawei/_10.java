package com.linhongbo.huawei;

import java.util.Scanner;

/**
 * 编写一个函数，计算字符串中含有的不同字符的个数。字符在ACSII码范围内(0~127)，换行表示结束符，不算在字符里。
 * 不在范围内的不作统计。注意是不同的字符
 * 输入描述:输入N个字符，字符在ACSII码范围内。
 * 输出描述:输出范围在(0~127)字符的个数。
 */
public class _10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] result = new int[128];
        int count = 0;
        while (scanner.hasNextLine()) {
            String data = scanner.nextLine();
            for (char c : data.toCharArray()) {
                if (c < 0 || c > 127) {
                    continue;
                }
                if (result[c] == 0) {
                    result[c]++;
                    count++;
                }
            }
            System.out.println(count);
        }
        scanner.close();
    }
}
