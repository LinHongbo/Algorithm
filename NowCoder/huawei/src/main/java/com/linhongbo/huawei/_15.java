package com.linhongbo.huawei;

import java.util.Scanner;

/**
 * 输入一个int型的正整数，计算出该int型数据在内存中存储时1的个数。
 * 输入描述:输入一个整数（int类型）
 * <p>
 * 输出描述:这个数转换成2进制后，输出1的个数
 */
public class _15 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            int data = Integer.valueOf(scanner.nextLine());
            int count = 0;
            while (data != 0b0) {
                count += data & 0b1;
                data >>>= 1;
            }
            System.out.println(count);
        }
        scanner.close();
    }
}
