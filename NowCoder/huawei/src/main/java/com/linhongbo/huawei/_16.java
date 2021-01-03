package com.linhongbo.huawei;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * 王强今天很开心，公司发给N元的年终奖。王强决定把年终奖用于购物，他把想买的物品分为两类：主件与附件，
 * 附件是从属于某个主件的，下表就是一些主件与附件的例子：
 * 主件	    附件
 * 电脑	    打印机，扫描仪
 * 书柜	    图书
 * 书桌	    台灯，文具
 * 工作椅	无
 * 如果要买归类为附件的物品，必须先买该附件所属的主件。每个主件可以有 0 个、 1 个或 2 个附件。附件不再有从属于自己的附件。
 * 王强想买的东西很多，为了不超出预算，他把每件物品规定了一个重要度，分为 5 等：用整数 1 ~ 5 表示，第 5 等最重要。
 * 他还从因特网上查到了每件物品的价格（都是 10 元的整数倍）。他希望在不超过 N 元（可以等于 N 元）的前提下，
 * 使每件物品的价格与重要度的乘积的总和最大。
 * <p>
 * 设第 j 件物品的价格为 v[j] ，重要度为 w[j] ，共选中了 k 件物品，编号依次为 j 1 ， j 2 ，……， j k ，
 * 则所求的总和为：v[j 1 ]*w[j 1 ]+v[j 2 ]*w[j 2 ]+ … +v[j k ]*w[j k ] 。（其中 * 为乘号）
 * <p>
 * 请你帮助王强设计一个满足要求的购物单。
 * 输入描述:输入的第 1 行，为两个正整数，用一个空格隔开：N m
 * （其中 N （ <32000 ）表示总钱数， m （ <60 ）为希望购买物品的个数。）
 * 从第 2 行到第 m+1 行，第 j 行给出了编号为 j-1 的物品的基本数据，每行有 3 个非负整数 v p q
 * （其中 v 表示该物品的价格（ v<10000 ）， p 表示该物品的重要度（ 1 ~ 5 ）， q 表示该物品是主件还是附件。
 * 如果 q=0 ，表示该物品为主件，如果 q>0 ，表示该物品为附件， q 是所属主件的编号）
 * <p>
 * 输出描述:输出文件只有一个正整数，为不超过总钱数的物品的价格与重要度乘积的总和的最大值（ <200000 ）。
 */
public class _16 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int cost, count;
        while (scanner.hasNextLine()) {
            String[] msg = scanner.nextLine().split(" ");
            if (msg.length == 1) {
                System.out.println(0);
                continue;
            }
            cost = Integer.parseInt(msg[0]) / 10;
            count = Integer.parseInt(msg[1]);
            Good[][] goods = initGoods(scanner, count);
            int[] result = new int[cost + 1];
            for (int i = 1; i <= count; i++) {
                for (int j = result.length - 1; j >= 0 && goods[i][0] != null; j--) {
                    int tmp = getMax(result, j, result[j], goods[i][0]);
                    if (goods[i][1] != null && goods[i][2] != null) {
                        tmp = getMax(result, j, tmp, goods[i][0], goods[i][1], goods[i][2]);
                    }
                    if (goods[i][1] != null) {
                        tmp = getMax(result, j, tmp, goods[i][0], goods[i][1]);
                    }
                    if (goods[i][2] != null) {
                        tmp = getMax(result, j, tmp, goods[i][0], goods[i][2]);
                    }
                    result[j] = tmp;
                }
            }
            System.out.println(result[result.length - 1] * 10);
        }
        scanner.close();
    }

    private static int getMax(int[] result, int targetIndex, int tmp, Good... goods) {
        int subV = 0;
        int addVP = 0;
        for (Good good : goods) {
            subV += good.v;
            addVP += good.vp;
        }
        if (targetIndex >= subV) {
            return Math.max(tmp, result[targetIndex - subV] + addVP);
        } else {
            return tmp;
        }
    }

    private static Good[][] initGoods(Scanner scanner, int count) {
        Good[][] goods = new Good[count + 1][4];
        for (int i = 1; i <= count; i++) {
            String[] data = scanner.nextLine().split(" ");
            Good good = new Good(data[0], data[1]);
            if (Integer.parseInt(data[2]) == 0) {
                goods[i][0] = good;
            } else {
                int mainIndex = Integer.parseInt(data[2]);
                if (goods[mainIndex][1] == null) {
                    goods[mainIndex][1] = good;
                } else {
                    goods[mainIndex][2] = good;
                }
            }
        }
        return goods;
    }

    private static class Good {
        int v;
        int vp;

        public Good(String v, String p) {
            this.v = Integer.parseInt(v) / 10;
            this.vp = this.v * Integer.parseInt(p);
        }
    }
}