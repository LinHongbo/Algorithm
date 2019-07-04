package Interview3;

/**
 * 题目1:找出数组中重复的数字 在一个长度为 n 的数组里，所有数字都在0～n-1的范围内。数组中某些数字是重复的，但不知道有几个数字
 * 重复了，也不知道每个数字重复了几次。请找出数字中任意一个重复数字。例如，如果输入长度为 7 的数组
 * {2，3，1，0，2，5，3}，那么对应的输出是重复的数字 2 或者 3。
 * 
 * @author linhongbo
 *
 */
public class Interview3_1 {
	public static void main(String[] args) {
		int[] src = { 2, 3, 1, 0, 2, 5, 3 };
		int result = duplicate(src);
		System.out.println(result);
	}

	private static int duplicate(int[] src) {
		if (!checkInput(src)) {
			return -1;
		}
		for (int i = 0; i < src.length;) {
			int j = src[i];
			if (j == i) {
				i++;
			} else if(src[j] == j){
				return j;
			} else {
				src[j] = src[i];
				src[j] = j;
			}
		}
		return -1;
	}

	private static boolean checkInput(int[] src) {
		if (src == null || src.length <= 0) {
			return false;
		}
		for (int i : src) {
			if (i < 0 || i >= src.length)
				return false;
		}
		return true;
	}
}
