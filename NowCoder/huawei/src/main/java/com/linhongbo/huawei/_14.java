package com.linhongbo.huawei;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 给定n个字符串，请对n个字符串按照字典序排列。
 * 输入描述:输入第一行为一个正整数n(1≤n≤1000),下面n行为n个字符串(字符串长度≤100),字符串中只含有大小写字母。
 * 输出描述:数据输出n行，输出结果为按照字典序排列的字符串。
 */
public class _14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            int count = Integer.valueOf(scanner.nextLine());
            List<String> result = new ArrayList<>();
            for (int i = 0; i < count; i++) {
                result.add(scanner.nextLine());
            }
            Collections.sort(result);
            result.forEach(item -> {
                System.out.println(item);
            });
        }
        scanner.close();
    }
}
