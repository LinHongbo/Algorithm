package com.linhongbo.huawei;

import java.util.Scanner;

/**
 * 计算最少出列多少位同学，使得剩下的同学排成合唱队形
 * 说明：
 * N位同学站成一排，音乐老师要请其中的(N-K)位同学出列，使得剩下的K位同学排成合唱队形。
 * 合唱队形是指这样的一种队形：设K位同学从左到右依次编号为1，2…，K，他们的身高分别为T1，T2，…，TK，   则他们的身高满足存在i（1<=i<=K）使得T1<T2<......<Ti-1<Ti>Ti+1>......>TK。
 * 你的任务是，已知所有N位同学的身高，计算最少需要几位同学出列，可以使得剩下的同学排成合唱队形。
 * 注意不允许改变队列元素的先后顺序
 * 请注意处理多组输入输出！
 * <p>
 * 输入描述:整数N
 * <p>
 * 输出描述:最少需要几位同学出列
 */
public class _24 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextLine()) {
            int count = Integer.parseInt(scanner.nextLine());
            if (count <= 0) {
                return;
            }
            String[] data = scanner.nextLine().split(" ");
            count = data.length;
            int[] inputs = new int[count];
            for (int i = 0; i < count; i++) {
                inputs[i] = Integer.parseInt(data[i]);
            }
            int[] aec = calculate(inputs, true);
            int[] desc = calculate(inputs, false);
            int ret = 0;
            for (int i = 0; i < count; i++) {
                ret = Math.max(aec[i] + desc[i] + 1, ret);
            }
            System.out.println(count - ret);
        }
        scanner.close();
    }

    private static int[] calculate(int[] src, boolean isUp) {
        int[] result = new int[src.length];
        int[] max = new int[src.length];
        int maxIndex = 0;
        max[0] = isUp ? src[0] : src[src.length - 1];
        for (int i = 1; i < src.length; i++) {
            int targetIndex = isUp ? i : src.length - 1 - i;
            int privIndex = isUp ? targetIndex - 1 : targetIndex + 1;
            if (src[targetIndex] > max[maxIndex]) {
                max[++maxIndex] = src[targetIndex];
                result[targetIndex] = result[privIndex] + 1;
            } else {
                for (int j = 0; j <= maxIndex; j++) {
                    if (max[j] >= src[targetIndex]) {
                        max[j] = src[targetIndex];
                        break;
                    }
                }
                result[targetIndex] = result[privIndex];
            }
        }
        return result;
    }
}