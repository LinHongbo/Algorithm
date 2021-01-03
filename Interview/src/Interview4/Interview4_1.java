package Interview4;

import java.util.Scanner;

/**
 * 题目：在一个二维数组中，每一行都按照从左到右递增的顺序排序， 每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的
 * 一个二维数组合一个整数，判断数组中是否含有该整数。
 * 
 * @author linhongbo
 *
 */
public class Interview4_1 {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cost, count;
        while (scanner.hasNextLine()) {
            String[] msg = scanner.nextLine().split(" ");
            cost = Integer.parseInt(msg[0]) / 10;
            count = Integer.parseInt(msg[1]);
            Good[][] goods = initGoods(scanner, count);
            int[] result = new int[cost + 1];
            for (int i = 1; i < result.length; i++) {
            	if(i < 40) {
            		continue;
            	}
            	for (int j = 0; j < count + 1 && goods[j][0] != null; j++) {
                	
                    result[i] = result[i - 1];
                    if (i >= goods[j][0].v) {
                        result[i] = Math.max(result[i], result[i - goods[j][0].v] + goods[j][0].vp);
                    }
                    if (goods[j][1] != null) {
                        if (i >= goods[j][0].v + goods[j][1].v) {
                            result[i] = Math.max(result[i], result[i - goods[j][0].v - goods[j][1].v] + goods[j][0].vp + goods[j][1].vp);
                        }
                    }
                    if (goods[j][2] != null) {
                        if (i >= goods[j][0].v + goods[j][2].v) {
                            result[i] = Math.max(result[i], result[i - goods[j][0].v - goods[j][2].v] + goods[j][0].vp + goods[j][2].vp);
                        }
                    }
                    if (goods[j][2] != null && goods[j][2] != null) {
                        if (i >= goods[j][0].v + goods[j][1].v + goods[j][2].v) {
                            result[i] = Math.max(result[i], result[i - goods[j][0].v - goods[j][1].v - goods[j][2].v] + goods[j][0].vp + goods[j][1].vp + goods[j][2].vp);
                        }
                    }
                }
            }
            for(int i = 0; i< result.length; i++){
            	System.out.println(result[i]);
            }
        }
        scanner.close();
    }

//    private static void compare(int[] result, int resultIndex, Good[] good, int goodIndex) {
//        if (resultIndex >= good[goodIndex].v) {
//            result[resultIndex] = Math.max(result[resultIndex - good[goodIndex].v], good[goodIndex].vp);
//        } else if (resultIndex >= ) {
//
//        } else {
//            result[resultIndex] = result[resultIndex - good[goodIndex].v];
//        }
//    }

    private static Good[][] initGoods(Scanner scanner, int count) {
        Good[][] goods = new Good[count + 1][4];
        for (int i = 0; i < count; i++) {
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
