package com.linhongbo.huawei;

import java.util.Scanner;

/**
 * 将一个英文语句以单词为单位逆序排放。例如“I am a boy”，逆序排放后为“boy a am I”
 * 所有单词之间用一个空格隔开，语句中除了英文字母外，不再包含其他字符
 * <p>
 * 输入描述:将一个英文语句以单词为单位逆序排放。
 * <p>
 * 输出描述:得到逆序的句子
 */
public class _13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String[] data = scanner.nextLine().split(" ");
            if (data.length < 1) {
                continue;
            }
            StringBuilder sb = new StringBuilder(data[data.length - 1]);
            for (int i = data.length - 2; i >= 0; i--) {
                sb.append(" ").append(data[i]);
            }
            System.out.println(sb.toString());
        }
        scanner.close();
    }
}
