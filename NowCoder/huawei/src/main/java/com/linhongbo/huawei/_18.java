package com.linhongbo.huawei;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * 请解析IP地址和对应的掩码，进行分类识别。要求按照A/B/C/D/E类地址归类，不合法的地址和掩码单独归类。
 * 所有的IP地址划分为 A,B,C,D,E五类
 * A类地址1.0.0.0~126.255.255.255;
 * B类地址128.0.0.0~191.255.255.255;
 * C类地址192.0.0.0~223.255.255.255;
 * D类地址224.0.0.0~239.255.255.255；
 * E类地址240.0.0.0~255.255.255.255
 * <p>
 * 私网IP范围是：
 * 10.0.0.0～10.255.255.255
 * 172.16.0.0～172.31.255.255
 * 192.168.0.0～192.168.255.255
 * <p>
 * 子网掩码为二进制下前面是连续的1，然后全是0。（例如：255.255.255.32就是一个非法的掩码）
 * 注意二进制下全是1或者全是0均为非法
 * <p>
 * 注意：
 * 1. 类似于【0.*.*.*】和【127.*.*.*】的IP地址不属于上述输入的任意一类，也不属于不合法ip地址，计数时可以忽略
 * 2. 私有IP地址和A,B,C,D,E类地址是不冲突的
 * <p>
 * 输入描述:多行字符串。每行一个IP地址和掩码，用~隔开。
 * <p>
 * 输出描述:统计A、B、C、D、E、错误IP地址或错误掩码、私有IP的个数，之间以空格隔开。
 */
public class _18 {

    private static long aStart = turn2Long("1.0.0.0");
    private static long bStart = turn2Long("128.0.0.0");
    private static long aEnd = turn2Long("126.255.255.255");
    private static long bEnd = turn2Long("191.255.255.255");
    private static long cStart = turn2Long("192.0.0.0");
    private static long cEnd = turn2Long("223.255.255.255");
    private static long dStart = turn2Long("224.0.0.0");
    private static long dEnd = turn2Long("239.255.255.255");
    private static long eStart = turn2Long("240.0.0.0");
    private static long eEnd = turn2Long("255.255.255.255");
    private static long pri1Start = turn2Long("10.0.0.0");
    private static long pri1End = turn2Long("10.255.255.255");
    private static long pri2Start = turn2Long("172.16.0.0");
    private static long pri2End = turn2Long("172.31.255.255");
    private static long pri3Start = turn2Long("192.168.0.0");
    private static long pri3End = turn2Long("192.168.255.255");
    private static int countA, countB, countC, countD, countE, countErr, countPri;

    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();
        File file = new File("input.txt");
//        Scanner scanner = new Scanner(System.in);
        Scanner scanner = new Scanner(file);
        while (scanner.hasNext()) {
            String[] input = scanner.next().split("~");
            long ip = turn2Long(input[0]);
            long mask = turn2Long(input[1]);
            if (checkMask(mask)) {
                if (checkIp(ip)) {
                    checkPriIp(ip);
                }
            }
        }
        System.out.println(countA + " " + countB + " " + countC + " " + countD + " " + countE + " " + countErr + " " + countPri);
        scanner.close();
        System.out.println(System.currentTimeMillis() - start);
    }

    private static boolean checkIp(long ip) {
        if (ip >= aStart && ip <= aEnd) {
            countA++;
        } else if (ip >= bStart && ip <= bEnd) {
            countB++;
        } else if (ip >= cStart && ip <= cEnd) {
            countC++;
        } else if (ip >= dStart && ip <= dEnd) {
            countD++;
        } else if (ip >= eStart && ip <= eEnd) {
            countE++;
        } else if (ip < 0 || ip > eEnd) {
            countErr++;
            return false;
        }
        return true;
    }

    private static boolean checkMask(long mask) {
        if (mask <= 0 || mask >= eEnd) {
            countErr++;
            return false;
        }
        int target = 0b0;
        while (mask != 0) {
            if ((mask & 0b1) != target) {
                if (target == 0b0) {
                    target = 0b1;
                } else {
                    countErr++;
                    return false;
                }
            }
            mask >>>= 1;
        }
        return true;
    }

    private static void checkPriIp(long ip) {
        if (ip >= pri1Start && ip <= pri1End || ip >= pri2Start && ip <= pri2End || ip >= pri3Start && ip <= pri3End) {
            countPri++;
        }
    }

    private static long turn2Long(String address) {
        long result = 0;
        String[] addresses = address.split("\\.");
        for (int i = 0; i < addresses.length; i++) {
            try {
                result |= Long.parseLong(addresses[i]) << 8 * (addresses.length - i - 1);
            } catch (Exception e) {
                return -1;
            }
        }
        return result;
    }
}