package com.linhongbo.huawei;

import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * 数据表记录包含表索引和数值（int范围的整数），请对表索引相同的记录进行合并，即将相同索引的数值进行求和运算，输出按照key值升序进行输出。
 * 输入描述:
 * 先输入键值对的个数
 * 然后输入成对的index和value值，以空格隔开
 * <p>
 * 输出描述:
 * 输出合并后的键值对（多行）
 */
public class _8 {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        SortedMap<Integer, Integer> map = new TreeMap<>();
//        while (scanner.hasNextLine()) {
//            int n = Integer.valueOf(scanner.nextLine());
//            for (int i = 0; i < n; i++) {
//                String[] msg = scanner.nextLine().split(" ");
//                int key = Integer.valueOf(msg[0]);
//                int value = Integer.valueOf(msg[1]);
//                if (map.containsKey(key)) {
//                    value += map.get(key);
//                }
//                map.put(key, value);
//            }
//            System.out.println(mapToString(map));
//        }
//        scanner.close();
//    }
//
//    private static String mapToString(TreeMap<Integer, Integer> map) {
//        StringBuilder builder = new StringBuilder();
//        map.forEach((Integer key, Integer value) -> {
//            builder.append(key).append(" ").append(value).append("\r");
//        });
//        return builder.toString();
//    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeMap<Integer, Integer> map = new TreeMap<>();
        while (scanner.hasNextLine()) {
            int n = Integer.parseInt(scanner.nextLine());
            for (int i = 0; i < n; i++) {
                String[] msg = scanner.nextLine().split("\\s+");
                addPare(map, msg);
            }
            System.out.println(mapToString(map));
        }
        scanner.close();
    }

    private static String mapToString(TreeMap<Integer, Integer> map) {
//        StringBuilder builder = new StringBuilder();
//        map.forEach((Integer key, Integer value) -> {
//            builder.append(key).append(" ").append(value).append("\r");
//        });
//        return builder.toString();
        StringBuilder builder = new StringBuilder();
        for(SortedMap.Entry<Integer,Integer>e:map.entrySet()){
            builder.append(e.getKey()).append(" ").append(e.getValue()).append("\r");
        }
        return builder.toString();
    }

    private static void addPare(SortedMap<Integer, Integer> map, String[] msg) {
        // TODO Auto-generated method stub
        int key = Integer.parseInt(msg[0]);
        int value = Integer.parseInt(msg[1]);
        if (map.containsKey(key)) {
            value += map.get(key);
        }
        map.put(key, value);
    }
}
