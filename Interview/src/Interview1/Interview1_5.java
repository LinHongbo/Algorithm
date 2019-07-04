package Interview1;

/**
 * 题目：设计一个类，我们只能生成该类的一个实例
 * @author linhongbo
 *
 */
public class Interview1_5 {

	public static void main(String[] args) throws InterruptedException {
		while (true) {
			Singleton.getInstance();
			Thread.sleep(1000);
		}
	}

	public static class Singleton {
		
		public static Singleton getInstance(){
			return Inner.instance;
		}
		
		private static class Inner {
			private static Singleton instance;
			static {
				System.out.println("helloworld");
				instance = new Singleton();
			}
		}
	}
}
