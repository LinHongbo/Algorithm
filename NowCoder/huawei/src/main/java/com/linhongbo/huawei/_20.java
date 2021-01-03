package com.linhongbo.huawei;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * 密码要求:
 * 1.长度超过8位
 * 2.包括大小写字母.数字.其它符号,以上四种至少三种
 * 3.不能有相同长度超2的子串重复
 * 说明:长度超过2的子串
 * <p>
 * 输入描述:一组或多组长度超过2的子符串。每组占一行
 * 输出描述:如果符合要求输出：OK，否则输出NG
 */
public class _20 {

    private static final Pattern p1 = Pattern.compile("[a-z]");
    private static final Pattern p2 = Pattern.compile("[A-Z]");
    private static final Pattern p3 = Pattern.compile("[0-9]");
    private static final Pattern p4 = Pattern.compile("[^a-zA-Z0-9]");
    private static final Pattern p5 = Pattern.compile("(.{3,}).*\\1");

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            if (input.length() <= 8) {
                System.out.println("NG");
                continue;
            }
            int count = 1;
            count = p1.matcher(input).find() ? count << 1 : count;
            count = p2.matcher(input).find() ? count << 1 : count;
            count = p3.matcher(input).find() ? count << 1 : count;
            count = p4.matcher(input).find() ? count << 1 : count;
            if (count >= 8 && !p5.matcher(input).find()) {
                System.out.println("OK");
            } else {
                System.out.println("NG");
            }
        }
        scanner.close();
    }
}
