package com.linhongbo.huawei;

import java.io.File;
import java.util.Scanner;

/**
 * Catcher是MCA国的情报员，他工作时发现敌国会用一些对称的密码进行通信，比如像这些ABBA，ABA，A，123321，
 * 但是他们有时会在开始或结束时加入一些无关的字符以防止别国破解。比如进行下列变化 ABBA->12ABBA,ABA->ABAKK,123321->51233214　。
 * 因为截获的串太长了，而且存在多种可能的情况（abaaab可看作是aba,或baaab的加密形式），Cathcer的工作量实在是太大了，
 * 他只能向电脑高手求助，你能帮Catcher找出最长的有效密码串吗?
 * <p>
 * 输入描述: 输入一个字符串
 * <p>
 * 输出描述: 返回有效密码串的最大长度
 */
public class _32 {
    public static void main(String[] args) throws Exception{
//        Scanner scanner = new Scanner(System.in);
        Scanner scanner = new Scanner(new File("input.txt"));
        while (scanner.hasNextLine()) {
            int result = manacher(scanner.nextLine());
            System.out.println(result);
        }
        scanner.close();
    }

    private static int manacher(String input) {
        String t = init(input.toCharArray());
        int c = 0, r = 0;
        int[] p = new int[t.length()];
        for (int i = 1; i < p.length - 1; i++) {
            int mirrorI = c * 2 - i;
            if(r > i) {
                p[i] = Math.min(p[mirrorI], r - i);
            } else {
                p[i] = 0;
            }
            while(t.charAt(i + p[i] + 1) == t.charAt(i - p[i] -1)) {
                p[i]++;
            }

            if(i + p[i] > r) {
                c = i;
                r = i + p[i];
            }
        }
        int maxIndex = 0;
        for (int i =0; i< t.length(); i++) {
            maxIndex = p[maxIndex] <= p[i] ? i : maxIndex;
        }
        return p[maxIndex];
    }

    private static String init(char[] input) {
        if (input.length == 0) {
            return "^$";
        }

        StringBuilder result = new StringBuilder();
        result.append("^#");
        for (char c : input) {
            result.append(c).append('#');
        }
        result.append('$');
        return result.toString();
    }
}
