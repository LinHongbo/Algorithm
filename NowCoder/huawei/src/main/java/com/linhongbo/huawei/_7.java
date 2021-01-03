package com.linhongbo.huawei;

import java.util.Scanner;

/**
 * 写出一个程序，接受一个正浮点数值，输出该数值的近似整数值。如果小数点后数值大于等于5,向上取整；小于5，则向下取整。
 * 输入描述:输入一个正浮点数值
 *
 * 输出描述:输出该数值的近似整数值
 */
public class _7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if(scanner.hasNextFloat()){
            float f1 = scanner.nextFloat();
            int result = Float.valueOf(f1).intValue();
            float f2 = result + 0.5f;
            if(Float.compare(f1, f2) != -1 ) {
                result += 1;
            }
            System.out.println(result);
        }
        scanner.close();
    }
}
