package com.linhongbo.huawei;

/**
 * 功能:输入一个正整数，按照从小到大的顺序输出它的所有质因子（重复的也要列举）（如180的质因子为2 2 3 3 5 ）
 * <p>
 * 最后一个数后面也要有空格
 * <p>
 * 详细描述：
 * <p>
 * <p>
 * 函数接口说明：public String getResult(long ulDataInput)
 * <p>
 * 输入参数： long ulDataInput：输入的正整数
 * <p>
 * 返回值：String
 * <p>
 * 输入描述:输入一个long型整数
 * <p>
 * 输出描述:按照从小到大的顺序输出它的所有质数的因子，以空格隔开。最后一个数后面也要有空格。
 */
public class _6 {

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        while(scanner.hasNextLong()) {
//            System.out.println(getResult(scanner.nextLong()));
//        }
//        scanner.close();

        System.out.println(getResult(180));
    }

    public static String getResult(long ulDataInput) {
        String result = "";

        for (int j = 2; j < ulDataInput - 1;) {
            if (ulDataInput % j == 0) {
                ulDataInput /=  j;
                result += j + " ";
                j = 2;
            } else {
                j++;
            }
        }
        return result + ulDataInput;
    }
}
