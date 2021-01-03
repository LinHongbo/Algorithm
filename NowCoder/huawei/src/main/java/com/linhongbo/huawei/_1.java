package com.linhongbo.huawei;

import java.util.Scanner;

/**
 * 计算字符串最后一个单词的长度，单词以空格隔开。
 * 输入描述:一行字符串，非空，长度小于5000。
 * 输出描述:整数N，最后一个单词的长度。
 */
public class _1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if(scanner.hasNextLine()) {
            String word = scanner.nextLine();
            System.out.println(getLastWordLength(word));
        }
    }

    private static int getLastWordLength(String word) {
        if (word == null || word.length() > 5000) {
            return -1;
        }
        String[] list = word.split(" ");
        String result = list[list.length - 1];
        return result.length();
    }
}
