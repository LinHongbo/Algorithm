package Interview3;

/**
 * 题目2：不修改数组找出重复的数字
 * 在一个长度为 n+1 的数组里，所有数字都在 1～n 的范围内，所以数组 中至少有一个数字
 * 是重复的。请找出数组中任意一个重复的数字，但不能修改输入的数组。例如：如果输入长度为
 * 8 的数组 {2,3,5,4,3,2,6,7},那么对应的输出是重复的数字 2 或者 3。
 * @author linhongbo
 *
 */
public class Interview3_2 {
	public static void main(String[] args) {
        int[] src = new int[]{2, 3, 5, 4, 2, 3, 6, 7};
        int result = duplicate(src);
        System.out.println(result);
    }

    private static int duplicate(int[] src) {
        if (!checkInput(src)) {
            return -1;
        }
        int left = 1, right = src.length - 1, mid;
        int leftNum;
        do {
            mid = (left + right) / 2;
            leftNum = 0;
            for (int i = 0; i < src.length; i++) {
                if (src[i] >= left && src[i] <= mid) {
                    leftNum++;
                }
            }
            if (leftNum > (mid - left + 1)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        } while (right != left);
        return left;
    }

    private static boolean checkInput(int[] src) {
        if (src == null || src.length <= 0) {
            return false;
        }
        for (int i : src) {
            if (i == 0 || i >= src.length) return false;
        }
        return true;
    }
}
