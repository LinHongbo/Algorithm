package com.linhongbo.huawei;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 开发一个坐标计算工具， A表示向左移动，D表示向右移动，W表示向上移动，S表示向下移动。从（0,0）点开始移动，从输入字符串里面读取一些坐标，并将最终输入结果输出到输出文件里面。
 * <p>
 * 输入：合法坐标为A(或者D或者W或者S) + 数字（两位以内）
 * 坐标之间以;分隔。
 * 非法坐标点需要进行丢弃。如AA10;  A1A;  $%$;  YAD; 等。
 * 注意请处理多组输入输出
 * <p>
 * 输入描述:一行字符串
 * <p>
 * 输出描述:最终坐标，以,分隔
 */
public class _17 {

    private static final Pattern mPattern = Pattern.compile("^[WSAD]\\d{1,2}$");

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            int x = 0, y = 0;
            List<String> actions = new ArrayList<>();
            Arrays.asList(scanner.nextLine().split(";")).forEach(item -> {
                Matcher matcher = mPattern.matcher(item);
                if(matcher.matches()) {
                    actions.add(item);
                }
            });
            for (String action : actions) {
                int length = Integer.parseInt(action.substring(1));
                switch (action.charAt(0)) {
                    case 'W':
                        y += length;
                        break;
                    case 'S':
                        y -= length;
                        break;
                    case 'A':
                        x -= length;
                        break;
                    case 'D':
                        x += length;
                        break;
                    default:
                        break;
                }
            }
            System.out.println(x + "," + y);
        }
        scanner.close();
    }
}
