package com.linhongbo.huawei;

import java.util.Scanner;

/**
 * 对字符串中的所有单词进行倒排。
 * <p>
 * 说明：
 * <p>
 * 1、构成单词的字符只有26个大写或小写英文字母；
 * <p>
 * 2、非构成单词的字符均视为单词间隔符；
 * <p>
 * 3、要求倒排后的单词间隔符以一个空格表示；如果原字符串中相邻单词间有多个间隔符时，倒排转换后也只允许出现一个空格间隔符；
 * <p>
 * 4、每个单词最长20个字母；
 * <p>
 * 输入描述:输入一行以空格来分隔的句子
 * <p>
 * 输出描述:输出句子的逆序
 */
public class _31 {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            if (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                String[] result = data.split("[^a-z|\\^A-Z]+");
                if(result.length > 0) {
                    StringBuilder sb = new StringBuilder(result[result.length - 1]);
                    for (int i = result.length - 2; i >= 0; i--) {
                        sb.append(" ").append(result[i]);
                    }
                    System.out.println(sb.toString().trim());
                }
            }
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
